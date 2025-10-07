package carrinho;

public class ServicoPagamento {

    private double saldo;

    public ServicoPagamento() {
        this(0.0);
    }

    public ServicoPagamento(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Verifica se o valor do saldo é suficiente para pagar o carrinho
     *
     * @param carrinho
     * @return Se é possível pagar o carrinho com o saldo 
     */
    public boolean pagar(Carrinho carrinho) {
        return false;
    }
}
