<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    <style>
	    	.formulario{
	    		width: 50%;
	    		margin: 0 auto;
	    	}
	    	button{
	    		margin-top: 2em;
	    	}
	    </style>
	</head>
	<body>
		<div class = "container">
			<h1>Lista de anuncios de mascotas perdidas</h1>
			<c:forEach items="${posts}" var="post">
				<h4><span>Id: ${post.getId()}</span></h4>
				<h4><span>Raza: ${post.getRaza()}</span></h4>
				<h4><span>Descripcion: ${post.getDescripcion()}</span></h4>
				<h4><span>Titulo: ${post.getTitulo()}</span></h4>
			</c:forEach>
			
			<h4><span>${posts[0].getRaza()}</span></h4>
			<br>
		   
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>