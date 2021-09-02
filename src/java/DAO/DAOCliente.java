package DAO;
import MODEL.Cliente; //linkar com a MODEL cliente para mandar o dados
import java.sql.Connection; //para chamar a conexao
import java.sql.PreparedStatement; // para passar os comando sql

public class DAOCliente {
    
    private Connection conn; //tudo que for connection e conn
    private PreparedStatement stmt; //chamando o preparedeStatement de stmt
    
    public DAOCliente(){
        //vai iniciar com a conexao, essse get vai ser para madnar para conexao e consulta e conectar
        conn = new Conexao().getConexao();
    }
    
    //metod para inseriri cliente, valores da model
    public void InserirCliente(Cliente cliente){
        //passando um sql para o banco para inserir dados, o ids vem automatico 
        String sql = "INSERT INTO tb_clientes (nome,email) VALUES (?,?)";
        
        try{
            //pegar comando stmt e passar o valor, e mostrnado onde vai mandar, na conexao
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.execute();
            stmt.close();
            
        }catch(Exception erro){
            throw new RuntimeException("Erro Inserir Cliente: ",erro);
        }
                
    }
}
