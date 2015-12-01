<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel='stylesheet' href='http://codepen.io/assets/libs/fullpage/jquery-ui.css'> 
	<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
	   
    <title>Fuseki Browser</title>
  </head>
  
  <body>  
    <div class="container">
      <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
          </ul>
        </nav>
        <div class="head-title">Fuseki Browser</div>
        ${name}
      </div>
      
      <div class="container">
      	<div class="col-lg-1 col-offset-6 centered">
      
      		<div class="login-card">
				<h1>Log-in</h1><br>

  				<form action="./browser" method="post">
    				<input type="text" name="user" placeholder="Username">
    				<input type="password" name="pass" placeholder="Password">
    				<input type="submit" name="login" class="login login-submit" value="login">
  				</form>

			</div>
		</div>
      </div>
      
      <footer class="footer">
        <p class="footer-desc">&copy; HZ Triplestore Proof of Concept November 2015</p>
      </footer>      
    </div> 

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  </body>
</html>