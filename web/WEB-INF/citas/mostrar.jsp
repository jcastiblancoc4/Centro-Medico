<%@page import="Modelo.Doctor"%>
<%@page import="Modelo.Cita"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="Modelo.Paciente"%>
<%@page import="Modelo.Especialidad"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <style>
            .contenedor{
                border: solid black;
                width: 60%;
                
                margin: 0 auto;
                margin-top: 2%;
                margin-bottom: 30px;
                padding: 2%;
            }
            .titulo{
                display:inline-block;
                margin: 15px auto 20px 2%;
                padding: 0;
                text-transform: uppercase;
                font-weight: 600;
            }
            .item{
                margin-left: 2%;
            }
            .crear{
                margin: 10px auto auto 2%;
            }
            label{
                text-transform: uppercase;
                font-weight: 600;
                
            }
            
           
        </style>
          <%
        String tipoForm= (String) request.getAttribute("tipoFormulario");
            List<Paciente> pacientes = (List<Paciente>) request.getAttribute("pacientes");
            List<Especialidad> especialidades = (List<Especialidad>) request.getAttribute("especialidades");
        
        Cita cita=null;
        if(tipoForm.equals("actualizar")){
        cita = (Cita) request.getAttribute("cita");
        }
        
        
    %>  
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"></jsp:include>
        <div class=" contenedor">
            <% if(tipoForm.equals("doctor")){ %>
            <h3 class="titulo">Creacion de Cita</h3>
            <form action="CitasCtrl" method="POST">
                    <div class="form-group item">
                        <h3>Selecciones Paciente</h3>
                        <select class="custom-select" name="idPaciente" style="margin-left:20px; width: 100px ">
                            <option selected>Choose...</option>
                             <% for (Paciente paciente : pacientes) {%>
                                <option value="<%=paciente.getId()%>"><%=paciente.getNombre()%> <%=paciente.getApellido()%></option>
                            <%}%>
                        </select>
                    </div>
                    <div class="form-group item">
                        <h3>Seleccione Especialidad</h3>
                        <select class="custom-select" name="idEspecialidad" style="margin-left:20px">
                            <option selected>Choose...</option>
                             <% for (Especialidad especialidad : especialidades) {%>
                                <option value="<%=especialidad.getId()%>"><%=especialidad.getNombre()%></option>
                            <%}%>
                        </select>
                    </div>
                    <input type="submit" class="btn btn-success crear" value="<%=tipoForm%>" name="accion" >
            </form>
        <%}       
        if(tipoForm.equals("agenda")){
        String paciente1= (String) request.getAttribute("paciente");
        String cedulaPaciente= (String) request.getAttribute("cedulaPaciente");
        String especialidad= (String) request.getAttribute("especialidad");
        int valor= (Integer) request.getAttribute("valor");
        List<Doctor> doctores = (List<Doctor>) request.getAttribute("doctoresE");

%>
    <h3 class="titulo">Creacion de Cita ${especialidad}</h3>
        <h5>Paciente: <%=paciente1%> </h5>
        <h5>Cedula Paciente: <%=cedulaPaciente%> </h5>
        <h5>Especialidad: <%=especialidad%> </h5>
        <h5>Valor De La Consulta: $<%=valor%> </h5>
         
        <div style="margin: 20px ">
            <h3>Seleccione Un Doctor</h3>
            <c:forEach items="${doctoresE}" var="doctor">
                <form action="CitasCtrl" method="GET">
                    
                    <img src="${doctor.rutaFoto}" width="100" height="100" >
                    <h4>${doctor.nombre} ${doctor.apellido}</h4>
                    <h4>Cedula: ${doctor.cedula}</h4>
                    <input type="hidden" name="id" value="${doctor.id}">
                    <input type="submit" class="btn btn-success crear" value="<%=tipoForm%>" name="accion" >
                    <span><%=tipoForm%></span>
                        
               </form>
            </c:forEach>
        </div>
        <%}
        if(tipoForm.equals("crear")){
        %>
        
        
         <h3>Agenda del doctor</h3>
        
        <%}%>
        
        
        
        
        
        
        
        
        
              
        </div>
    </body>
</html>
