
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js">
    </script>
    <style>
        body {
            background-color: lightblue;
        }
        h1{
            text-align: center;
            color: black;
        }
        a{
            color: darkorchid;
        }
    </style>
</head>

<body>
<div class="container"><div class="jumbotron">
    <h1>Web Design </h1>


</div>
    <div class="table-responsive">
        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>URL</th>
            </tr>
            </thead>
            <tbody id="tabla">

            </tbody>
        </table>
    </div>



    <ul class="pager">
        <li class="previous"><a href="index.jsp">Previous</a> </li>
    </ul>
</div>
</body>
</html>
