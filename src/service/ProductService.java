/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import DAO.ProductDAO;
import java.util.List;
import model.Product;

/**
 *
 * @author maccuacu
 */
public class ProductService implements IService<Product>{
    private ProductDAO prDao = new ProductDAO();

    @Override
    public void insert(Product t) {
        
        this.prDao.addProduct(t);
    }

    @Override
    public void update(Product t, String index) {
        this.prDao.updateProduct(t);
    }

    @Override
    public void delete(String index) {
        this.prDao.deleteProduct(index);
    }

    @Override
    public List<Product> findAll() {

        return this.prDao.getAllProducts() ;

    }

    @Override
    public Product findById(String index) {
        

        return this.findById(index) ;

    }
    
    
    
}
