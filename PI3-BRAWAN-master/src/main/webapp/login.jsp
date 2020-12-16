<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="pt-br">

    <head>
        <meta charset="utf-8"> 
        <title>Login Brawan</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">

        <link rel="stylesheet" type="text/css" href="./css/login.css">

    </head>
    <body>


    <div class="modal-dialog text-center">
        <div class="col-sm-8 main-section">
            <div class="modal-content">
                <div class="col-12 user-img">
                    <img src="./img/logo.png">
                </div>





                <form action="LoginServlet" method="POST" class="col-12">




                    <div class="form-group">
                        <input type="text" name="usuario" class="form-control" placeholder="Enter Username" required>
                    </div>
                    <div class="form-group">
                        <input type="password" name="senha" class="form-control" placeholder="Enter Password" required>
                    </div>
                    <button type="submit" class="btn">Login</button>
                </form>


            </div> <!-- modal --->
        </div>
    </div>  	
</body>
</html>