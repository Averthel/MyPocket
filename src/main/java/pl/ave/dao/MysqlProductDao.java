package pl.ave.dao;

import pl.ave.model.Product;
import pl.ave.util.ConnectionProvider;
import pl.ave.util.DbOperationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlProductDao implements ProductDao {

    private final static String CREATE = "INSERT INTO product(name, description, category, count, price) VALUES(?, ?, ?,?, ?);";
    private final static String READ = "SELECT description, category, price, count, name FROM product WHERE name=?;";
    private final static String UPDATE = "UPDATE product SET description=?, category=?, count =?, price=?, name=? WHERE name=?;";
    private final static String DELETE = "DELETE FROM product WHERE name=?;";



    public void create(Product product) {
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(CREATE)) {
            prepStmt.setString(1, product.getName());
            prepStmt.setString(2, product.getDescription());
            prepStmt.setString(3, product.getCategory());
            prepStmt.setDouble(5, product.getPrice());
            prepStmt.setInt(4, product.getCount());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DbOperationException(e);
        }
    }


    public Product read(String name) {
        Product resultProduct = null;
        try (Connection conn = ConnectionProvider.getConnection();
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
        } catch (SQLException e) {
            throw new DbOperationException(e);
        }
        return resultProduct;
    }

    public void update(Product product) {
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(UPDATE);) {
            prepStmt.setString(1, product.getDescription());
            prepStmt.setString(2, product.getCategory());
            prepStmt.setInt(3, product.getCount());
            prepStmt.setDouble(4, product.getPrice());
            prepStmt.setString(5, product.getName());
            prepStmt.setString(6, product.getName());
            prepStmt.executeUpdate();
        } catch (SQLException e) {
            throw new DbOperationException(e);
        }
    }


    public void delete(Product product){
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement prepStmt = conn.prepareStatement(DELETE);) {
            prepStmt.setString(1, product.getName());
            prepStmt.executeUpdate();
        }catch (SQLException e){
            throw new DbOperationException(e);
        }
    }
}

