
<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Principal</title>
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="styles/styles.css">
    </head>
    <body>
        <div class="container">
         <jsp:include page="WEB-INF/includes/header.jsp"></jsp:include>
       </div>
       <div class="cuerpo ">
           <h2>Proyecto Primer corte</h2>
           <p>
               Un centro médico, está interesado en realizar una aplicación que administre la información
               relacionada con sus pacientes y doctores.  Para ello requiere le sean solucionados los
               siguientes requerimientos: <br> <br>
                1. Control de la información de los pacientes y doctores. <br>
                2. Cada doctor tiene una información básica y una especialidad. <br>
                3. Para la identificación rápida de pacientes y doctores, el sistema requiere de una foto. <br>
                4. Cada paciente puede solicitar citas de acuerdo con la especialidad que requiera,
                una vez seleccionada, debe mostrar los doctores de esta especialidad, una vez seleccionado
                el doctor, se debe mostrar su horario de disponibilidad. <br>
                5. El horario de atención del centro médico es único para todos los doctores. <br>  
                6. Un paciente puede cancelar una cita hasta con tres días de antelación, después de esto
                el paciente y el centro médico, deben contemplar la cita como efectiva. Si se cancela 
                una cita, al médico le queda disponible este horario. <br>
                7. Un paciente puede tener hasta 3 citas por cumplir, al mismo tiempo, pero cada cita 
                debe ser de una especialidad distinta. <br>
                8. En el momento de solicitar una cita, al paciente se le debe mostrar el valor a pagar. <br>
                9. Los precios de las citas y el tiempo de duración de cada cita se definen con base a la especialidad.<br> 
                10. Después de la atención de cada cita, se debe saber si el paciente se atendió o no y 
                la cita pasa como historial del paciente.<br> 
                11. Se deben poder hacer consultas de las citas, por paciente, por médico, por especialidad, por fecha.
           </p>
           
       </div>
                                   
          
    </body>
</html>
