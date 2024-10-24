<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Compte Bancaire</title>
<link rel="stylesheet" type="text/css" href="style1.css" />
</head>
<body>
  <h1>Banque of Africa</h1>
   <div id="formBanque">
     <form action="compte" method="post">
       <table>
        <tr>
          <td>Code1:</td>
           <td>
             <input type="text" name="code1" />
           </td>
        </tr>
        
        <tr>
          <td>Code2:</td>
           <td>
             <input type="text" name="code2" />
           </td>
        </tr>
        
        <tr>
          <td>Montant 1:</td>
           <td>
             <input type="text" name="montant" />
           </td>
        </tr>
        
        <tr>
          <td>Montant 2:</td>
           <td>
             <input type="text" name="montant" />
           </td>
        </tr>
        
        <tr>
           <td colspan="2">
           <input type="submit" name="action" value="Verser" />
           <input type="submit" name="action" value="Retirer" />
           <input type="submit" name="action" value="Virement" />
           <input type="submit" name="action" value="Ajouter" />
           </td>
        </tr>
       </table>
     </form>
   </div>
   
   <div>
      <table class="table1">
        <tr>
         <th>CODE</th> <th>Solde</th> <th>Date Création</th> <th>Activé</th><th>Operations</th>
        </tr>
        <c:forEach items="${list_ejb}" var="cp">
          <tr>
            <td>${cp.code}</td>
            <td>${cp.solde}</td>
            <td>${cp.dateCreation}</td>
            <td>${cp.active}</td>
            <td><a href="compte?action=delete&code=${cp.code}">Supprimer</a></td>
          </tr>
        </c:forEach>
      </table>
   </div>
</body>
</html>