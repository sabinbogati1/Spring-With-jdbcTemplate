
package com.leapfrog.project.DAO;

import com.leapfrog.project.Entity.Product;
import java.sql.SQLException;
import java.util.List;


public interface ProductDAO {
    
    public int insert(Product product) throws SQLException, ClassNotFoundException;
    
    public List<Product> getAll() throws SQLException, ClassNotFoundException;
    
    public List<Product> getById(int id) throws SQLException, ClassNotFoundException;
    
}
