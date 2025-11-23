package br.com.alura.luraBuy.Principal;

import br.com.alura.luraBuy.Dados.ExtratoCartao;
import br.com.alura.luraBuy.Dados.MetodoDeCompra;
import br.com.alura.luraBuy.Modelos.InterfaceMenu;

import java.util.Scanner;

public class LogicaMenu {
    private int opcaoSelecionada;
    private final InterfaceMenu interfaceMenu = new InterfaceMenu();
    private final ExtratoCartao extrato = new ExtratoCartao();
    private final MetodoDeCompra compra = new MetodoDeCompra();
    private final Principal principal;
    private final Scanner scanner = new Scanner(System.in);

    public LogicaMenu(Principal principal) {
        this.principal = principal;
    }

    public void logicaMenu(){

        while (true){
            //Metodo que imprime os indices do menu
            interfaceMenu.indiceMenu();
            System.out.print("Selecione uma Opção: ");

            //Entrada
            try {
                opcaoSelecionada = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida. Digite um número.");
                continue;
            }

            //Logica
            if (opcaoSelecionada == 1){
                System.out.println("""
                        ----------------------------
                               DADOS DA CONTA
                        ----------------------------
                        Nome: %s
                        Numero da Conta: %d
                        Limite Disponível: R$ %.2f
                        
                        ----------------------------
                        """.formatted(principal.getNomeUsuario(), principal.getNumeroConta(), principal.getSaldoLimite()));
            } else if (opcaoSelecionada == 2){
                extrato.exibirExtrato();
            } else if (opcaoSelecionada == 3){
                System.out.print("Valor para repor (pagar fatura): ");
                try {
                    double valor = Double.parseDouble(scanner.nextLine());
                    principal.repor(valor);
                    System.out.printf("Saldo reposto. Novo limite: R$ %.2f%n", principal.getSaldoLimite());
                } catch (NumberFormatException e) {
                    System.out.println("Valor inválido.");
                }
            } else if (opcaoSelecionada == 4){
                compra.realizarCompraEAdicionar(scanner, extrato, principal);
                // NÃO fechar o scanner aqui
            } else if (opcaoSelecionada == 5){
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção não reconhecida.");
            }
        }

        // opcional: scanner.close(); // se quiser fechar no final do programa
    }
}
