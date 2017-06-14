package org.rapidpm.vaadin.helloworld.server;

import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;

/**
 *
 */
public class MyUI extends UI {

  public static final String BUTTON_ID = "buttonID";
  public static final String INPUT_ID = "inputID";
  public static final String OUTPUT_ID = "outputID";

  @Override
  protected void init(VaadinRequest request) {
    final HorizontalLayout layout = new HorizontalLayout();

    final TextField input = new TextField();
    input.setId(INPUT_ID);

    final Button button = new Button("click me");
    button.setId(BUTTON_ID);

    final TextField output = new TextField();
    output.setReadOnly(true);
    output.setId(OUTPUT_ID);

    layout.addComponents(input,button,output);

    button.addClickListener(
        event -> output.setValue(input.getValue()));

    setContent(layout);
  }
}
