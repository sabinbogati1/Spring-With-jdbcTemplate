/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.project.DAO.Impl;

import com.leapfrog.project.DAO.ProductDAO;
import com.leapfrog.project.Entity.Product;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

    
    
    @Autowired
     private JdbcTemplate jdbcTemplate;
    @Override
    public int insert(Product product) throws SQLException, ClassNotFoundException {
        
       String sql="INSERT INTO product(name,description,costPrice,sellingPrice) values(?,?,?,?)";
       
       return jdbcTemplate.update(sql, new Object[]{product.getName(),product.getDescription(),product.getCostPrice(),product.getSellingPrice()});
        
        
    }

    @Override
    public List<Product> getAll() throws SQLException, ClassNotFoundException {
        
        
        String sql="SELECT * FROM product";
        
        return jdbcTemplate.query(sql, new RowMapper<Product> () {

            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
               
                Product pro= new Product();
                pro.setId(rs.getInt("id"));
                pro.setName(rs.getString("name"));
                pro.setDescription(rs.getString("description"));
                pro.setCostPrice(rs.getInt("costPrice"));
                pro.setSellingPrice(rs.getInt("sellingPrice"));
                
                return pro;
            }
        });
    }

    @Override
    public List<Product> getById(int id) throws SQLException, ClassNotFoundException {
        
        String sql= "SELECT * FROM product WHERE id=?";
        
     return jdbcTemplate.query(sql, new RowMapper<Product>() {
            @Override
            public Product mapRow(ResultSet rs, int i) throws SQLException {
               
                Product p= new Product();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setDescription(rs.getString("description"));
                p.setCostPrice(rs.getInt("costPrice"));
                p.setSellingPrice(rs.getInt("sellingPrice"));
                
                return p;
            }
        }, new Object[]{id});
    
    
}
}