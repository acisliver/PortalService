package kr.ac.jejunu.demo;

import javax.sql.DataSource;
import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext){
        this.jdbcContext = jdbcContext;
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
