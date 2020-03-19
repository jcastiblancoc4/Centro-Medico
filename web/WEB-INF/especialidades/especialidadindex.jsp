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
                margin-left: 2%;
                margin-bottom: 30px;
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
           <form action="EspecialidadesCtrl" method="GET">
               <div> 
               <h3 class="titulo">Lista de Especialidades</h3>  
               <input type="submit" name="accion" value="nueva" class="btn btn-success nuevo">
               </div>
           </form>
               <div class="row" >
                   <c:forEach items="${especialidades}" var="especialidad">
                        <div class="col-sm-10 item">
                            <div class="card ">
                                <div class="card-body">
                                    <h4 class="card-title">${especialidad.nombre}</h4>
                                    <p class="card-text" style="">${especialidad.descripcion}</p>
                                    <h5><b>Precio de la Consulta:</b> $ ${especialidad.costo_consulta}</h5>
                                    <h5><b>Duracion de la Consulta:</b> ${especialidad.duracion_consulta} horas</h5>
                                    
                                    <form action="EspecialidadesCtrl" method="GET" style="display:inline-block">
                                        <input type="hidden" name="id" value="${especialidad.getId()}">
                                        <input type="submit" name="accion" value="editar" class="btn btn-warning btn-sm">       
                                    </form>
                                    <form  action="EspecialidadesCtrl" method="POST" style="display:inline-block">
                                        <input type="hidden" name="id" value="${especialidad.getId()}">
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
