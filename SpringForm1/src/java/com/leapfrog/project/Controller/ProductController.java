
package com.leapfrog.project.Controller;


import com.leapfrog.project.DAO.ProductDAO;
import com.leapfrog.project.Entity.Product;
import java.sql.SQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping(value = "/addProduct")
public class ProductController {
    
    @Autowired
    private ProductDAO productDAO;
    
@RequestMapping(method = RequestMethod.POST)
public String save(@ModelAttribute("addProduct") Product product){
    
    
        try {
            productDAO.insert(product);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error in inserting ");
        }
    
    return "redirect:/";
}

    
    
    
}
