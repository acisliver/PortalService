package kr.ac.jejunu.userdao2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public User findById(Integer id) {
        String sql = "select * from userinfo where id = ?";
        Object[] params = new Object[]{id};
        return jdbcTemplate.query(sql, rs -> {
            User user = null;
            if(rs.next()){
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
            }
            return user;
        }, id);
    }


    public void insert(User user) {
        String sql = "insert into userinfo (name, password) values ( ?, ? )";
        Object[] params = new Object[]{user.getName(), user.getPassword()};
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement preparedStatement = con.prepareStatement(
                    sql
                    , Statement.RETURN_GENERATED_KEYS
            );
            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            return preparedStatement;
        }, keyHolder);
        user.setId(keyHolder.getKey().intValue());
    }


    public void update(User user) {
        String sql = "update userinfo set name = ?, password = ? where id = ?";
        Object[] params = new Object[]{user.getName(), user.getPassword(), user.getId()};
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement =connection.prepareStatement(
                    sql
                    , Statement.RETURN_GENERATED_KEYS
            );
            for(int i = 0; i < params.length; i++){
                preparedStatement.setObject(i+1, params[i]);
            }
            return preparedStatement;
        });
    }

    public void delete(Integer id) {
        String sql = "delete from userinfo where id = ?";
        Object[] params = new Object[]{id};
        jdbcTemplate.update(connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    sql
                    , Statement.RETURN_GENERATED_KEYS
            );
            for(int i = 0; i < params.length; i++){
                preparedStatement.setObject(i+1, params[i]);
            }
            preparedStatement.executeUpdate();
            return preparedStatement;
        });
    }
}
