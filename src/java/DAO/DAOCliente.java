package DAO;
/*Precisa 
    importa a Model -> onde tem os metodos get e set do cliente
    importa a Connetion -> para abrir conexão
    importa o PreparedStatement -> Responsável pelas instruções SQL
*/
import MODEL.Cliente; //linkar com a MODEL cliente para mandar o dados
import java.sql.Connection; //para chamar a conexão
import java.sql.PreparedStatement; // para passar os comando sql

public class DAOCliente {
    //tudo que for connection e conn
    private Connection conn; 
    //chamando o preparedeStatement de stmt
    private PreparedStatement stmt; 
    
    //Criar construtor da conexão
    public DAOCliente(){
        //Chamando essa a classe "getConexao" do DAO (mesmo pacote)
        conn = new Conexao().getConexao();
    }
    
    /*Criar método para inserir cliente, valores da model.
    os valor da index vai para MODEL -> Clientes
    que vai ser pego por esse método*/
    public void InserirCliente(Cliente cliente){
        //Criando uma variavel passando uma instrução sql (para o banco para poder inserir dados, o id cria automático)
        String sql = "INSERT INTO tb_clientes (nome,email) VALUES (?,?)";
        
        try{
            //pegar a string para o preparedStatement e a conexão (onde vai inserir)
            stmt = conn.prepareStatement(sql);
            //Passar os valores dos parâmetros
            //Set do valor da string (pode ser int, double, array etc)
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            //Execute os comandos
            stmt.execute();
            //Depois de executado o comando, fecha a conexão
            stmt.close();
            
        }catch(Exception erro){
            throw new RuntimeException("Erro Inserir Cliente: ",erro);
        }
                
    }
}
