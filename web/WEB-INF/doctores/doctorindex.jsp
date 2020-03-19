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
        <%--    <link rel="stylesheet" href="styles.css" type="text/css"> --%>
        <style>
            .titulo{
                display:inline-block;
                margin: 3% auto 20px 2%;
                padding: 0;
                text-transform: uppercase;
                font-weight: 600;
            }
            .nuevo{                
                display:inline-block;
                margin-left: 40%;
            }
            .item{
                display: flex;
                justify-content: center;
                margin-left: 2%;
                margin-bottom: 30px;
                padding: 10px;
                
            }
            h4{
                text-transform: uppercase;
                font-weight: 600;
                
            }
        </style>
        
    </head>
    
     
    <body>        
      <jsp:include page="../includes/header.jsp"></jsp:include>
       <div class="container theme-showcase" role="main" style=" margin-left: 10%; margin-right:10%" >
            <form action="DoctoresCtrl" method="GET">
               <div> 
               <h3 class="titulo">Lista de Doctores</h3>  
               <input type="submit" name="accion" value="nuevo" class="btn btn-success nuevo">
               </div>
            </form>
             <div class="row" >
                   <c:forEach items="${doctores}" var="doctor">
                        <div class="col-sm-4 item">
                            <div class="card ">
                                <div class="card-body">
                                    <div>
                                    <img src="#" width="200" height="200" style="border: black solid ">
                                    </div>
                                    
                                    <h4 class="card-title">${doctor.nombre} ${doctor.apellido}</h4>
                                    <h5 class="card-text" style="">Cedula: ${doctor.cedula}</h5>
                                    <h5 class="card-text" style="">Direccion: ${doctor.direccion}</h5>
                                    <h5 class="card-text" style="">E-mail: ${doctor.correo}</h5>
                                    <h5 class="card-text" style="">Celular: ${doctor.celular}</h5>
                                    <h5 class="card-text" style="">Especialidad: ${doctor.nombreEspecialidad}</h5>
                                    
                                   
                                    
                                    <form action="DoctoresCtrl" method="GET" style="display:inline-block">
                                        <input type="hidden" name="id" value="${doctor.id}">
                                        <input type="submit" name="accion" value="editar" class="btn btn-warning btn-sm">       
                                    </form>
                                    <form  action="DoctoresCtrl" method="POST" style="display:inline-block">
                                        <input type="hidden" name="id" value="${doctor.id}">
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
