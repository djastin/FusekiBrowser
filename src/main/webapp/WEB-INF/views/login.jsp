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
	<link type="text/css" href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" />
	   
    <title>Fuseki Browser</title>
  </head>
  
<!-- temporarily CSS style in HTML -->  
  
<style>
@import url(http://fonts.googleapis.com/css?family=Roboto:400,100);
 
.main-title
{
	width: 300px;
	height: 10px;
	margin-left: auto;
	margin-right: auto;
	font-size: 44px;
	text-align: center;
	margin-top: 30px;
	color: gray;
}

body 
{
  	-webkit-background-size: cover;
  	-moz-background-size: cover;
  	-o-background-size: cover;
 	background-size: cover;
  	font-family: 'Roboto', sans-serif;
}

.head-title
{
	width: auto;
	height: 50px;
	text-align: center;
	margin-left: auto;
	margin-right: auto;
	font-size: 35pt;
	color: gray;
	margin-top: 50px;
}

.login-card 
{
  	padding: 40px;
  	width: 274px;
  	background-color: #F7F7F7;
  	margin-top: 40px;
  	margin-left: auto;
  	margin-right: auto;
  	border-radius: 2px;
  	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
  	overflow: hidden;
}

.login-card h1
{
  	font-weight: 100;
  	text-align: center;
  	font-size: 2.3em;
}

.login-card input[type=submit]
{
  	width: 100%;
  	display: block;
  	margin-bottom: 10px;
  	position: relative;
}

.login-card input[type=text], input[type=password] 
{
  	height: 44px;
  	font-size: 16px;
  	width: 100%;
  	margin-bottom: 10px;
  	-webkit-appearance: none;
  	background: #fff;
  	border: 1px solid #d9d9d9;
  	border-top: 1px solid #c0c0c0;
  	padding: 0 8px;
  	box-sizing: border-box;
  	-moz-box-sizing: border-box;
}

.login-card input[type=text]:hover, input[type=password]:hover 
{
  	border: 1px solid #b9b9b9;
  	border-top: 1px solid #a0a0a0;
  	-moz-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
  	-webkit-box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
  	box-shadow: inset 0 1px 2px rgba(0,0,0,0.1);
}

.login 
{
  	text-align: center;
  	font-size: 14px;
  	font-family: 'Arial', sans-serif;
  	font-weight: 700;
  	height: 36px;
  	padding: 0 8px;
}

.login-submit 
{
  	border: 0px;
  	color: #fff;
  	text-shadow: 0 1px rgba(0,0,0,0.1); 
  	background-color: #4d90fe;
}

.login-submit:hover
{
  	border: 0px;
  	text-shadow: 0 1px rgba(0,0,0,0.3);
  	background-color: #357ae8;
}

.login-card a 
{
  	text-decoration: none;
  	color: #666;
  	font-weight: 400;
  	text-align: center;
  	display: inline-block;
  	opacity: 0.6;
  	transition: opacity ease 0.5s;
}

.login-card a:hover
{
  	opacity: 1;
}

.login-help
{
  	width: 100%;
  	text-align: center;
  	font-size: 12px;
}

.footer
{
	position: absolute;
	background: #EEEEEE;
	height: 70px;
	width: 100%;
	bottom: 0;
	left: 0;
	text-align: center;
	color: gray;
}

.footer-desc
{
	font-family: 'Roboto', 'sans-serif';
	padding-top: 10px;
}

</style>

  <body>  
    <div class="container">
      <div class="header clearfix">
        <nav>
          <ul class="nav nav-pills pull-right">
          </ul>
        </nav>
        <div class="head-title">Fuseki Browser</div>
      </div>
      
      <div class="container">
      	<div class="col-lg-1 col-offset-6 centered">
      
      		<div class="login-card">
				<h1>Log-in</h1><br>

  				<form>
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