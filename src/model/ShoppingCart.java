/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;

/**
 *
 * @author maccuacu
 */
public class ShoppingCart {
    private String id;
    private List<Items> itemsList;
    private String nameKh;
    private String nameNv;

    public ShoppingCart() {
    }

    public ShoppingCart(String id, List<Items> itemsList, String nameKh, String nameNv) {
        this.id = id;
        this.itemsList = itemsList;
        this.nameKh = nameKh;
        this.nameNv = nameNv;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Items> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<Items> itemsList) {
        this.itemsList = itemsList;
    }

    public String getNameKh() {
        return nameKh;
    }

    public void setNameKh(String nameKh) {
        this.nameKh = nameKh;
    }

    public String getNameNv() {
        return nameNv;
    }

    public void setNameNv(String nameNv) {
        this.nameNv = nameNv;
    }
    
    
}
