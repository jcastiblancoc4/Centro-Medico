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
        <link rel="stylesheet" type="text/css" href="styles/styles.css">
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
      <div class="container theme-showcase" role="main" style=" margin-left: 10%; margin-right:10%; background: #ffffff " >
            <form action="CitasCtrl" method="GET">
               <div> 
               <h3 class="titulo">Lista de Citas</h3>  
               <input type="submit" name="accion" value="nuevo" class="btn btn-success nuevo">
               </div>
            </form>
             <div class="row" >
                   <c:forEach items="${citas}" var="cita">
                        <div class="col-sm-4 item">
                            <div class="card ">
                                <div class="card-body">
                                    
                                    <h4 class="card-title">id cita: ${cita.id}</h4>
                                    
                                    <h5 class="card-text" style="">Nombre Paciente: ${cita.paciente}</h5>
                                    <h5 class="card-text" style="">Cedula Paciente: ${cita.cedulaPaciente}</h5>
                                    <h5 class="card-text" style="">Numero de Celular Paciente: ${cita.celularPaciente}</h5>
                                    
                                    
                                    <h5 class="card-text" style="">Especialidad de Cita: ${cita.especialidad}</h5>
                                    <h5 class="card-text" style="">Duracion de Cita: ${cita.duracionConsulta}</h5>
                                    <h5 class="card-text" style="">Costo de Cita: $${cita.valorConsulta}</h5>
                                    
                                    <h5 class="card-text" style="">Doctor: ${cita.doctor}</h5>
                                    <h5 class="card-text" style="">Cedula Doctor: ${cita.cedulaDoctor}</h5>
                                    <h5 class="card-text" style="">Numero de Celular Doctor ${cita.celularDoctor}</h5>
                                    
                                    <h5 class="card-text" style="">fecha: ${cita.fecha}</h5>
                                    <h5 class="card-text" style="">hora: ${cita.hora}</h5>
                                    <h5 class="card-text" style="">estado: ${cita.estado}</h5>
                                    <h5 class="card-text" style="">asistio: ${cita.asistio}</h5>
                                    
                                    <form action="CitasCtrl" method="GET" style="display:inline-block">
                                        <input type="hidden" name="id" value="${cita.id}">
                                        
                                        <input type="submit" name="accion" value="editar" class="btn btn-warning btn-sm">       
                                    </form>
                                    <form  action="CitasCtrl" method="POST" style="display:inline-block">
                                        <input type="hidden" name="id" value="${cita.id}">
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