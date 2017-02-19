<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@page import="java.util.*,com.java.*,org.hibernate.*,org.hibernate.cfg.*"%>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <%! int id;String pw;String name;String em;Session session1=null;%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <h1>Before Updation</h1>
    <body>
    <jsp:include page="showuser.jsp"/>
    </div>
    <h1>After Updation</h1>
    <h1>User Details</h1>
        <div class="panel panel-default">
            <div class="panel-body">
        <table class="table-striped table table-bordered">
            <tr>
                <th>ID</th><th>Name</th><th>E-Mail</th>
            </tr>
        <%
            int i=Integer.parseInt(request.getParameter("id"));
            String name=request.getParameter("name");
            String pw=request.getParameter("password");
            String em=request.getParameter("email");
            Configuration cf=new Configuration();
            cf.configure();
            SessionFactory sf=cf.buildSessionFactory();
            session1=sf.openSession();
            User user=null;
            session1.beginTransaction();
            user=(User)session1.get(User.class,i);/*Retriving obj which we want to update*/
            user.setName(name);
            user.setPassword(pw);
            user.setEmail(em);
            
            session1.update(user);
            session1.getTransaction().commit();
            String SQL_QUERY="from User";/*use bean class*/
            Query query = session1.createQuery(SQL_QUERY);
            Iterator it=query.iterate();
            while(it.hasNext())
            {
                User e=(User)it.next();
                id=e.getId();
                name=e.getName();
                em=e.getEmail();
            %>
            <tr><td><%=id%></td><td><%=name%></td><td><%=em%></td></tr>
            <%
            }
            session1.close();
            %>
   </table>
        <a href="index.jsp" class="btn btn-info btn-block" role="button">Back to index</a>
        </div>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
