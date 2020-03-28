<%-- 
    Document   : historialindex
    Created on : 26-mar-2020, 3:57:54
    Author     : jpcas
--%>
<%@page import="Modelo.Especialidad"%>
<%@page import="Modelo.Doctor"%>
<%@page import="Modelo.Paciente"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="Modelo.Cita"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="styles/historial.css">
        
        <%
        String tipoForm= (String) request.getAttribute("tipoFormulario");
            
        %>  
       
    </head>
    <body>
        <div class="container" style="margin-top: 5px; ">  
        <jsp:include page="../includes/header.jsp"></jsp:include>
        </div>
        
        <div class="cuerpo">
        <% if(tipoForm == null){%>
            <h2 class="titulo">Consultar</h2>
            <form class="boton" action="HistorialCtrl" method="GET">
                <input type="submit" name="accion" value="Por Paciente" class="btn btn-success btn-sm" >       
            </form>
            <form class="boton" action="HistorialCtrl" method="GET">
                <input type="submit" name="accion" value="Por Doctor" class="btn btn-success btn-sm" >       
            </form>
            <form class="boton" action="HistorialCtrl" method="GET">
                <input type="submit" name="accion" value="Por Especialidad" class="btn btn-success btn-sm">       
            </form >
            <form class="boton" action="HistorialCtrl" method="GET">
                <input type="submit" name="accion" value="Por Fecha" class="btn btn-success btn-sm" > 
               
            </form>
           
            <%}%>
            <% if(tipoForm == "Consultar Por Paciente"){
            List<Paciente> pacientes = (List<Paciente>) request.getAttribute("pacientes");
            
             %>
            <form action="HistorialCtrl" method="GET">
                    <div class="form-group item">
                        <h3>Seleccione El Paciente A Consutar</h3>
                        <select class="custom-select" name="idPaciente" style="color: #000">
                            <option selected>Choose...</option>
                             <% for (Paciente paciente : pacientes) {%>
                                <option value="<%=paciente.getId()%>"><%=paciente.getNombre()%> <%=paciente.getApellido()%></option>
                            <%}%>
                        </select>
                    </div>
                    <input type="submit" class="btn btn-success crear" value="<%=tipoForm%>" name="accion" >
            </form>
            
            <%}%>
            
            <% if(tipoForm == "Consultar Por Doctor"){
            List<Doctor> doctores = (List<Doctor>) request.getAttribute("doctores");
            
             %>
            <form action="HistorialCtrl" method="GET">
                    <div class="form-group item">
                        <h3>Seleccione El Doctor A Consutar</h3>
                        <select class="custom-select" name="idDoctor" style="color: #000 ">
                            <option selected>Choose...</option>
                             <% for (Doctor doctor : doctores) {%>
                                <option value="<%=doctor.getId()%>"><%=doctor.getNombre()%> <%=doctor.getApellido()%></option>
                            <%}%>
                        </select>
                    </div>
                    <input type="submit" class="btn btn-success crear" value="<%=tipoForm%>" name="accion" >
            </form>
            
            <%}%>
            
            <% if(tipoForm == "Consultar Por Especialidad"){
            List<Especialidad> especialidades = (List<Especialidad>) request.getAttribute("especialidades");
            
             %>
            <form action="HistorialCtrl" method="GET">
                    <div class="form-group item">
                        <h3>Seleccione La Especialidad A Consutar</h3>
                        <select class="custom-select" name="idEspecialidad" style="color: #000">
                            <option selected>Choose...</option>
                             <% for (Especialidad especialidad : especialidades) {%>
                                <option value="<%=especialidad.getId()%>"><%=especialidad.getNombre()%></option>
                            <%}%>
                        </select>
                    </div>
                    <input type="submit" class="btn btn-success crear" value="<%=tipoForm%>" name="accion" >
            </form>
            
            <%}%>
            
             <% if(tipoForm == "Consultar Por Fecha"){
             %>
            <form action="HistorialCtrl" method="GET">
                    <div class="form-group item">
                        <h3>Ingrese la fecha a consultar</h3>
                        <div class="form-group">
                            <label for="fecha">Fecha</label> 
                            <input type="date" class="form-control" name="fecha" id="fecha" required="required"/>
                        </div>
                    </div>
                    <input type="submit" class="btn btn-success crear" value="<%=tipoForm%>" name="accion" >
            </form>
            
            <%}%>
            
            
        
         </div>
    </body>
</html>
