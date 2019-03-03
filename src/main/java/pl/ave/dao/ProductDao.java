package pl.ave.dao;

import pl.ave.model.Product;
import pl.ave.util.ConnectionProvider;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDao {

    private final static String CREATE = "INSERT INTO product(name, description, category, count, price) VALUES(?, ?, ?,?, ?);";
    private final static String READ = "SELECT name, description, category, price FROM prodcut WHERE name=?;";
    private final static String UPDATE = "UPDATE prodcut SET description=?, category=?, count=?, price=? WHERE name=?;";
    private final static String DELETE = "DELETE FROM book WHERE name=?;";



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


    public Product read(String name) {
        return null;
    }


    public void update(Product product) {

    }


    public void delete(Product prodcut) {

    }
}