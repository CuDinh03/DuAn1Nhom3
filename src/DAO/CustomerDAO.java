package DAO;

import Utilities.JdbcHelper;
import java.sql.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Customer;

public class CustomerDAO {

    private Connection connection;

    public CustomerDAO() {
        this.connection = JdbcHelper.getConnection();
    }
    
    

    public void addCustomer(Customer customer) throws SQLException {
        String query = "INSERT INTO customer (userName, phone, userAddress, createDate, updateDate, cusStatus) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getUserName());
            statement.setString(2, customer.getPhone());
            statement.setString(3, customer.getUserAddress());
            statement.setDate(4, customer.getCreateDate());
            statement.setDate(5, customer.getUpdateDate());
            statement.setInt(6, customer.getCusStatus());

            statement.executeUpdate();
        }
    }

    public Customer getCustomerById(String id) throws SQLException {
        String query = "SELECT * FROM customer WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractCustomerFromResultSet(resultSet);
            }
        }
        return null;
    }

    public List<Customer> getAllCustomers() throws SQLException {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM customer";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Customer customer = extractCustomerFromResultSet(resultSet);
                customers.add(customer);
            }
        }
        return customers;
    }

    public void updateCustomer(Customer customer) throws SQLException {
        String query = "UPDATE customer SET userName = ?, phone = ?, userAddress = ?, "
                + "createDate = ?, updateDate = ?, cusStatus = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, customer.getUserName());
            statement.setString(2, customer.getPhone());
            statement.setString(3, customer.getUserAddress());
            statement.setDate(4, customer.getCreateDate());
            statement.setDate(5, customer.getUpdateDate());
            statement.setInt(6, customer.getCusStatus());
            statement.setString(7, customer.getId());

            statement.executeUpdate();
        }
    }

    public void deleteCustomer(String id) throws SQLException {
        String query = "DELETE FROM customer WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, id);
            statement.executeUpdate();
        }
    }

    private Customer extractCustomerFromResultSet(ResultSet resultSet) throws SQLException {
        String id = resultSet.getString("id");
        String userName = resultSet.getString("userName");
        String phone = resultSet.getString("phone");
        String userAddress = resultSet.getString("userAddress");
        Date createDate = resultSet.getDate("createDate");
        Date updateDate = resultSet.getDate("updateDate");
        int cusStatus = resultSet.getInt("cusStatus");

        return new Customer(id, userName, phone, userAddress, createDate, updateDate, cusStatus);
    }

    public boolean doesPhoneExist(String phoneToCheck) throws SQLException {
        String query = "SELECT COUNT(*) AS count FROM customer WHERE phone = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, phoneToCheck);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt("count");
                return count > 0; 
            }
        }
        return false; 
    }
    
    public String getNameByPhone(String phoneToLookup) throws SQLException {
        String query = "SELECT userName FROM customer WHERE phone = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, phoneToLookup);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getString("userName");
            }
        }
        return null; 
    }
    
    public String findCustomerIdByPhone(String phoneNumber) {
        String customerId = null;

        try {
            String sql = "SELECT ID FROM customer WHERE phone = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, phoneNumber);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        customerId = resultSet.getString("ID");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customerId;
    }

}
