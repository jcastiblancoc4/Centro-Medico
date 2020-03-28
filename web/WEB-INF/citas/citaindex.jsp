<%@page import="Modelo.Cita"%>
<%@page import="java.util.List"%>
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
        <link rel="stylesheet" type="text/css" href="styles/cita.css">
        <%
            List<Cita> citas = (List<Cita>) request.getAttribute("citas");
            %>
    </head>
    
    <body>        
        <div class="container" style="margin-top: 5px; ">  
        <jsp:include page="../includes/header.jsp"></jsp:include>
        </div>
        <div class="cuerpo ">
        <h2 class="titulo">Lista de Citas</h2> 
           <form class="nuevo" action="CitasCtrl" method="GET">
               <div> 
               <input type="submit" name="accion" value="nuevo" class="btn btn-success bnuevo">
               </div>
            </form>
             <div style="display: inline-block; text-align:center ">
                   <%for(Cita cita: citas){%>
                        <div class="col-sm-6 item">
                            <div class="card ">
                                <div class="card-body">
                                    
                                    <h4 class="card-title">id cita: <%=cita.getId()%></h4>
                                    
                                    <h5 class="card-text" style="">Nombre Paciente: <%=cita.getPaciente()%></h5>
                                    <h5 class="card-text" style="">Cedula Paciente: <%=cita.getCedulaPaciente()%></h5>
                                    <h5 class="card-text" style="">Numero de Celular Paciente:  <%=cita.getCelularPaciente()%></h5>
                                    
                                    
                                    <h5 class="card-text" style="">Especialidad de Cita:  <%=cita.getEspecialidad()%></h5>
                                    <h5 class="card-text" style="">Duracion de Cita: <%=cita.getDuracionConsulta()%></h5>
                                    <h5 class="card-text" style="color: red">Costo de Cita: $ <%=cita.getValorConsulta()%></h5>
                                    
                                    <h5 class="card-text" style="">Doctor:  <%=cita.getDoctor()%></h5>
                                    <h5 class="card-text" style="">Cedula Doctor:  <%=cita.getCedulaDoctor()%></h5>
                                    <h5 class="card-text" style="">Numero de Celular Doctor  <%=cita.getCelularDoctor()%></h5>
                                    
                                    <h5 class="card-text" style="">fecha: <%=cita.getFecha()%></h5>
                                    <h5 class="card-text" style="">hora: <%=cita.getHora()%></h5>
                                    <h5 class="card-text" style="">estado: <%=cita.getEstado()%></h5>
                                    <h5 class="card-text" style="">asistio:  <%=cita.getAsistio()%></h5>
                                    
                                    <form action="CitasCtrl" method="POST" style="display:inline-block">
                                        <input type="hidden" name="id" value="<%=cita.getId()%>">
                                        <input type="submit" name="accion" value="eliminar"  <%if(cita.getEstado().equalsIgnoreCase("Agendada")|| cita.getAsistio().equalsIgnoreCase("pendiente")){%> disabled="" <%}%>
                                               class="btn btn-danger btn-sm">       
                                    </form>
                                    <form  action="CitasCtrl" method="POST" style="display:inline-block">
                                        <input type="hidden" name="id" value="<%=cita.getId()%>">
                                        <input type="submit" name="accion" value="gestionar"  <%if(cita.getEstado().equals("Cancelada")||
                                                cita.getAsistio().equals("Si")||cita.getAsistio().equals("No"))
                                                {%> disabled="true" <%}%> class="btn btn-warning btn-sm">
                                    </form>
                                </div>           
                            </div>  
                        </div>
                   <%}%>
               </div>
      </div>
    </body>
</html>