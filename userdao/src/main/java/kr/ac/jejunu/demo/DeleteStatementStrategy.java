package kr.ac.jejunu.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStatementStrategy implements StatementStrategy {
    private Integer id;
    public DeleteStatementStrategy(Integer id) {
        this.id = id;
    }

    @Override
    public PreparedStatement makeStatement(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "delete from userinfo where id = ?"
                , Statement.RETURN_GENERATED_KEYS
        );
        preparedStatement.setInt(1, id);

        preparedStatement.executeUpdate();
        return preparedStatement;
    }
}
