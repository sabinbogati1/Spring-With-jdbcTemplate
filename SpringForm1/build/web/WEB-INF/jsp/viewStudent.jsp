<%@ include file="header.jsp" %>


<div class="container">
         

    <table class="table table-striped">
      <thead>
        <tr>
          <th>Id</th>
          
          <th> Name</th>
         
          
          <th>Update</th>
          <th>Delete</th>
        </tr>
      </thead>
      <tbody>
          <c:forEach var="pro" items="${product}">

          <tr>
      <td>${pro.id}</td>
      <td><a href="${SITE_URL}/product/${pro.id}">${pro.name} </a></td> 
      
      
      
      <td> <a href="${SITE_URL}/viewStudent/update/${pro.id}"><button type="button" class="btn btn-success" >update</button> </a></td>
      <td>  <a href="${SITE_URL}/viewStudent/delete/${pro.id}"><button type="button" class="btn btn-danger">Delete</button> </a></td>
    </tr>
          </c:forEach>
      </tbody>
    </table> 

 
</div>
</body>
</html>
