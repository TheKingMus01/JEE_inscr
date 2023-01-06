<%@page import="ma.projet.dao.IDao"%>
<%@page import="ma.projet.beans.Etudiant"%>
<%@page import="ma.projet.beans.formation"%>
<%@page import="ma.projet.service.EtudiantService"%>
<%@page import="ma.projet.service.FormationService"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css" integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">

        <title>Insert Etudiant</title>
        <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <style>
      @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;700;900&display=swap');

*, body {
    font-family: 'Poppins', sans-serif;
    font-weight: 400;
    -webkit-font-smoothing: antialiased;
    text-rendering: optimizeLegibility;
    -moz-osx-font-smoothing: grayscale;
}

html, body {
    height: 100%;
    background-color: #152733;
    overflow: hidden;
}


.form-holder {
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      text-align: center;
      min-height: 100vh;
}

.form-holder .form-content {
    position: relative;
    text-align: center;
    display: -webkit-box;
    display: -moz-box;
    display: -ms-flexbox;
    display: -webkit-flex;
    display: flex;
    -webkit-justify-content: center;
    justify-content: center;
    -webkit-align-items: center;
    align-items: center;
    padding: 60px;
}

.form-content .form-items {
    border: 3px solid #fff;
    padding: 40px;
    display: inline-block;
    width: 100%;
    min-width: 540px;
    -webkit-border-radius: 10px;
    -moz-border-radius: 10px;
    border-radius: 10px;
    text-align: left;
    -webkit-transition: all 0.4s ease;
    transition: all 0.4s ease;
}

.form-content h3 {
    color: #fff;
    text-align: left;
    font-size: 28px;
    font-weight: 600;
    margin-bottom: 5px;
}

.form-content h3.form-title {
    margin-bottom: 30px;
}

.form-content p {
    color: #fff;
    text-align: left;
    font-size: 17px;
    font-weight: 300;
    line-height: 20px;
    margin-bottom: 30px;
}


.form-content label, .was-validated .form-check-input:invalid~.form-check-label, .was-validated .form-check-input:valid~.form-check-label{
    color: #fff;
}

.form-content input[type=text], .form-content input[type=date], .form-content select {
    width: 100%;
    padding: 9px 20px;
    text-align: left;
    border: 0;
    outline: 0;
    border-radius: 6px;
    background-color: #fff;
    font-size: 15px;
    font-weight: 300;
    color: #8D8D8D;
    -webkit-transition: all 0.3s ease;
    transition: all 0.3s ease;
    margin-top: 16px;
}


.btn-primary{
    background-color: #6C757D;
    outline: none;
    border: 0px;
     box-shadow: none;
}

.btn-primary:hover, .btn-primary:focus, .btn-primary:active{
    background-color: #495056;
    outline: none !important;
    border: none !important;
     box-shadow: none;
}

.form-content textarea {
    position: static !important;
    width: 100%;
    padding: 8px 20px;
    border-radius: 6px;
    text-align: left;
    background-color: #fff;
    border: 0;
    font-size: 15px;
    font-weight: 300;
    color: #8D8D8D;
    outline: none;
    resize: none;
    height: 120px;
    -webkit-transition: none;
    transition: none;
    margin-bottom: 14px;
}

.form-content textarea:hover, .form-content textarea:focus {
    border: 0;
    background-color: #ebeff8;
    color: #8D8D8D;
}

.mv-up{
    margin-top: -9px !important;
    margin-bottom: 8px !important;
}

.invalid-feedback{
    color: #ff606e;
}

.valid-feedback{
   color: #2acc80;
}
#back{
          position: relative;
          right:       -300px;
      }
  </style>
    </head>
    <body>
    <center>
        <h1 >
            <u>  Insertion d'un Etudiant </u></h1>
  <%
                     int cne =  Integer.parseInt(request.getParameter("cne"));
                     String nom = (String)request.getParameter("nom");
                     String prenom = (String)request.getParameter("prenom");
                     String date_de_naissance = (String)request.getParameter("date_de_naissance");
                     String type_de_Bac = (String)request.getParameter("type_de_Bac");
                     int code_de_formation =  Integer.parseInt(request.getParameter("code_de_formation"));
  
  %>

    <div class="form-body">
        <div class="row">
            <div class="form-holder">
                <div class="form-content">
                    <div class="form-items">
                        <h3>Insertion </h3>
                        <p>Etudiant Formation</p>
                         <div class="alert alert-success collapse" id="myalert">
                             <strong>Success!</strong> Ajouter avec succès.
                         </div>
                        
                       
                        
                        
                        <br>
                        <form class="requires-validation" action="Controleur"  action="POST" novalidate>
                            
                            <input type="hidden" name="do_this" value="create"/>
                            
                            <div class="col-md-12"hidden >
                               <input class="form-control" type="text" name="cne" value="<%= cne %>" required>
                               
                            </div>
                            <div class="col-md-12" hidden>
                               <input class="form-control" type="text" name="nom" value="<%= nom%>" required>
                             
                            </div>
                            
                            <div class="col-md-12" hidden>
                               <input class="form-control" type="text" name="prenom" value="<%= prenom%>" required>
                              
                            </div>
                            
                               <div class="col-md-12" hidden>
                               <input class="form-control" type="date" name="date_de_naissance" value="<%= date_de_naissance%>" required>
                            
                            </div>
                            
                           <div class="col-md-12 mt-3" hidden>
                               <input class="form-control" type="text" name="type_de_Bac" value="<%= type_de_Bac%>" required>

                            
                            </div>
                            <div class="col-md-12" hidden>
                                <input class="form-control" type="text" name="code_de_formation" value="<%= code_de_formation%>" required>

                           
                           </div>
                            
                            
                            
                            <div class="col-md-12" >
                              
                                  <% List<formation> list = (List) request.getAttribute("listFormation");%> 
 
			<% 
				for (formation u : list) { 
			%> 
                                 <input class="form-control" type="text" name="Titre_de_formation" value="<%=u.getTitre_de_formation()%>" required readonly>
                                   <%
                                   }%>
                                <div class="valid-feedback">You selected a "Titre de formation!"</div>
                                <div class="invalid-feedback">Please select a "Titre de formation!"</div>
                           </div>
                                
                             <div class="col-md-12">
                              
                                   <c:forEach var="Formation" items = "${requestScope.listFormation}">
                                 <input class="form-control" type="text" name="nombre_heures" value="${Formation.nombre_heures}" required readonly>
                                    </c:forEach>
                                <div class="valid-feedback">You selected a "nombre heures!"</div>
                                <div class="invalid-feedback">Please select a "nombre heures!"</div>
                           </div>
                            


                        
                  

                            <div class="form-button mt-3">
                                <button id="submit" type="submit" class="btn btn-primary" >Valider</button>
                                <button class="btn btn-danger hBack" type="button" id="back">BACK</button>
<script>
$(".hBack").on("click", function(e){
    e.preventDefault();
    window.history.back();
});
</script>
<script>
$(document).ready(function(){
    $('#submit').click(function(){
        $('#myalert').show('fade');
    }); 
});
</script>
                            </div>
 
                        </form>
                                
                    </div>
                </div>
            </div>
        </div>
    </div>
   
 </center>
                               
    <script>
        (function () {
'use strict'
const forms = document.querySelectorAll('.requires-validation')
Array.from(forms)
  .forEach(function (form) {
    form.addEventListener('submit', function (event) {
      if (!form.checkValidity()) {
        event.preventDefault()
        event.stopPropagation()
      }

      form.classList.add('was-validated')
    }, false)
  })
})()

    </script>
    </body>
</html>