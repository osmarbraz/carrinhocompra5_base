package carrinho;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCarrinho {
  
    @Test
    void testAdicionar() {
        //Cria o carrinho de pagamento
        Carrinho carrinho = new Carrinho();
        
        //Cria os produtos para adicionar ao carrinho
        carrinho.adicionar(new Produto("Livro", 50.0));
        carrinho.adicionar(new Produto("Caneta", 5.0));

        int retornoEsperado = 2;
        double retornoFeito = carrinho.getItens().size();
        assertEquals(retornoEsperado, retornoFeito);
    }
    
    @Test
    void testGetTotal() {
        //Cria o carrinho de pagamento
        Carrinho carrinho = new Carrinho();
        
        //Cria os produtos para adicionar ao carrinho
        carrinho.adicionar(new Produto("Livro", 50.0));
        carrinho.adicionar(new Produto("Caneta", 5.0));

        double retornoEsperado = 55.0;
        double retornoFeito = carrinho.getTotal();
        assertEquals(retornoEsperado, retornoFeito, 0.00001);
    }
 }
