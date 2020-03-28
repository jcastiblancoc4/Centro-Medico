<%-- 
    Document   : gestion
    Created on : 27-mar-2020, 14:14:46
    Author     : jpcas
--%>
<%@page import="Modelo.Cita"%>
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
        <% 
        String tipoForm= (String) request.getAttribute("tipoFormulario");
        Cita cita = (Cita) request.getAttribute("cita");
        %>
        
    </head>
    <body>
        <jsp:include page="../includes/header.jsp"></jsp:include>
        <% if(tipoForm.equals("gestionar")){
            int dias = (Integer) request.getAttribute("dias");
        %> 
        <div class="container" style="background: #ffffff">
            <h2>Gestion Cita Numero ${cita.id}</h2>
            <div>
                <form  action="CitasCtrl" method="POST" style="display:inline-block; padding: 10px">
                    <input type="hidden" name="id" value="${cita.id}">
                    <input type="submit" name="accion" value="actualizar"
                            class="btn btn-danger btn-sm">
                </form>
            </div>
            <div>        
                <form  action="CitasCtrl" method="POST" style="display:inline-block; padding: 10px">
                    <input type="hidden" name="id" value="${cita.id}">
                    <input type="submit" name="accion" value="atender" class="btn btn-danger btn-sm">
                </form>
            </div>
            <div>        
                <form  action="CitasCtrl" method="POST" style="display:inline-block; padding: 10px">
                    <input type="hidden" name="id" value="${cita.id}">
                    <input type="submit" name="accion" value="cancelar" <%if(dias<3){%> disabled="true" <%}%> class="btn btn-danger btn-sm">
                </form>
            </div>
        </div>
        <%}
         if(tipoForm.equals("cancelar")){
        %>
        <div class="container">
        <h2>Desea Eliminar El Registro De La Cita ${cita.id} Del Sistema?</h2>
        
        <div>
            <form  action="CitasCtrl" method="POST" style="display:inline-block; padding: 10px">
                <input type="hidden" name="id" value="${cita.id}">
                <input type="submit" name="accion" value="Si"  class="btn btn-danger btn-sm">
            </form>
            <form  action="CitasCtrl" method="POST" style="display:inline-block; padding: 10px">
                <input type="submit" name="accion" value="No"  class="btn btn-danger btn-sm">
            </form>
         </div>
         </div>
        <%}
            if(tipoForm.equals("atender")){
        %>
        <div class="container" style="background:  #ffffff">
        <h2>Atencion Cita ${cita.id}</h2>
        <div>
            <form  action="CitasCtrl" method="POST" style="display:inline-block; padding: 10px">
            
            <div class="item">
                        <h4>El Paciente Fue Atendido?</h4>
                        <select class="custom-select" name="asistio" style="margin-left:20px; width: 100px ">
                            <option selected>Choose...</option>
                             <option value="Si">Si</option>
                             <option value="No">No</option>
                        </select>
                    </div>
            <div class="item" >
                <label>Observaciones de la consulta:</label>
                <textarea type="text" class="form-control" style="margin-bottom: 20px" name="observacion"></textarea>
            </div>
            
                <input type="submit" name="accion" value="terminar consulta"  class="btn btn-danger btn-sm">
            </form>
         </div>
         </div>
        <%}%>
    </body>
</html>
