package TrabalhoPOO;

public class ItemVenda {
    private Livro livro;
    private int quantidade;
    private double precoUnitario;

    public ItemVenda(Livro livro, int quantidade, double precoUnitario){
        if (livro == null || quantidade <= 0 || precoUnitario <= 0){
            throw new IllegalArgumentException("Dados do item inválidos!");
        }
        
        this.livro = livro;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public double calcularSubtotal(){
        return quantidade * precoUnitario;
    }

    public Livro getLivro() {
        return livro;
    }

    public int getQuantidade() {
        return quantidade;
    }
    
}
