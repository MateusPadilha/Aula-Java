<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- 
    importa as conexão que ele se conecta
    Model -> CLiente
    Dao -> DaoCliente
-->
<%@page import="MODEL.Cliente"%>
<%@page import="DAO.DAOCliente"%>
<!DOCTYPE html>
<html>
    <body>
       
        <%
            //
            try{
                //Criando um construtor de cliente
                Cliente cli= new Cliente();
                DAOCliente cld= new DAOCliente();
                //pegando o valor passado via "POST" de dentro do nome e email do index(navegador)
                //criando uma variavel que vai pegar esse valor com o getParameter do index(navegador)
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                
                //Condição para verificar se esse valores são NULL (nulos/vazios)
                if(nome.equals(null)|| email.equals(null)){
                    //Se for ele vai dar o erro
                    response.sendRedirect("index.jsp");
                }else{
                    //Se tiver tudo certo, ele vai chamar a inserir cliente
                    cli.setNome(nome);
                    cli.setEmail(email);
                    //chamando o inserirCliente da DAO -> Cliente
                    cld.InserirCliente(cli);
                    response.sendRedirect("index.jsp");
                }
                
            }catch(Exception erro){
                throw new RuntimeException ("Erro Executar Inserir: ", erro);
            }
        %>
    </body>
</html>
