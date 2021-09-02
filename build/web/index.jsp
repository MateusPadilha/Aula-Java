<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="executar_inserir.jsp">
            <h1>Cadastro de Cliente</h1>
            <label>NOME</label><br>
            <input type="text" name="nome" required/><br>
            <label>EMAIL</labe><br>
            <input type="text" name="email" required/><br><br>
            <input type="submit" value="ENVIAR"/>
        </form>
    </body>
</html>
