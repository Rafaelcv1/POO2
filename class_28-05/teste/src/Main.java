import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicOptionPaneUI;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      Frame app = new Frame();
      app.setLayout(null);
      app.setLayout(new FlowLayout());
      app.pack();
      app.setLocationRelativeTo(null);
      app.setVisible(true);
      app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    });
  }
}

class Frame extends JFrame {
  private final JButton wokeButton;
  private final JPanel panel1;
  private final JLabel label1;

  {
    wokeButton = new JButton();
    panel1 = new JPanel();
    label1 = new JLabel();
  }

  Frame() {
    super("WOKE BUTTON!");

    wokeButton.setIcon(new ImageIcon("woke.jpg"));
    wokeButton.setBounds(5, 5, 15, 4);
    label1.setText("label1");

    wokeButton.addActionListener(e -> {
      Frame i = new Frame();
      i.setVisible(true);
    });
    ;

    panel1.add(wokeButton);
    panel1.add(label1);

    add(panel1);

    setSize(10, 15);
  }
}
