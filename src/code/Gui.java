package code;


//actions
//scanner
//data
//gui
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
//exceptions
import java.io.IOException;
import java.awt.AWTException;
import javax.swing.UnsupportedLookAndFeelException;

public class Gui {
public static void main(String[] args) {

  // interface
  try {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); // Set system L&F
  } catch (UnsupportedLookAndFeelException e) {
    e.printStackTrace();
  } catch (ClassNotFoundException e) {
    e.printStackTrace();
  } catch (InstantiationException e) {
    e.printStackTrace();
  } catch (IllegalAccessException e) {
    e.printStackTrace();
  }

  JFrame f = new JFrame("R0(t) for Covid-19");
  f.setSize(300, 300);
  f.setLocation(50, 300);

  final JButton button1 = new JButton("Download data");
  button1.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        Op.GetAllData();
      } catch (IOException err) {
        err.printStackTrace();
      }
      // notify when download is completed
      JOptionPane.showMessageDialog(f, "Data downloaded");
    }
  });

  final JButton button2 = new JButton("Open RStudio");
  button2.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        Op.OpenRStudio();
      } catch (AWTException er) {
        er.printStackTrace();
      } catch (FileNotFoundException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
    }
  });

  final JButton button3 = new JButton("Source files");
  button3.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      try {
        Op.SourceFiles();
      } catch (IOException err) {
        err.printStackTrace();
      }
      // notify when download is completed
      JOptionPane.showMessageDialog(f, "Operation completed");
    }
  });

  final JButton button4 = new JButton("Open dashboard.pdf");
  button4.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      Op.OpenPDF();
    }
  });

  final JButton button5 = new JButton("Open dashboard panel");
  button5.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
      Op.ShowBox(f);
    }
  });

  // add buttons to layout
  f.setLayout(new GridLayout(5, 1)); // 5 rows 1 column
  f.add(button1);
  f.add(button2);
  f.add(button3);
  f.add(button4);
  f.add(button5);

  f.setVisible(true);
}
}
