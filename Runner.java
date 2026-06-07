import javax.swing.JFrame;

public class Runner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Pacman");
        Screen screen = new Screen();
        

        frame.add(screen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        screen.requestFocusInWindow();
        new Thread(screen::animate).start();
        
        
    }
}
