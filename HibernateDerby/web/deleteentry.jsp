<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Page (Using Derby Database)</title>
    </head>
    <body>
        <h1>Delete Page (Using Derby Database)</h1>
        <div class="col-md-2">
        <div class="panel panel-default">
            <div class="panel-heading">Please fill the fields</div>
            <div class="panel-body">
        <form action="delete.jsp" method="post" class="form-horizontal">
            <div class="form-group">
                <label class="control-label col-sm-2" for="id1">
                    ID:
                </label>
                <div class="col-sm-10">
                <input type="text" name="id" class="form-control" id="id1"/>               
                </div>
                </div>
            <button type="submit" class="btn btn-danger btn-block">Delete</button>
        </form>
            </div>
        </div>
        </div>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </body>
</html>
