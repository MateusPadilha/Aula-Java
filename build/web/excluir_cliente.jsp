<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Confirmar Exclusão?</h1>
        <form method="post" action="executar_excluir.jsp">
            <label>ID</labe><br>
            <input type="text" name="id" value="<%=request.getParameter("id")%>" readonly/><br>
            <label>Nome</label><br>
            <input type="text" name="Nome" value="<%=request.getParameter("nome")%>" readonly/><br><br>
            <input type="submit" value="Confirmar"/>   
            <button>
                <a href="consultar_clientes.jsp" style="text-decoration:none" style="color:inherit">Cancelar</a>
            </button>
        </form>
           
    </body>
</html>
