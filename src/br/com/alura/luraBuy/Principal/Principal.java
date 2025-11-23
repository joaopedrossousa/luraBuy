package br.com.alura.luraBuy.Principal;

public class Principal {
    private String nomeUsuario = "João Pedro Sousa";
    private int numeroConta = 21092001;
    private double saldoLimite = 1000;

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public double getSaldoLimite() {
        return saldoLimite;
    }

    /**
     * Tenta debitar um valor do limite.
     * @param valor valor a debitar
     * @return true se houve saldo suficiente e o débito foi realizado; false caso contrário
     */
    public boolean debitar(double valor) {
        if (valor <= 0) return false;
        if (saldoLimite >= valor) {
            saldoLimite -= valor;
            return true;
        }
        return false;
    }

    /**
     * Repor saldo (ex.: pagar fatura)
     * @param valor valor a repor (positivo)
     */
    public void repor(double valor) {
        if (valor > 0) {
            saldoLimite += valor;
        }
    }
}
