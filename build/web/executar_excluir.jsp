<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOCliente"%>

<%

    try{
        //Criação da DAOCliente para chamar o método que está dentro dela
        DAOCliente cld = new DAOCliente();
        //Passando o valor de Id que vem do formulário
        cld.excluirCliente(Integer.parseInt(request.getParameter("id")));
        //response.sendRedirect("consultar_clientes.jsp");
        out.print("Cliente excluido!");
        out.print("<meta http-equiv='refresh' content='3, url=consultar_clientes.jsp'>");
        
    }catch(Exception erro){
    
        throw new RuntimeException("Erro no Executar Excluir", erro);
        
    }

%>