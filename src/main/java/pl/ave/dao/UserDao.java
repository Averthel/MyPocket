package pl.ave.dao;

import pl.ave.model.User;

public interface UserDao {

    public void create(User user);

    public User read(String username);

    public void delete(User user);

    public void update(User user);
}
