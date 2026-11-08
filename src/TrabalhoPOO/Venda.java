package TrabalhoPOO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {
    private int numero;
    private LocalDate dataVenda;
    private List<ItemVenda> itens;
    private double valorTotal;

    public Venda (int numero){
        this.numero = numero;
        dataVenda = LocalDate.now(); //LocalDate pega a data real do pc do usuário
        itens = new ArrayList <ItemVenda>();
        valorTotal = 0.0;
    }

    public void adicionarItem (ItemVenda item){
        if(item == null){
            throw new IllegalArgumentException("Item inválido.\n");
        }

        for (ItemVenda itemExistente : itens) {
            if (itemExistente.getLivro().equals(item.getLivro())) {
                throw new IllegalArgumentException("Este livro já foi adicionado.");
            }
        }

        itens.add(item);
    }

    public void removerItem(ItemVenda item){
        if(item == null){
            throw new IllegalArgumentException("Item não encontrado.\n");
        }

        if(itens.remove(item)==false){
            System.out.println("Item não encontrado.\n");
        }
    }

    public double calcularTotal(){
        double total = 0;

        for(ItemVenda item: itens){
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void finalizarVenda(){
        for(ItemVenda item: itens){
            
            if(item.getLivro().verificarEstoqueVenda(item.getQuantidade())==false){
                System.out.println("Compra não pôde ser finalizada. Confira o estoque.\n");
                return;
            }
        }

        valorTotal = calcularTotal();
        
        for(ItemVenda item: itens){
            item.getLivro().baixarEstoqueVenda(item.getQuantidade());
        }
    }

    public double getValorTotal() {
        return valorTotal;
    }
}