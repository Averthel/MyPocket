package pl.ave.dao;


import pl.ave.model.Product;

public interface ProductDao {

    public void create(Product product);

    public Product read(String name);

    public  void delete(Product product);

    public  void update(Product product);
}