package pl.ave.dao;

public class MysqlDaoFactory extends DaoFactory {

    @Override
    public ProductDao getProductDao() {
        return new MysqlProductDao();
    }

    @Override
    public UserDao getUserDao() {
        return new MysqlUserDao();
    }
}
