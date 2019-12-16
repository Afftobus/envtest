package ru.hh.envtest;

import com.opentable.db.postgres.embedded.EmbeddedPostgres;
import org.junit.BeforeClass;
import org.junit.Test;
import org.postgresql.ds.PGSimpleDataSource;

import java.io.IOException;

public class UserDaoTest {

  private static Dao dao;
  private static PGSimpleDataSource ds;


  @Test
  public void getAllUsersShouldReturnTwoEnyties() {
    dao.test();
  }

  @BeforeClass
  public static void setUpDatasource() {
    try {
      EmbeddedPostgres.builder()
          .setPort(5433)
          .start();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    ds = new PGSimpleDataSource();
    ds.setUser("postgres");
    ds.setPassword("postgres");
    ds.setUrl("jdbc:postgresql://localhost:5433/postgres");
    dao = new Dao(ds);

    TestHelper.executeScript(ds, "create.sql");
  }


}
