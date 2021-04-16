package kr.ac.jejunu.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
public class DaoFactory {

    @Value("${db.driver}")
    private String className;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.url}")
    private String url;


    @Bean
    public JdbcTemplate jdbcTemplate() throws ClassNotFoundException {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public DataSource dataSource() throws ClassNotFoundException {
        SimpleDriverDataSource dataSource
                = new SimpleDriverDataSource();
//        className = "com.mysql.cj.jdbc.Driver";
//        url = "jdbc:mysql://localhost/jeju?characterEncoding=utf-8&serverTimezone=UTC";
//        username = "root";
//        password = "1717";
        dataSource.setDriverClass((Class<? extends Driver>) Class.forName(className));
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        return dataSource;
    }
}
