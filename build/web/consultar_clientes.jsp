<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="MODEL.Cliente"%>
<%@page import="DAO.DAOCliente"%>
<%@page import="java.util.ArrayList"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
         <h1>Consulta Clientes</h1>
        <form action="consultar_clientes.jsp" method="post">
            
            <label>Pesquisa por Nome</label>
            <input type="text" name="nome"/>
            <input type="submit" value="Pesquisar"/><br>
            
        </form> 
        <%
            out.print("<table border='1'>");
            out.print("<tr>");
                out.print("<th>ID</th>/");
                out.print("<th>Nome</th>/");
                out.print("<th>EMAIL</th>/");
                out.print("<th>EDITAR</th>/");
                out.print("<th>EXCLUIR</th>/");
            out.print("</tr>");
            
            DAOCliente cli = new DAOCliente();
            if(request.getParameter("nome") == "" || request.getParameter("nome") == null){
                ArrayList<Cliente> lista = cli.listarClientes();
                for(int i=0; i<lista.size();i++){
                    out.print("<tr>");
                        out.print("<td>"+lista.get(i).getId()+"</td>/");
                        out.print("<td>"+lista.get(i).getNome()+"</td>/");
                        out.print("<td>"+lista.get(i).getEmail()+"</td>/");
                        out.print("<td><a href='alterar_cliente.jsp?id="
                                +lista.get(i).getId()
                                +"&nome="+lista.get(i).getNome()
                                +"&email="+lista.get(i).getEmail()
                                +"'>EDITAR</a></td>/");
                        out.print("<td><a href='excluir_cliente.jsp?id="
                                +lista.get(i).getId()
                                +"&nome="+lista.get(i).getNome()
                                +"'>EXCLUIR</a></td>/");
                    out.print("</tr>");
                    }
                }else{
                    //Aqui vai ser código de busca por nome, copia de cima
                    ArrayList<Cliente> lista = cli.listarClientesNome(request.getParameter("nome"));
                    for(int i=0; i<lista.size();i++){
                        out.print("<tr>");
                            out.print("<td>"+lista.get(i).getId()+"</td>/");
                            out.print("<td>"+lista.get(i).getNome()+"</td>/");
                            out.print("<td>"+lista.get(i).getEmail()+"</td>/");
                            out.print("<td><a href='alterar_cliente.jsp?id="
                                    +lista.get(i).getId()
                                    +"&nome="+lista.get(i).getNome()
                                    +"&email="+lista.get(i).getEmail()
                                    +"'>EDITAR</a></td>/");
                            out.print("<td><a href='excluir_cliente.jsp?id="
                                    +lista.get(i).getId()
                                    +"&nome="+lista.get(i).getNome()
                                    +"'>EXCLUIR</a></td>/");
                        out.print("</tr>");
                        }
            
                }
            out.print("</table>");
                
        %>
        
    </body>
</html>
