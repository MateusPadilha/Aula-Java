package MODEL;

public class Cliente {
    //Criar atributos do cliente
    private int id;
    private String nome;
    private String email;

    //Criar os metodos do clientes, para comunicação 
    //botão direito -> clicar em inserir codigo -> getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
