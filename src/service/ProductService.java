<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import DAO.ProductDAO;
import java.util.List;
import model.Product;

import model.Product;

import service.IService;

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
<<<<<<< HEAD
        this.prDao.updateProduct(t);
=======

        this.prDao.updateProduct(t);

>>>>>>> 85af030e942fc82d64fcd49e7b4709f105861740
    }

    @Override
    public void delete(String index) {
<<<<<<< HEAD
        this.prDao.deleteProduct(index);
=======

        this.prDao.deleteProduct(index);

>>>>>>> 85af030e942fc82d64fcd49e7b4709f105861740
    }

    @Override
    public List<Product> findAll() {
<<<<<<< HEAD
        return this.prDao.getAllProducts() ;
=======


        return this.prDao.getAllProducts() ;


>>>>>>> 85af030e942fc82d64fcd49e7b4709f105861740
    }

    @Override
    public Product findById(String index) {
        
<<<<<<< HEAD
        return this.findById(index) ;
=======


        return this.findById(index) ;


>>>>>>> 85af030e942fc82d64fcd49e7b4709f105861740
    }
    
    }
}  
    
    
