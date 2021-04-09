package kr.ac.jejunu.demo;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private final DataSource dataSource;
    private final JdbcContext jdbcContext = new JdbcContext(this);

    public UserDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public User findById(Integer id) throws SQLException {
        StatementStrategy statementStrategy = new FindByIdStatementStrategy();
        return jdbcContext.jdbcContextForFindById(id, statementStrategy);
    }

    public void insert(User user) throws SQLException {
        StatementStrategy statementStrategy = new InsertStatementStrategy();
        jdbcContext.jdbcContextInsert(user, statementStrategy);
    }

    public void update(User user) throws SQLException {
        StatementStrategy statementStrategy = new UpdateStatementStrategy();
        jdbcContext.jdbcContextForUpdate(user, statementStrategy);
    }

    public void delete(Integer id) throws SQLException {
        StatementStrategy statementStrategy = new DeleteStatementStrategy();
        jdbcContext.jdbcContextForDelete(id, statementStrategy);
    }

}
