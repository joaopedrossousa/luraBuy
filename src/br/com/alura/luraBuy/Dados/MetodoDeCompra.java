package br.com.alura.luraBuy.Dados;

import br.com.alura.luraBuy.Principal.Principal;

import java.util.Scanner;

public class MetodoDeCompra {

    public Produto realizarCompra (Scanner scanner){
        System.out.print("Produto: ");
        scanner.nextLine(); // consome newline pendente do menu (se houver)
        String nome = scanner.nextLine();

        System.out.print("Valor: ");
        double valor = scanner.nextDouble();

        // NÃO fechar o scanner aqui (System.in)
        return new Produto(nome, valor);
    }

    /**
     * Realiza a compra, verifica saldo no Principal e adiciona ao extrato somente se o débito for possível.
     */
    public void realizarCompraEAdicionar(Scanner scanner, ExtratoCartao extrato, Principal principal){
        Produto prod = realizarCompra(scanner);

        if (prod.getValor() <= 0) {
            System.out.println("Valor inválido para o produto.");
            return;
        }

        boolean debitoOk = principal.debitar(prod.getValor());
        if (debitoOk) {
            extrato.adicionar(prod);
            System.out.println("Compra realizada com sucesso: " + prod);
            System.out.printf("Novo limite disponível: R$ %.2f%n", principal.getSaldoLimite());
        } else {
            System.out.println("Saldo insuficiente. Compra negada.");
            System.out.printf("Limite disponível: R$ %.2f%n", principal.getSaldoLimite());
        }
    }
}
