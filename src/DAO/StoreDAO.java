
package DAO;

import Utilities.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Store;

/**
 *
 * @author trung
 */
public class StoreDAO {

    private final Connection conn = JdbcHelper.getConnection();

    public void insertStore(Store store) {

        String sql = "INSERT INTO Store ( nameStore, adrStore,createDate , updateDate, storeStatus  ) VALUES ( ?, ?, ?, ?, 1)";
        try {

            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, store.getNameStore());
            statement.setString(2, store.getAdrStore());
          
            statement.setDate(3, new java.sql.Date(store.getCreateDate().getTime()));
            statement.setDate(4, new java.sql.Date(store.getUpdateDate().getTime()));

            statement.executeUpdate();

            System.out.println("Thêm mới bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Store> getAllStores() {
        List<Store> stores = new ArrayList<>();
        String sql = "SELECT * FROM Store where storeStatus = 1";
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Store store = new Store();
                store.setId(resultSet.getString("id"));
                store.setNameStore(resultSet.getString("nameStore"));
                store.setAdrStore(resultSet.getString("adrStore"));
        
                store.setCreateDate(resultSet.getDate("createDate"));
                store.setUpdateDate(resultSet.getDate("updateDate"));
                store.setStoreStatus(resultSet.getInt("storeStatus"));

                stores.add(store);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stores;
    }

    public void updateStore(Store store) {
        String sql = "UPDATE Store SET nameStore=?, adrStore=?, createDate=?, updateDate=?,storeStatus=? WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, store.getNameStore());
            statement.setString(2, store.getAdrStore());
            
            statement.setDate(3, new java.sql.Date(store.getCreateDate().getTime()));
            store.setCreateDate(new java.util.Date());

            statement.setDate(4, new java.sql.Date(store.getUpdateDate().getTime()));
            statement.setInt(5, store.getStoreStatus());
            statement.setString(6, store.getId());

            statement.executeUpdate();

            System.out.println("Cập nhật bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStoreById(String id) {
        String sql = "UPDATE Store SET storeStatus = 0  WHERE id=?";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, id);
            Store store = new Store();
            store.setUpdateDate(new java.util.Date());

            statement.setDate(5, new java.sql.Date(store.getUpdateDate().getTime()));
            statement.executeUpdate();

            System.out.println("Xóa bản ghi thành công.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Store findStoreByName(String storeName) {
        String sql = "SELECT * FROM Store WHERE nameStore LIKE ? AND storeStatus = 1";
        try {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, "%" + storeName + "%");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                Store store = new Store();
                store.setId(resultSet.getString("id"));
                store.setNameStore(resultSet.getString("ma"));
                store.setAdrStore(resultSet.getString("ten"));
                store.setCreateDate(resultSet.getDate("ngayTao"));
                store.setUpdateDate(resultSet.getDate("ngaySua"));
                store.setStoreStatus(resultSet.getInt("trangThai"));
                return store;

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
