package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Agnieszka on 2017-05-18.
 */
public class LekarzView {
    private JFrame frame;
    private JPanel panel;
    private JButton button1,button2,button3, button4;
    String edit="Edytuj lekarza";
    String add="Dodaj nowego lekarza";
    String delete="Usuń lekarza";
    String show="Wyświetl dostępnych lekarzy";

    public LekarzView() {
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(new Dimension(250, 640));

        button1=new JButton(edit);
        button2=new JButton(add);
        button3=new JButton(delete);
        button4=new JButton(show);

        frame.setLocation(50,50);
        frame.setLayout(new GridLayout(4,1));

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);


    }
}
