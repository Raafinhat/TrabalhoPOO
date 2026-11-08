package TrabalhoPOO;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Emprestimo {
    private List<Livro> livro;
    private Cliente cliente;
    private LocalDate dataEmprestimo;
    private LocalDate dataPrevistaDevolucao;
    private LocalDate dataDevolucao;
    private String status;
    private int quantidadeLivros;
    private int quantidadeLivrosDevolvidos;

    public Emprestimo(Cliente cliente, List<Livro> livro, LocalDate dataEmprestimo, LocalDate dataPrevistaDevolucao, int quantidadeLivros) {

        if (cliente == null) {
            throw new IllegalArgumentException("Cliente inválido!");
        }

        if (livro == null || livro.isEmpty()) {
            throw new IllegalArgumentException("A lista de livros não pode estar vazia!");
        }

        if (quantidadeLivros <= 0) {
            throw new IllegalArgumentException("Quantidade de livros inválida!");
        }

        if (quantidadeLivros != livro.size()) {
            throw new IllegalArgumentException("A quantidade informada deve ser igual à quantidade de livros na lista!");
        }

        if (dataEmprestimo == null || dataPrevistaDevolucao == null ||
            dataPrevistaDevolucao.isBefore(dataEmprestimo)) {
            throw new IllegalArgumentException("Datas do empréstimo inválidas!");
        }

        this.livro = new ArrayList<>(livro);
        this.cliente = cliente;
        this.dataEmprestimo = dataEmprestimo;
        this.dataPrevistaDevolucao = dataPrevistaDevolucao;
        status = "Em andamento.";
        this.quantidadeLivros = quantidadeLivros;
        quantidadeLivrosDevolvidos = 0;
    }

    public void registrarDevolucao(LocalDate dataDevolucao, int quantidadeDevolvida) {
        /*Nessa parte usei ia, pois a ideia principal era fazer a devolução dos livros um por um,
        porém existe a possibilidade de uma pessoa pegar o emprestimo de mais um livro diferente por vez.
        Só que na hora da adaptação não consegui ajustar a ideia inicial com a mudança da variável Livro para
        um arraylist e fazer funcionar. */
        
        if (quantidadeDevolvida <= 0){
            throw new IllegalArgumentException("Quantidade inválida!");
        }

        if (quantidadeLivrosDevolvidos + quantidadeDevolvida > quantidadeLivros){
            throw new IllegalArgumentException("Quantidade de devolução maior que a quantidade emprestada!");
        }

        this.dataDevolucao = dataDevolucao;
        this.quantidadeLivrosDevolvidos += quantidadeDevolvida;

        //No empréstimo é perimitido apenas alugar um livro igual por vez, mas pode ser alugado 1 de títulos diferentes

        for (int i = quantidadeLivrosDevolvidos - quantidadeDevolvida;
            i < quantidadeLivrosDevolvidos; i++){

            livro.get(i).devolverExemplar(1);
        }

        if (quantidadeLivrosDevolvidos == quantidadeLivros){
            status = "Devolvido.";
        } else {
            status = "Parcialmente devolvido.";
        }
    }

    public boolean verificarAtraso(){ //retorna true se estiver atrasado e false se não estiver
        LocalDate dataReferencia = LocalDate.now();

        if (quantidadeLivrosDevolvidos == quantidadeLivros) {
            /* Se o livro já foi entregue o próximo if vai comparar com a data da entrega,
            não com a data de hoje. */        
            dataReferencia = dataDevolucao;
        }  
        
        
        if(dataPrevistaDevolucao.isBefore(dataReferencia)){
            long quantDiasAtraso = ChronoUnit.DAYS.between(dataPrevistaDevolucao, dataReferencia);

            System.out.println("O empréstimo está com "+quantDiasAtraso+" dias atrasado.\n");
            
            status = "Atrasado.";

            return true;

        } else if (dataPrevistaDevolucao.isEqual(dataReferencia)){
            System.out.println("O emprestimo está previso para ser entregue hoje.\n");
            
            status = "Em adamento.";
            
            return false;       
        } else{
            System.out.println("O emprestimo não está atrasado ou foi devolvido.\n");
            
            return false;
        }
    }

    public String getStatus() {
        return status;
    }
    
}