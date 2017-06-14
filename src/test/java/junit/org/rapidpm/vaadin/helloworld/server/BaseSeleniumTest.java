package junit.org.rapidpm.vaadin.helloworld.server;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.rapidpm.vaadin.helloworld.server.MyUI;

/**
 *
 */
public class BaseSeleniumTest extends BaseTest {

  protected Optional<WebDriver> driver;

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    // init webDriver here
    System.setProperty("webdriver.chrome.driver", "_data/chromedriver");

    driver = Optional.of(new ChromeDriver());
    //final WebDriverWait wait = new WebDriverWait(driver, 10);
  }


  @Override
  @After
  public void tearDown() throws Exception {
    // kill webdriver / Browser here
    driver.ifPresent(d -> {
      d.close();
      d.quit();
    });
    driver = Optional.empty();
    super.tearDown();
  }

  protected WebElement button(WebDriver driver) {
    return driver.findElement(By.id(MyUI.BUTTON_ID));
  }

  protected WebElement output(WebDriver driver) {
    return driver.findElement(By.id(MyUI.OUTPUT_ID));
  }

  protected WebElement input(WebDriver driver) {
    return driver.findElement(By.id(MyUI.INPUT_ID));
  }

}
