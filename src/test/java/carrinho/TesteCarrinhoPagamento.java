package carrinho;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TesteCarrinhoPagamento {

    @Test
    void testTotalCarrinho() {
        //Cria o carrinho de pagamento
        Carrinho carrinho = new Carrinho();
        
        //Cria os produtos para adicionar ao carrinho
        carrinho.adicionar(new Produto("Livro", 50.0));
        carrinho.adicionar(new Produto("Caneta", 5.0));

        double retornoEsperado = 55.0;
        double retornoFeito = carrinho.getTotal();
        assertEquals(retornoEsperado, retornoFeito, 0.00001);
    }

    @Test
    void testNaoDeveFinalizarCarrinhoVazio() {
        //Cria o carrinho de pagamento
        Carrinho carrinho = new Carrinho();

        //Cria o serviço de pagamento
        ServicoPagamento pagamento = new ServicoPagamento(10.0);
        
        //Carrinho está vazio
        boolean retornoEsperado = false;
        boolean retornoFeito = pagamento.pagar(carrinho);
        assertEquals(retornoEsperado, retornoFeito);      
        
        //Verifica o total do carrinho vazio
        double saldoRetornoEsperado = 0.0;
        double saldoRetornoFeito = carrinho.getTotal();
        assertEquals(saldoRetornoEsperado, saldoRetornoFeito);
    }

    @Test
    void testDeveFinalizarCompraQuandoSaldoSuficiente() {
        //Cria os produtos para adicionar ao carrinho
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Produto("Livro", 50.0));
        carrinho.adicionar(new Produto("Caneta", 5.0));

        //Cria o serviço pagamento
        ServicoPagamento pagamento = new ServicoPagamento(100.0);

        boolean retornoEsperado = true;
        boolean retornoFeito = pagamento.pagar(carrinho);
        assertEquals(retornoEsperado, retornoFeito);

        //Verifica o total do carrinho
        double saldoRetornoEsperado = 55.0;
        double saldoRetornoFeito = carrinho.getTotal();
        assertEquals(saldoRetornoEsperado, saldoRetornoFeito);
    }

    @Test
    void testNaoDeveFinalizarCompraQuandoSaldoInsuficiente() {
        Carrinho carrinho = new Carrinho();
        carrinho.adicionar(new Produto("Notebook", 2000.0));

        ServicoPagamento pagamento = new ServicoPagamento(1000.0);

        boolean resultado = pagamento.pagar(carrinho);

        assertFalse(resultado);
        assertEquals(1000.0, pagamento.getSaldo()); // saldo não muda
    }
}
