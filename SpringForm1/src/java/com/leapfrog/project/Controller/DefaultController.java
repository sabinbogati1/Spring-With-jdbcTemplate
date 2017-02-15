package com.leapfrog.project.Controller;

import com.leapfrog.project.DAO.ProductDAO;
import com.leapfrog.project.Entity.Product;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DefaultController {

    @Autowired
    private ProductDAO productDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.GET)
    public String addStudent() {

        return "addStudent";
    }

    @RequestMapping(value = "/viewStudent/update/{id}", method = RequestMethod.GET)
    public String update(Model model) {

        try {
            model.addAttribute("proUpdate", productDAO.getById(1));
        } catch (SQLException | ClassNotFoundException ex) {

        }
        return "updateStudent";
    }

    @RequestMapping(value = "/viewStudent/delete/{id}", method = RequestMethod.GET)
    public String delete() {

        return "deleteStudent";
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public String getById(Model model, @PathVariable(value = "id") String id) {

        System.out.println("##################" + id + "############################################3333");
        try {
            int n=Integer.parseInt(id);
            model.addAttribute("product", productDAO.getById(n));

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("error in default controller getALL method");
        }
        return "getById";
    }

    /*  
     @RequestMapping(value = "/product/{id}",method = RequestMethod.GET)
    
     public String getById(@PathVariable("id") int id){
        
        
     return productDAO.getById(id).getName();
     }
    
     */
    @RequestMapping(value = "/viewStudent", method = RequestMethod.GET)
    public String viewStudent(Model model) {

        try {
            model.addAttribute("product", productDAO.getAll());
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("error in default controller getALL method");
        }

        /*  Product pro= new Product();
         pro.setId(1);
         pro.setName("sabin bro");
         pro.setDescription("This iss sabin");
         model.addAttribute("product",pro);*/
        return "viewStudent";
    }

}
