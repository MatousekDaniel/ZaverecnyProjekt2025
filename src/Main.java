import javax.swing.*;

/**
 * Project name: Virtual Piano
 * Made by: Daniel Matousek
 */
public class Main {

    /**
     * main starts the whole program.
     * frame sets the basics for the window.
     *
     * @param args
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame("Virtual Piano");
        ControlPanelGUI gui = new ControlPanelGUI();
        frame.setContentPane(gui.getMainPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(826, 228);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}