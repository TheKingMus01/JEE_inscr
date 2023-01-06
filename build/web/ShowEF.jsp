<%@page import="ma.projet.beans.Etudiant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.*" %>
<html>
<HEAD>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        <title>Etudiant</title>
        <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
  <style>
      #back{
          position: relative;
          right:       -1400px;
      }
      #ta{
          width:   90%;
      }
      
      a:visited {
  color: white;
}

/* mouse over link */
a:hover {
  color: cadetblue;
}

/* selected link */
a:active {
  color: burlywood;
}
h1{
    padding-top: 50px;
}
      
  </style>
</HEAD>
<body>
    
    <%
                         int code =  Integer.parseInt(request.getParameter("code"));

    %>
     
     <center>
<h1>Liste des étudiants : </h1>
<TABLE class="table" id="ta">
  <thead class="thead-dark">

    <tr>
<th scope="col">CNE</th>
<th scope="col"> NOM</th>
<th scope="col">PRENOM</th>
<th scope="col">DATE DE NAISSANCE</th>
<th scope="col">TYPE DE BAC</th>
<th scope="col">CODE DE FORMATION</th>
<th scope="col">TITRE DE FORMATION</th>
<th scope="col">NOMBRE D'HEURES</th>
<th scope="col">
      <a href="Controleur?do_this=addtoF&code=<%= code%>" <button type="button" class="btn btn-primary btn-block"> Ajouter </button></a>

</tr>
               <% List<Etudiant> list = (List) request.getAttribute("listEF");%> 
 
			<% 
				for (Etudiant e : list) { 
			%>
    <br> 
  <tr>
                      <th scope="row"> <%=e.getCNE()%> </th>
                      <td> <%=e.getNom()%> </td>
                      <td> <%=e.getPrenom()%> </td>
                      <td> <%=e.getDate_de_naissance()%> </td>
                      <td> <%=e.getType_de_Bac()%> </td>
                      <td> <%=e.getCode_de_formation()%> </td>
                      <td> <%=e.getTitre_de_formation()%> </td>
                      <td> <%=e.getNombre_heures()%> </td>
                      
                      
                      
 </tr>
 <% 
				} 
			%>
            
  </table>



 </center>
<button class="btn btn-danger hBack" type="button" id="back">BACK</button>
<script>
$(".hBack").on("click", function(e){
    e.preventDefault();
    window.history.back();
});</script>