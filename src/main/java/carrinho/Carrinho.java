package carrinho;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> itens;
    
    public Carrinho(){
        itens = new ArrayList<>();
    }

    public void adicionar(Produto p) {

    }

    public double getTotal() {
       return Double.NaN;
    }
}