package DAO;
// importa duas bibliotes para fazer conexão com o banco
import java.sql.Connection; // 1 biblioteca para fazer a utilização dos recursos de conexão 
import java.sql.DriverManager; //2 biblioteca ele vai gerenciar os drivers, sendo ele para gerenciar como e feito os drives de banco 

public class Conexao {
    //Criar método de conexão, sendo ele publico apra ser chamado em outras classes
    public Connection getConexao(){
        //verificar se tem alguma erro no código que está dentro dele.
        try{
            //Codigo de conexão, se não funcionar (erro) ele vai ir para o catch  
            //Busca o drive 
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //retorno do caminho da conexão
            return DriverManager.getConnection("jdbc:derby://localhost/bdTreino","matt","matt");
        
        }catch(Exception erro){
            //nesse catch ele vai carregar as mensagens de erro do Exception
            throw new RuntimeException("Erro classe conexão: ", erro);
                   
        }
    }
}
