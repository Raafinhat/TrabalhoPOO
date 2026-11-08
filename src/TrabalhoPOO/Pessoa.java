package TrabalhoPOO;

public abstract class Pessoa { 
    private String nome;
    private String cpf;
    private String telefone;
    private String email;

    public Pessoa (String nome, String cpf, String telefone, String email){
        if (nome == null || nome.isBlank() || cpf == null || cpf.isBlank()){
            throw new IllegalArgumentException("Nome ou CPF inválido!");
        }

        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
    }

    //usamos o comando para criar todos os getters e setters

    //Getters
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }
    
    //Setters

    public void setTelefone (String telefone) {
        
        if (telefone == null || telefone.isBlank()){ // verifica se o telefone é nulo ou se está em branco
            throw new IllegalArgumentException("Telefone inválido!\n"); //comando vair ver se o telone é válido e se não vou vai mandar de volta com a mensagem "Telefone inválido"
        }
        this.telefone = telefone;
    }

    public void setEmail(String email) {
        if (email == null || email.isBlank() || !email.contains("@")){ //verifica se o email é nulo, está em branco e se tem o "@"
            throw new IllegalArgumentException ("Email inválido!\n");
        }
        this.email = email;
    }

    public abstract String exibirTipoCadastro ();
    
}
