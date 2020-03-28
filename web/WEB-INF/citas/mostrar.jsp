<%@page import="Modelo.Agenda"%>
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
        <link rel="stylesheet" type="text/css" href="styles/cita.css">
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
        <div class="container" style="margin-top: 5px; ">  
        <jsp:include page="../includes/header.jsp"></jsp:include>
        </div>
        <div class="cuerpo">
            <% if(tipoForm.equals("especialidad")){ %>
                <h3 class="titulo">Creacion de Cita Paciente</h3>
                <form action="CitasCtrl" method="POST">
                    <div class="form-group item">
                        <h4>Seleccione Paciente</h4>
                        <select class="custom-select" name="idPaciente" style="color: #000">
                            <option selected>Choose...</option>
                            <% for (Paciente paciente : pacientes) {%>
                                <option value="<%=paciente.getId()%>"><%=paciente.getNombre()%> <%=paciente.getApellido()%></option>
                            <%}%>
                        </select>
                    </div>
                    <input type="submit" class="btn btn-success crear" value="<%=tipoForm%>" name="accion" >
                </form>
            <%}
            if(tipoForm.equals("doctor")){
            String paciente1= (String) request.getAttribute("paciente");
            String cedulaPaciente= (String) request.getAttribute("cedulaPaciente");
            %>
                <h3 class="titulo">Creacion de Cita Paciente <%=paciente1%></h3>
                <form action="CitasCtrl" method="POST">
                    <div class="form-group item">
                        <h4>Paciente: <%=paciente1%> </h4>
                        <h4>Cedula Paciente: <%=cedulaPaciente%> </h4>
                        <h3>Seleccione Especialidad</h3>
                        <select class="custom-select" name="idEspecialidad" style="color: #000">
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
           
            %>
            <h3 class="titulo">Creacion de Cita Doctores de <%=especialidad%> </h3>
                <h4>Paciente: <%=paciente1%> </h4>
                <h4>Cedula Paciente: <%=cedulaPaciente%> </h4>
                <h4>Especialidad: <%=especialidad%> </h4>
                <h4 style="color: red">Valor De La Consulta: $<%=valor%> </h4>
                    <div style="margin: 0 auto 10px; display: inline-block; text-align:center ">
                        <h3>Seleccione Un Doctor</h3>
                        <c:forEach items="${doctoresE}" var="doctor">
                            <div class="doc col-sm-5">
                            <form action="CitasCtrl" method="POST">
                                <img src="${doctor.rutaFoto}" width="100" height="100" >
                                <h4>${doctor.nombre} ${doctor.apellido}</h4>
                                <h4>Cedula: ${doctor.cedula}</h4>
                                <input type="hidden" name="idDoctor" value="${doctor.id}">
                                <input type="submit" class="btn btn-success crear" value="<%=tipoForm%>" name="accion" >
                            </form>
                            </div>
                        </c:forEach>
                    </div>
            <%}if(tipoForm.equals("hora")){
            String paciente1= (String) request.getAttribute("paciente");
            String cedulaPaciente= (String) request.getAttribute("cedulaPaciente");
            String especialidad= (String) request.getAttribute("especialidad");
            int valor= (Integer) request.getAttribute("valor");
            String doctor= (String) request.getAttribute("doctor");
            String cedulaDoctor= (String) request.getAttribute("cedulaDoctor");
            
            %>
            <h3 class="titulo">Agenda Doctor <%=doctor%> </h3>
                <h4>Paciente: <%=paciente1%> </h4>
                <h4>Cedula Paciente: <%=cedulaPaciente%> </h4>
                <h4>Especialidad: <%=especialidad%> </h4>
                <h4 style="color: red">Valor De La Consulta: $<%=valor%> </h4>
                <h4>Doctor: <%=doctor%> </h4>
                <h4>Cedula Doctor: $<%=cedulaDoctor%> </h4>
                    <div style="margin: 20px ">
                        <h3>Ingrese fecha </h3>
                        <form action="CitasCtrl" method="POST">
                            <div class="">
                                <input type="date" style="color: #000" name="fecha" id="fecha" required="required"/>
                            </div>
                            <input type="submit" class="btn btn-success crear"  style="margin-top:10px" value="<%=tipoForm%>" name="accion" >
                        </form>
                    </div>
            <%}
            if(tipoForm.equals("validar-crear")){
            String paciente1= (String) request.getAttribute("paciente");
            String cedulaPaciente= (String) request.getAttribute("cedulaPaciente");
            String especialidad= (String) request.getAttribute("especialidad");
            int valor= (Integer) request.getAttribute("valor");
            String doctor= (String) request.getAttribute("doctor");
            String cedulaDoctor= (String) request.getAttribute("cedulaDoctor");
            String fecha = (String) request.getAttribute("fecha");
             List<Agenda> horario = (List<Agenda>) request.getAttribute("horario");
            %>
            <h3 class="titulo">Horario Del Doctor <%=doctor%> </h3>
                <h4>Paciente: <%=paciente1%> </h4>
                <h4>Cedula Paciente: <%=cedulaPaciente%> </h4>
                <h4>Especialidad: <%=especialidad%> </h4>
                <h4 style="color: red">Valor De La Consulta: $<%=valor%> </h4>
                <h4>Doctor: <%=doctor%> </h4>
                <h4>Cedula Doctor: $<%=cedulaDoctor%> </h4>
                <h4>Fecha Agendamiento: $<%=fecha%> </h4>
                    <div style="margin: 20px; display: inline-block; text-align:center  ">
                        <h3>Seleccione Una Franja</h3>
                        
                            <%for(Agenda franja: horario){ %>
                            <div class="franja" <%if(franja.getEstado().equals("asignada")){%> style="background-image: url('img/img/fondo.jpg')" <%}%>>
                            <form action="CitasCtrl" method="POST" >
                                
                                    <span>Hora de Inicio: <%=franja.getHoraInicio()%>   </span>
                                    <span>Hora Fin: <%=franja.getHoraFin()%>   </span>
                                    <span>Estado: <%=franja.getEstado()%></span>
                                
                                <%if(franja.getEstado().equals("disponible")){%>   
                                <input type="hidden" name="hora" value="<%=franja.getHoraInicio()%>">
                                <input type="submit" class="btn btn-success crear" value="<%=tipoForm%>" name="accion" >
                                <%}%>
                            </form>
                            </div>
                                <%}%>       
                       
                    </div>
            <%}
            

            
            %>
            
                        
            
        </div>
    </body>
</html>
