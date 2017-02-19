<%@page import="com.java.UserDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Page</title>
    </head>
    <body class="container">
        <jsp:useBean id="obj" class="com.java.User">
            <jsp:setProperty property="*" name="obj"/>
        </jsp:useBean>
        <%
            int i=UserDao.register(obj);
            if(i>0)
                out.println("<h1>Success</h1><div class=\"alert alert-success\"><strong>Success!</strong> Go back to <a href=\"index.jsp\" class=\"alert-link\">index</a>.</div>");
            else
                out.print("<h1>Failure</h1><div class=\"alert alert-danger\"><strong>Failure!</strong> Go back to <a href=\"register.jsp\" class=\"alert-link\">register</a>to try again.</div>");
         %>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
