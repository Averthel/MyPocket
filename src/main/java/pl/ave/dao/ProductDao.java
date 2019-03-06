package pl.ave.dao;

import pl.ave.model.Product;
import pl.ave.util.ConnectionProvider;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDao {

    private final static String CREATE = "INSERT INTO product(name, description, category, count, price) VALUES(?, ?, ?,?, ?);";
    private final static String READ = "SELECT description, category, price, count, name FROM product WHERE name=?;";
    private final static String UPDATE = "UPDATE product SET description=?, category=?, count =?, price=?, name=? WHERE name=?;";
    private final static String DELETE = "DELETE FROM product WHERE name=?;";



    public void create(Product product) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(CREATE)) {
            prepStmt.setString(1, product.getName());
            prepStmt.setString(2, product.getDescription());
            prepStmt.setString(3, product.getCategory());
            prepStmt.setDouble(5, product.getPrice());
            prepStmt.setInt(4, product.getCount());
            prepStmt.executeUpdate();
        }
    }


    public Product read(String name) throws SQLException {
        Product resultProduct = null;
        try(Connection conn = ConnectionProvider.getConnection();
        PreparedStatement prepStmt = conn.prepareStatement(READ);) {
            prepStmt.setString(1, name);
            ResultSet resultSet = prepStmt.executeQuery();
            if (resultSet.next()) {
                resultProduct = new Product();
                resultProduct.setDescription(resultSet.getString("description"));
                resultProduct.setCategory(resultSet.getString("category"));
                resultProduct.setPrice(resultSet.getDouble("price"));
                resultProduct.setCount(resultSet.getInt("count"));
                resultProduct.setName(resultSet.getString("name"));
            }
        }
        return resultProduct;
    }

    public void update(Product product) throws SQLException {
        try(Connection conn = ConnectionProvider.getConnection();
            PreparedStatement prepStmt = conn.prepareStatement(UPDATE);){
            prepStmt.setString(1, product.getDescription());
            prepStmt.setString(2, product.getCategory());
            prepStmt.setInt(3, product.getCount());
            prepStmt.setDouble(4, product.getPrice());
            prepStmt.setString(5,product.getName());
            prepStmt.setString(6,product.getName());
            prepStmt.executeUpdate();
        }
    }


    public void delete(Product product) throws SQLException {
        try(Connection conn = ConnectionProvider.getConnection();
            PreparedStatement prepStmt = conn.prepareStatement(DELETE);){
            prepStmt.setString(1, product.getName());
            prepStmt.executeUpdate();
        }
    }
}