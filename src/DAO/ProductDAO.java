/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utilities.JdbcHelper;
import com.sun.jdi.connect.spi.Connection;
import java.sql.PreparedStatement;
import model.Product;

/**
 *
 * @author maccuacu
 */
public class ProductDAO {
    
    private Connection connection = (Connection) JdbcHelper.getConnection();

    public ProductDAO() {
    }
    

    
}
