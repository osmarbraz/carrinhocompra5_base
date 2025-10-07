package carrinho;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Testes de integração do carrinho e serviço de pagamento. 
 */
class TestServicoPagamento {
  
    @Test
    void testNaoDeveFinalizarCarrinhoVazio() {
        //Cria o carrinho de produtos
        Carrinho carrinho = new Carrinho();
        //Não adiciona produtos

        //Cria o serviço de pagamento com saldo inicial
        ServicoPagamento pagamento = new ServicoPagamento(10.0);
        
        //Carrinho está vazio portanto não é possível pagar
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
        //Cria o carrinho de produtos
        Carrinho carrinho = new Carrinho();
        //Cria os produtos e adiciona ao carrinho
        carrinho.adicionar(new Produto("Livro", 50.0));
        carrinho.adicionar(new Produto("Caneta", 5.0));

        //Cria o serviço pagamento com saldo inicial
        ServicoPagamento pagamento = new ServicoPagamento(100.0);

        //Saldo suficiente para pagamento com o saldo inicial
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
        //Cria o carrinho de produtos
        Carrinho carrinho = new Carrinho();
        //Cria o produto e adiciona ao carrinho
        carrinho.adicionar(new Produto("Notebook", 2000.0));

        //Inicializa o saldo de pagamento
        ServicoPagamento pagamento = new ServicoPagamento(1000.0);

        //Não é possível pagar o carrinho com o saldo inicial
        boolean retornoEsperado = false;
        boolean retornoFeito = pagamento.pagar(carrinho);
        assertEquals(retornoEsperado, retornoFeito);
        
        //Saldo insuficiente
        double saldoRetornoEsperado = 2000.0;
        double saldoRetornoFeito = pagamento.getSaldo();
        assertNotEquals(saldoRetornoEsperado, saldoRetornoFeito); 
    }
}