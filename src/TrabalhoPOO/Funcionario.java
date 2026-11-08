package TrabalhoPOO;

public class Funcionario extends Pessoa {
    private String matricula;
    private String cargo;
    
    public Funcionario (String nome, String cpf, String telefone, String email, String matricula, String cargo){
        super(nome, cpf, telefone, email);

        this.matricula = matricula;
        this. cargo = cargo;
    }
    
    public String getMatricula() {
        return matricula;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        if(cargo == null || cargo.isBlank()){
            throw new IllegalArgumentException("Cargo inválida.");
        }
        this.cargo = cargo;
    }

    @Override 
    public String exibirTipoCadastro(){
        return "Cadastro Funcionário.";
    }

}
