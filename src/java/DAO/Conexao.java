package DAO;
import java.sql.Connection; //para conectar com banco
import java.sql.DriverManager; //para conectar com banco

public class Conexao {
    public Connection getConexao(){
        
        try{
            //Codigo de conexão, se não funcionar (erro) ele vai ir para o catch  
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            return DriverManager.getConnection("jdbc:derby://localhost/bdTreino","matt","matt");
        
        }catch(Exception erro){
            //nesse catch ele vai carregar as mensagens de erro se acontecer
            throw new RuntimeException("Erro classe conexão: ", erro);
                   
        
        }
    }
}
