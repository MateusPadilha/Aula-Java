<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.DAOCliente"%>

<%

    try{
        //Criação da DAOCliente para chamar o método que está dentro dela
        DAOCliente cld = new DAOCliente();
        //Passando o valor de Id que vem do formulário
        cld.excluirCliente(Integer.parseInt(request.getParameter("id")));
        
        
    }catch(Exception erro){
    
        throw new RuntimeException("Erro no Executar Excluir", erro);
        
    }

%>