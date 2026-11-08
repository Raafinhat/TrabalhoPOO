package TrabalhoPOO;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Pessoa{
    private List<Emprestimo> historicoEmprestimos;
    private List<Venda> historicoCompras;

    public Cliente(String nome, String cpf, String telefone, String email){
        super (nome, cpf, telefone, email);
        
        historicoEmprestimos = new ArrayList<>();
        historicoCompras = new ArrayList<>();
    }

    public void registrarHistoricoEmprestimos(Emprestimo emprestimo){
        if(emprestimo == null){
            throw new IllegalArgumentException("REgistro inválido.");
        }

        historicoEmprestimos.add(emprestimo);
    }

    public void registrarHistoricoCompras(Venda venda){
        if(venda == null){
            throw new IllegalArgumentException("Registro inválido.");
        }

        historicoCompras.add(venda);
    }

    public List<Emprestimo> consultarHistoricoEmprestimos(){
        return new ArrayList<>(historicoEmprestimos);    
    }

    public List<Venda> consultarHistoricoCompras(){
        return new ArrayList<>(historicoCompras);
    }

    @Override 
    public String exibirTipoCadastro(){
        return "Cadastro Cliente.";
    }
}
