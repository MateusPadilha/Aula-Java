<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente"%>
<%@page import="DAO.DAOCliente"%>

<%

    try{
        //Criando um contrutor de cliente e um da DAOCliente
        Cliente cli = new Cliente();
        DAOCliente cld = new DAOCliente();
        //Passando os valores para o cli <cliente>
        cli.setNome(request.getParameter("nome"));
        cli.setEmail(request.getParameter("email"));
        //O valor do id vem como string, precisa converte ele para Int
        cli.setId(Integer.parseInt(request.getParameter("id")));
        //Passando para o metodo
        cld.atualizarCliente(cli);
        //Voltar para página
        response.sendRedirect("consultar_clientes.jsp");
        
    }catch(Exception erro){
    
        throw new RuntimeException("Erro Executar Alterar",erro);
        
    }

%>