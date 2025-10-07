package principal;

import carrinho.Carrinho;
import carrinho.Produto;
import carrinho.ServicoPagamento;
import javax.swing.JOptionPane;

public class Principal {

    public static void main(String[] args) {

        String opcao1 = "";
        //Produtos pré-cadastrados
        Produto produto1 = new Produto("Livro", 35.0);
        Produto produto2 = new Produto("Caneta", 5.0);
        Produto produto3 = new Produto("Notebook", 2000.0);

        //Cria o carrinho para adicionar os produtos
        Carrinho carrinho = new Carrinho();

        //Servico de pagamento do carrinho
        ServicoPagamento pagar = new ServicoPagamento();

        while (!opcao1.equals("9")) {
            opcao1 = JOptionPane.showInputDialog("1 - Adicionar produto Carrinho \n2 - Saldo carrinho \n3 - Pagar \n9 - Sair");
            switch (Integer.parseInt(opcao1)) {
                //Adição de produto ao carrinho
                case 1:
                    String opcao2 = "";
                    while (!opcao2.equals("9")) {
                        opcao2 = JOptionPane.showInputDialog("1 - Adicionar Livro (35.0) \n2 - Adicionar Caneta (5.0) \n3 - Notebook (2000.0) \n9 - Voltar");
                        switch (Integer.parseInt(opcao2)) {
                            case 1:
                                carrinho.adicionar(produto1);
                                System.out.println("Produto 1 adicionado ao carrinho");
                                break;
                            case 2:
                                carrinho.adicionar(produto2);
                                System.out.println("Produto 2 adicionado ao carrinho");
                                break;
                            case 3:
                                carrinho.adicionar(produto3);
                                System.out.println("Produto 3 adicionado ao carrinho");
                                break;
                            case 9:                                
                                System.out.println("Voltando ao menu principal");
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Alternativa inválida!");
                                break;
                        }
                    }
                    break;
                //Mostrar o total do carrinho
                case 2:
                    JOptionPane.showMessageDialog(null, "Total carrinho: " + carrinho.getTotal());
                    break;
                //Pagar o carrinho
                case 3:
                    double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor para pagar o carrinho:"));
                    pagar.setSaldo(valor);
                    if (pagar.pagar(carrinho)) {
                        JOptionPane.showMessageDialog(null, "Saldo suficiente para pagar o carrinho");
                    } else {
                        JOptionPane.showMessageDialog(null, "Atenção: saldo insuficiente para pagar o carrinho");
                    }
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Alternativa inválida!");
                    break;
            }
        }
    }
}
