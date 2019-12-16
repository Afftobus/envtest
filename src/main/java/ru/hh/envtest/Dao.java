package ru.hh.envtest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Dao {

  private final DataSource dataSource;

  public Dao(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public void test() {
    try(
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from test");
    ) {
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

}
