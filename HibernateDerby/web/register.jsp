<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
    </head>
    <body class="container">
        <h1>Registration Page (Using Derby Database)</h1>
        <div class="col-md-2">
        <div class="panel panel-default">
            <div class="panel-heading">Please fill the fields</div>
            <div class="panel-body">
        <form action="registerentry.jsp" method="post" class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-sm-2" for="name">
                    Name:
                </label>
                <div class="col-sm-10">
                <input type="text" name="name" class="form-control" id="name"/>               
                </div>
                </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="pwd">
                    Password:
                </label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="pwd" name="password">
                </div>
                </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="email">
                    Email address:
                </label>
                <div class="col-sm-10">
                <input type="email" class="form-control" id="email" name="email">
                </div>
                </div>
            <button type="submit" class="btn btn-primary btn-block">Submit</button>
        </form>
            </div>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
