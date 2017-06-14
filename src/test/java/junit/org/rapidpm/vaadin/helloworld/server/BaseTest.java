package junit.org.rapidpm.vaadin.helloworld.server;

import org.junit.After;
import org.junit.Before;
import org.rapidpm.vaadin.helloworld.server.Main;

/**
 *
 */
public abstract class BaseTest {

  @Before
  public void setUp() throws Exception {
    Main.start();
  }

  @After
  public void tearDown() throws Exception {
    Main.shutdown();
  }


}
