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
        this.itens = itens;
    }
    
    public void adicionar(Produto p) {
        
    }

    public double getTotal() {
      
        return Double.NaN;
    }
}