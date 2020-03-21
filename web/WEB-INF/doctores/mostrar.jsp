<%@page import="Modelo.Especialidad"%>
<%@page import="java.util.List"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="Modelo.Doctor"%>
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
        
            List<Especialidad> especialidades = (List<Especialidad>) request.getAttribute("especialidades");
        
        Doctor doctor=null;
        if(tipoForm.equals("actualizar")){
        doctor = (Doctor) request.getAttribute("doctor");
        }
        
        
    %>  
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"></jsp:include>
        <div class=" contenedor">
            <h3 class="titulo"><%=tipoForm%> Doctor</h3>
            <form action="DoctoresCtrl" method="POST">
                    <div class="form-group item">
                        <label>Cedula:</label>
                        <input type="text" class="form-control" name="cedula" value="${doctor.cedula}">
                    </div>    
                    <div class="form-group item">
                        <label>Nombre:</label>
                        <input type="text" class="form-control" name="id" value="${doctor.id}" style="display:none">
                        <input type="text" class="form-control" name="nombre" value="${doctor.nombre}">
                    </div>
                    <div class="form-group item">
                        <label>Apellido:</label>
                        <input type="text" class="form-control" name="apellido" value="${doctor.apellido}">
                    </div>
                    <div class="form-group item">
                        <label>Direccion:</label>
                        <input type="text" class="form-control" name="direccion" value="${doctor.direccion}">
                    </div>
                    <div class="form-group item">
                        <label>Correo:</label>
                        <input type="email" class="form-control" name="correo" value="${doctor.correo}">
                    </div>
                    <div class="form-group item">
                        <label>Celular</label>
                        <input type="number" class="form-control" name="celular" value="${doctor.celular}">
                    </div>
                    
                    <div class="form-group item">
                        <label>Especialidad</label>
                        <select class="custom-select" name="idEspecialidad" style="margin-left:20px">
                            <option selected>Choose...${doctor.nombreEspecialidad}</option>
                             <% for (Especialidad especialidad : especialidades) {%>
                                <option value="<%=especialidad.getId()%>"><%=especialidad.getNombre()%></option>
                            <%}%>
                        </select>
                    </div>
                        <div class="ml-2 mt-2">
			<input class="form-control-sm" type="file" name="foto" placeholder="Subir imagen" value=""/>
                    </div>
                   
                    <input type="submit" class="btn btn-success crear" value="<%=tipoForm%>" name="accion" >
            </form>
        </div>
    </body>
</html>
