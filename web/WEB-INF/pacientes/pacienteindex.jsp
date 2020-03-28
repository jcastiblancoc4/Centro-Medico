<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="styles/paciente.css">
        
        
    </head>
    
     
    <body>        
        <div class="container" style="margin-top: 5px; ">   
        <jsp:include page="../includes/header.jsp"></jsp:include>
        </div>
       <div class="cuerpo" >
            <form action="PacientesCtrl" method="GET">
               <div class="col-sm-9"> 
               <h2 class="titulo">Lista de Pacientes</h2>  
               <input type="submit" name="accion" value="nuevo" class="btn btn-success nuevo">
               </div>
            </form>
           <div>
                <c:forEach items="${pacientes}" var="paciente">
                    <div class="col-sm-5 item">
                        <div class="card ">
                            <div class="card-body">
                                <div>
                                <img src="${paciente.rutaFoto}" width="130" height="130" style="border: black solid ">
                                </div>
                                <h4 class="card-title">${paciente.nombre} ${paciente.apellido}</h4>
                                <h5 class="card-text" style="">Cedula: ${paciente.cedula}</h5>
                                <h5 class="card-text" style="">Direccion: ${paciente.direccion}</h5>
                                <h5 class="card-text" style=>Correo: ${paciente.correo}</h5>
                                <h5 class="card-text" style="">Celular: ${paciente.celular}</h5>
                                <h5 class="card-text" style="">Citas pendientes: ${paciente.numeroCitas}</h5>
                                <form action="PacientesCtrl" method="GET" style="display:inline-block">
                                    <input type="hidden" name="id" value="${paciente.id}">
                                    <input type="hidden" name="cedula" value="${paciente.cedula}">
                                    <input type="submit" name="accion" value="editar" class="btn btn-warning btn-sm">       
                                </form>
                                <form  action="PacientesCtrl" method="POST" style="display:inline-block">
                                    <input type="hidden" name="id" value="${paciente.id}">
                                    <input type="hidden" name="cedula" value="${paciente.cedula}">
                                    <input type="submit" name="accion" value="eliminar" class="btn btn-danger btn-sm">
                                </form>
                            </div>           
                        </div>  
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html>
