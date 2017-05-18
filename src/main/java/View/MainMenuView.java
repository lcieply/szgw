package View;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Agnieszka on 2017-05-05.
 */
public class MainMenuView {

    JFrame frame;
    JButton button1,button2,button3,button4;
    String manage="Zarzadzaj uzytkownikami";
    String visit="Wizyta";
    String drug="Leki";
    String doctor="Lekarze";

    public MainMenuView()
    {
        frame = new JFrame();
        frame.setSize(500,500);

        button1=new JButton(manage);
        button2=new JButton(visit);
        button3=new JButton(drug);
        button4=new JButton(doctor);
        frame.setLocation(50,50);
        frame.setLayout(new GridLayout(4,1));


        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        //button4.addActionListener(this);

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getButton1() {
        return button1;
    }

    public void setButton1(JButton button1) {
        this.button1 = button1;
    }

    public JButton getButton2() {
        return button2;
    }

    public void setButton2(JButton button2) {
        this.button2 = button2;
    }

    public JButton getButton3() {
        return button3;
    }

    public void setButton3(JButton button3) {
        this.button3 = button3;
    }

    public JButton getButton4() {
        return button4;
    }

    public void setButton4(JButton button4) {
        this.button4 = button4;
    }
}
