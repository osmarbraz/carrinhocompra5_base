package carrinho;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> itens;
    
    public Carrinho(){
        itens = new ArrayList<>();
    }
    
    public List<Produto> getItens() { 
        return null;
    }
    
    public void setItens(List<Produto> itens) {        
    }
    
    public void adicionar(Produto p) {        
    }

    public double getTotal() {      
        return Double.NaN;
    }
    
    public long getQuantidadeProdutos() {
        return 0;
    }
    
     public List<String> getNomeProdutos() {     
        return null;
    }
}