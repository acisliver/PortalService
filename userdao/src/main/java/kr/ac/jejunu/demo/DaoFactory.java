package kr.ac.jejunu.demo;

public class DaoFactory {
    public UserDao getUserDao() {
        return new UserDao(getConnectionMaker());
    }

    private ConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
