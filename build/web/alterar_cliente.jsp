<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Atualizar Cliente</h1>
        <form method="post" action="executar_alterar.jsp">
            <!-- Criação de formulario para passar dados, para exclusão -->
            <label>ID</label><br>
            <input type="text" name="id" value="<%=request.getParameter("id")%>" readonly/><br>
            <label>NOME</label><br>
            <input type="text" name="nome" value="<%=request.getParameter("nome")%>" required/><br>
            <label>EMAIL</labe><br>
            <input type="text" name="email" value="<%=request.getParameter("email")%>" required/><br><br>
            <input type="submit" value="Alterar"/><br><br>
        </form>
    </body>
</html>
