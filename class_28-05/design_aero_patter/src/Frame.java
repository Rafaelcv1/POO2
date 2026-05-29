import java.awt.FlowLayout;
import javax.swing.*;

public class Frame extends JFrame {
  private final JList<String> designPatternList;
  private static final String[] designPatternNames = { "Factory Method", "Abstract Method", "Builder", "Prototype" };
  private final JTextArea descriptionText;
  private JButton showDescriptionJButton;

  public Frame() {
    super("Design Patterns");
    descriptionText = "";
    setLayout(new FlowLayout());

    designPatternList = new JList<String>(designPatternNames); // list of desing Patterns
    designPatternList.setVisibleRowCount(4); // show five rows

    designPatternList.setSelectionMode(
        ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    add(new JScrollPane()); // add list with scrollpane

    showDescriptionJButton = new JButton("Description");

    add(showDescriptionJButton);
  }
}

class FactoryMethod {
  private final String name = "Factory Method";
  private final String description = "this is the factory method description";
}
