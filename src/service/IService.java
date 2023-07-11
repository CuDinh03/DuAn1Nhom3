/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;

/**
 *
 * @author maccuacu
 */
public interface IService<T> {
    
    void insert(T t);
    void update (T t, String index);
    void delete( String index);
    List<T> findAll();
    T findById(String index);
    
}
