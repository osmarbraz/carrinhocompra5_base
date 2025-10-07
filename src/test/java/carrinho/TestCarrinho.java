package carrinho;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Testes unitários do carrinho. 
 */
class TestCarrinho {
  
    @Test
    void testAdicionar() {
        //Cria o carrinho de pagamento
        Carrinho carrinho = new Carrinho();
        
        //Cria os produtos para adicionar ao carrinho
        carrinho.adicionar(new Produto("Livro", 50.0));
        carrinho.adicionar(new Produto("Caneta", 5.0));

        //Quantidade de produtos esperado
        int retornoEsperado = 2;
        double retornoFeito = carrinho.getQuantidadeProdutos();
        assertEquals(retornoEsperado, retornoFeito);

        //Valores a serem esperados
        String retornoNomeEsperado1 = "Livro";
        double retornoPrecoEsperado1 = 50.0;
        String retornoNomeEsperado2 = "Caneta";
        double retornoPrecoEsperado2 = 5.0;
                
        //Valores recuperados
        String retornoNomeFeito1 = carrinho.getItens().get(0).getNome();
        double retornoPrecoFeito1 = carrinho.getItens().get(0).getPreco();
        String retornoNomeFeito2 = carrinho.getItens().get(1).getNome();
        double retornoPrecoFeito2 = carrinho.getItens().get(1).getPreco();
                
        assertEquals(retornoNomeEsperado1, retornoNomeFeito1);
        assertEquals(retornoPrecoEsperado1, retornoPrecoFeito1,0.00001);
        assertEquals(retornoNomeEsperado2, retornoNomeFeito2);
        assertEquals(retornoPrecoEsperado2, retornoPrecoFeito2,0.00001);        
    }
    
    
    @Test
    void testGetQuantidadeProdutos() {
        //Cria o carrinho de pagamento
        Carrinho carrinho = new Carrinho();
        
        //Cria os produtos para adicionar ao carrinho
        carrinho.adicionar(new Produto("Livro", 50.0));
        carrinho.adicionar(new Produto("Caneta", 5.0));

        //Quantidade de produtos esperado
        int retornoEsperado = 2;
        double retornoFeito = carrinho.getQuantidadeProdutos();
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
    
    @Test
    void testGetNomeProdutos() {
        //Cria o carrinho de pagamento
        Carrinho carrinho = new Carrinho();
        
        //Cria os produtos para adicionar ao carrinho
        carrinho.adicionar(new Produto("Livro", 50.0));
        carrinho.adicionar(new Produto("Caneta", 5.0));

        String retornoEsperado1 = "Livro";        
        String retornoEsperado2 = "Caneta";
        List<String> nomes = carrinho.getNomeProdutos();   
        
        //Verifica se a lista contem os produtos
        assertTrue(nomes.contains(retornoEsperado1));
        assertTrue(nomes.contains(retornoEsperado2)); 
    }    
 }
