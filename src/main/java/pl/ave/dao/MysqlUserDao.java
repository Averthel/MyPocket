package pl.ave.dao;

import pl.ave.model.User;
import pl.ave.util.ConnectionProvider;
import pl.ave.util.DbOperationException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlUserDao implements UserDao {

    private final static String CREATE = "INSERT INTO user(username, email, password) VALUES(?,?,?)";
    private final static String READ = "SELECT username, email, is_active FROM user WHERE username =?;";
    private final static String DELETE = "DELETE user WHERE username=?;";
    private final static String UPDATE = "UPDATE user SET username=?, email=?, password=? WHERE username=?;";



    @Override
    public void create(User user) {
        try(Connection conn = ConnectionProvider.getConnection();
            PreparedStatement prepStmt = conn.prepareStatement(CREATE);){
            prepStmt.setString(1, user.getUsername());
            prepStmt.setString(2, user.getEmail());
            prepStmt.setString(3, user.getPassword());
            prepStmt.executeUpdate();
        }catch (SQLException e){
            throw new DbOperationException(e);
        }

    }

    @Override
    public User read(String username) {
        User resultUser = null;
        try(Connection conn = ConnectionProvider.getConnection();
            PreparedStatement prepStmt = conn.prepareStatement(READ);){
            prepStmt.setString(1, username);
            ResultSet resultSet = prepStmt.executeQuery();
            if(resultSet.next()){
                resultUser = new User();
                resultUser.setUsername(resultSet.getString("username"));
                resultUser.setEmail(resultSet.getString("email"));
                resultUser.setActive(resultSet.getBoolean("is_active"));
            }
        }catch(SQLException e){
            throw new DbOperationException(e);
        }
        return resultUser;
    }

    @Override
    public void delete(User user) {
        try(Connection conn = ConnectionProvider.getConnection();
            PreparedStatement prepStmt = conn.prepareStatement(DELETE);) {
            prepStmt.setString(1, user.getUsername());
            prepStmt.executeUpdate();
        }catch(SQLException e){
            throw new DbOperationException(e);
        }
    }

    @Override
    public void update(User user) {
        try(Connection conn = ConnectionProvider.getConnection();
            PreparedStatement prepStmt = conn.prepareStatement(UPDATE);) {
            prepStmt.setString(1, user.getUsername());
            prepStmt.setString(2, user.getEmail());
            prepStmt.setString(3, user.getPassword());
            prepStmt.setString(4, user.getUsername());
            prepStmt.executeUpdate();
        }catch(SQLException e){
            throw new DbOperationException(e);
        }
    }
}
