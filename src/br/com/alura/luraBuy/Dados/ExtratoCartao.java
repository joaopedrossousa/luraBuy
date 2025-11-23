package br.com.alura.luraBuy.Dados;

import java.util.LinkedList;
import java.util.List;

public class ExtratoCartao {

    private final List<Produto> extrato = new LinkedList<>();

    public void adicionar(Produto produto){
        extrato.add(produto);
    }

    public void exibirExtrato(){
        System.out.println("""
                ------------------------------
                      EXTRATO DE COMPRAS
                ------------------------------
                """);
        if (extrato.isEmpty()){
            System.out.println("Sem registro de compras...");
            return;
        }
        for (Produto prod : extrato){
            System.out.println(prod);
        }
    }
}
