package pl.ave.dao;



public abstract class DaoFactory {
    public static final int MYSQL_DAO = 1;

    public abstract ProductDao getProductDao();

    public abstract UserDao getUserDao();

    private static DaoFactory instance;

    public static DaoFactory getDaoFactory(int factoryType) {
        if (instance == null) {
            if (factoryType == MYSQL_DAO) {
                instance = new MysqlDaoFactory();
            }

        }
        return instance;
    }

}
