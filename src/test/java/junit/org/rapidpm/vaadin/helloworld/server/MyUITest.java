package junit.org.rapidpm.vaadin.helloworld.server;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

/**
 *
 */
public class MyUITest extends BaseSeleniumTest {
  @Test
  public void test001() throws Exception {

    if (! driver.isPresent()) Assert.fail("WebDriver not available");

    driver.ifPresent(d -> {
      d.get("http://127.0.0.1:8080/");

//      Assert.assertNotNull(button(d));
//      Assert.assertEquals("click me",
//                          button(d).getText());

      Assert.assertEquals("", output(d).getText());

      input(d).sendKeys("Hello World");

      final WebElement button = button(d);

      Assert.assertNotNull(button);
      String text = button.getText();
      Assert.assertEquals("click me", text);

      button.sendKeys(Keys.ENTER);

      String outputText = output(d).getAttribute("value");
      Assert.assertEquals("Hello World", outputText);
    });
  }
}
