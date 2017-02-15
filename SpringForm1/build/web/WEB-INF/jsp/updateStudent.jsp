<%@ include file="header.jsp" %>
    
<form action="${SITE_URL}/addProduct" method="POST">
   
  <div class="form-group">
    <label for="email">Name</label>
    <input type="text" class="form-control" id="email" name="name" value=${proUpdate.name}>
  </div>
  <div class="form-group">
    <label for="pwd">Description</label>
    <input type="text" class="form-control" id="pwd" name="description" value=${proUpdate.description}>
  </div>
    <div class="form-group">
    <label for="email">Cost Price</label>
    <input type="text" class="form-control" id="email" name="costPrice" value=${proUpdate.costPrice}>
  </div>
     <div class="form-group">
    <label for="email">Selling Price</label>
    <input type="text" class="form-control" id="email" name="sellingPrice" value=${proUpdate.sellingPrice}>
  </div>
  
  <button type="submit" class="btn btn-default">Submit</button>
</form>
      
    </body>
</html>
