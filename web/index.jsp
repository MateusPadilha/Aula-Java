<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!-- Usando método post mandando para outra página para encapsular os dados-->
        <form method="post" action="executar_inserir.jsp">
            <!-- Criação de formulario para pegar os dados -->
            <h1>Cadastro de Cliente</h1>
            <label>NOME</label><br>
            <input type="text" name="nome" required/><br>
            <label>EMAIL</labe><br>
            <input type="text" name="email" required/><br><br>
            <input type="submit" value="ENVIAR"/>
        </form>
    </body>
</html>
