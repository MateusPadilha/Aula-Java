package DAO;
/*Precisa 
    importa a Model -> onde tem os metodos get e set do cliente
    importa a Connetion -> para abrir conexão
    importa o PreparedStatement -> Responsável pelas instruções SQL
    
    importa o Statement que para instrução SQL com parâmetros
    importa o ResultSet -> responsavel por receber o resultado da busca no banco de dados.
    importa ArrayList -> sendo responsavel por exibir os valores do ResultSet.
*/
import MODEL.Cliente; //linkar com a MODEL cliente para mandar o dados
import java.sql.Connection; //para chamar a conexão
import java.sql.PreparedStatement; // para passar os comando sql
import java.sql.Statement; //importante para intrução sql com parametros
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAOCliente {
    //tudo que for connection e conn
    private Connection conn; 
    //chamando o preparedeStatement de stmt
    private PreparedStatement stmt; 
    private Statement st;
    private ResultSet rs;
    private ArrayList<Cliente> lista = new ArrayList<>();
    
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
    
    //Para trazer a lista do banco de dados de todos os clientes
    public ArrayList<Cliente> listarClientes(){
        //criar variavel para receber intrução SQL
        String sql = "SELECT * FROM tb_clientes";
        
        //Try para fazer a verificação de erros
        try{
            //criando conexão
            st = conn.createStatement();
            //executando uma query na conexão 
            rs = st.executeQuery(sql);
            //criar uma estrutura de repetição para carregar linha por linha no array e gravar as linhas no array
            while(rs.next()){
                Cliente cliente = new Cliente();
                //pegando os valores 
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
                //adicionando o valor no array
                lista.add(cliente);
            }
            
        }catch(Exception erro){
            //Se ocorrer erro no código exibir mensagem abaixo
            throw new RuntimeException("Erro no listar clientes: ",erro);
            
        }
        return lista;
        
    }
    
    //Método para atualizar os dados do clientes
    public void atualizarCliente(Cliente cliente){
        //try para verificação de erros
        try{
            String sql = "UPDATE tb_clientes SET nome = ?, email = ? WHERE id = ?";
            //passar os valores para o preparedStatement e a conexão
            stmt = conn.prepareStatement(sql);
            //Passar os valores dos parâmetros
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setInt(3, cliente.getId());
            //Execute instrução
            stmt.execute();
            //Fechar conexão
            stmt.close();
            
        }catch(Exception erro){
            //Casso tenha erro no try, vai aparecer mensagem abaixo
            throw new RuntimeException("Erro método Atualizar Cliente",erro); 
            
        }
        
    }
    
    //método para excluir Cliente, criando uma variável valor para pegar o valor do id no jsp
    public void excluirCliente(int valor){
    
        try{
            //Criar variável para receber conexão sql
            String sql = "DELETE FROM tb_clientes WHERE id = "+valor;
            //Passa conexão para o statement
            st = conn.createStatement();
            //Executar a instrução sql no banco
            st.execute(sql);
            //Fechar a conexão com o banco
            st.close();
            
        }catch(Exception erro){
            //casssso de erro no try
            throw new RuntimeException("Erro método Excluir Cliente", erro);
            
        }
    
    }
    
}
