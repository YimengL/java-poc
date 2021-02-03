package v1ch02.ImageViewer;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.EventQueue;
import java.io.File;

/**
 * A program for viewing images.
 */
public class ImageViewer {
  public static void main(String[] args) {
    EventQueue.invokeLater(() -> {
      JFrame frame = new ImageViewerFrame();
      frame.setTitle("ImageViewer");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
    });
  }
}

/**
 * A frame with a label to show an image.
 *
 */
class ImageViewerFrame extends JFrame {
  private JLabel label;
  private JFileChooser chooser;
  private static final int DEFAULT_WIDTH = 300;
  private static final int DEFAULT_HEIGHT = 400;

  public ImageViewerFrame() {
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

    // use a label to display the images
    chooser = new JFileChooser();
    chooser.setCurrentDirectory(new File("."));

    // set menu bar
    JMenuBar menuBar = new JMenuBar();
    setJMenuBar(menuBar);

    JMenu menu = new JMenu("File");
    menuBar.add(menu);

    JMenuItem openItem = new JMenuItem("Open");
    menu.add(openItem);

    openItem.addActionListener(event -> {
      // show file chooser dialog
      int result = chooser.showOpenDialog(null);

      // if file selected, set it  as icon of the label
      if (result == JFileChooser.APPROVE_OPTION) {
        String name = chooser.getSelectedFile().getPath();
        label.setIcon(new ImageIcon(name));
      }
    });

    JMenuItem exitItem = new JMenuItem("Exit");
    menu.add(exitItem);

    exitItem.addActionListener(event -> System.exit(0));
  }
}
