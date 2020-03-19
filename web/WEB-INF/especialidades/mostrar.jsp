<%-- 
    Document   : mostrar
    Created on : 13/02/2020, 05:04:13 PM
    Author     : Produccion Software
--%>

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
                margin: 0 auto;
                margin-top: 2%;
                padding: 2%;
                width: 60%;
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
            .valor::before{
                content: '$';
            }
            label{
                text-transform: uppercase;
                font-weight: 600;
            }
            
            
           
        </style>
          <%
        String tipoForm= (String) request.getAttribute("tipoFormulario");
        String mensaje = (String) request.getAttribute("mensaje");
        Especialidad especialidad=null;
        if(tipoForm.equals("actualizar")){
        especialidad = (Especialidad) request.getAttribute("especialidad");
        }
        
        
    %>  
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"></jsp:include>
        <div class="container contenedor">
            <h3 class="titulo"><%=tipoForm%> Especialidad</h3>
            <form action="EspecialidadesCtrl" method="POST">
                    <div class="form-group item">
                        <label>Nombre</label>
                        <input type="text" class="form-control" name="id" value="${especialidad.id}" style="display:none">
                        <input type="text" class="form-control" name="nombre" value="${especialidad.nombre}">
                    </div>
                    <div class="item" >
                        <label>Descripcion</label>
                        <textarea type="text" class="form-control" style="margin-bottom: 20px" name="descripcion">${especialidad.descripcion}</textarea>
                    </div>
                    <div class="form-row item" >
                        <div class="col-sm-6">
                            <label>Costo Consulta</label>
                            <input type="number" class="form-control" name="costo_consulta" value="${especialidad.costo_consulta}" max="100000" min="30000" step="10000">
                        </div>
                      
                        <div class="col-sm-6">
                            <label>Duracion Consulta</label>
                            <input type="time" class="form-control"name="duracion_consulta" value="${especialidad.duracion_consulta}" max="02:00:00" min="00:30:00" step="1">
                        </div>
                    </div>
                        <div class="input-group mb-3">
                            <input type="submit" class="btn btn-success crear" value="<%=tipoForm%>" name="accion" >
            </form>
            
            
        </div>
    </body>
</html>
