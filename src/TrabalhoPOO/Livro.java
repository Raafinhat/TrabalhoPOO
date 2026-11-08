package TrabalhoPOO;

public class Livro {
    private String titulo;
    private String autor;
    private String isbn;
    private String editora;
    private int anoPublicacao;
    private double preco;
    private int quantidadeEstoque;
    private int quantidadeDisponivelEmprestimo;

    public Livro (String titulo, String autor, String isbn, String editora, int anoPublicacao, double preco, int quantidadeEstoque, int quantidadeDisponivelEmprestimo){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.editora = editora;
        this.anoPublicacao = anoPublicacao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
        this.quantidadeDisponivelEmprestimo = quantidadeDisponivelEmprestimo;
    }

    //Getters

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPreco() {
        return preco;
    }

    //Setters

    public void setPreco(double preco) {
        if(preco <=0){ //verifica se não foi colocado um valor 0
            throw new IllegalArgumentException ("Preço inválido!\n"); //se o valor for menor que 0 informa que está errado e pede um novo
        }
        this.preco = preco;
    }    

    public String consultarDados(){
        return "Livro: "+getTitulo()+"\nAutor: "+getAutor()+"\nISBN: "+getIsbn()+"\n---------\nValor: "+getPreco(); 
    }
    
    public boolean verificarDisponibilidadeEmprestimo(){
        if(quantidadeDisponivelEmprestimo > 0){ 
            System.out.println("Livro disponível para emprestimo!\n");
            return true;
        } else{
            System.out.println("Livro indisponível!\n");
            return false;
        }
    }

    public void baixarEstoqueEmprestimo (int quantidade){
        if(quantidade <= 0){
            throw new IllegalArgumentException ("Valor inválido.\n");
        }
        
        if(quantidadeDisponivelEmprestimo < quantidade){
            throw new IllegalArgumentException ("Quantidade insuficiente para emprestimo.\n");
        }

        quantidadeDisponivelEmprestimo -= quantidade;
    }

    public boolean verificarEstoqueVenda(int quantidade){
        if(quantidade <= 0){
            throw new IllegalArgumentException ("Valor inválido.\n");
        }

        if(quantidadeEstoque >= quantidade){
            System.out.println("Estoque suficiente para venda!\n");
            return true;
        } else{
            System.out.println("Estoque não suficente para venda!\n");
            return false;
        }
    }

    public void baixarEstoqueVenda(int quantidade){
        if(quantidade <= 0){
            throw new IllegalArgumentException("Valor inválido.\n");
        }

        if(quantidadeEstoque < quantidade){
            throw new IllegalArgumentException("Quantidade insuficiente para venda");
        }
        
        quantidadeEstoque -= quantidade; //o -= vai diminuir o valor retirado do livro no estoque. 
    }

    public void devolverExemplar(int quantidade){
        if (quantidade <= 0){
            throw new IllegalArgumentException ("Valor inválido.\n");
        }

        quantidadeDisponivelEmprestimo += quantidade;
    }

}
