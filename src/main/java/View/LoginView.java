package View;

import javax.swing.*;
import java.awt.*;

public class LoginView{
    //components
    private JFrame frame;
    private JPanel panel;
    private JTextField loginField;
    private JPasswordField passwordField;
    private JButton logButton;
    private JLabel loginLabel, passwordLabel;
    private GridBagConstraints gbc;

    //constructor
    public LoginView(){
        frame = new JFrame();
        panel = new JPanel();
        loginLabel = new JLabel("Login: ");
        passwordLabel = new JLabel("Password: ");
        loginField = new JTextField(20);
        passwordField = new JPasswordField(20);
        logButton = new JButton("Login");
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createLoweredBevelBorder()));
        panel.setSize(340, 150);
        panel.setMinimumSize(new Dimension(340, 150));
        frame.setMinimumSize(new Dimension(340, 150));
        panel.setLayout(new GridBagLayout());
        gbc = new GridBagConstraints();
        fillGridBag(GridBagConstraints.HORIZONTAL);
        setGridBagConstraints(0, 0);
        panel.add(loginLabel, gbc);
        fillGridBag(GridBagConstraints.HORIZONTAL);
        setGridBagConstraints(2,0);
        panel.add(loginField, gbc);
        fillGridBag(GridBagConstraints.HORIZONTAL);
        setGridBagConstraints(0, 1);
        panel.add(passwordLabel, gbc);
        fillGridBag(GridBagConstraints.HORIZONTAL);
        setGridBagConstraints(2, 1);
        panel.add(passwordField, gbc);
        fillGridBag(GridBagConstraints.HORIZONTAL);
        setSizeGrid(3, 1);
        setGridBagConstraints(0, 2);
        panel.add(logButton, gbc);

        JPanel jPanelE=new JPanel();
        JPanel jPanelW=new JPanel();
        JPanel jPanelN=new JPanel();
        JPanel jPanelS=new JPanel();
        frame.add(jPanelE,BorderLayout.EAST);
        frame.add(jPanelW,BorderLayout.WEST);
        frame.add(jPanelN,BorderLayout.NORTH);
        frame.add(jPanelS,BorderLayout.SOUTH);
        frame.add(panel,BorderLayout.CENTER);

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Login Console");
        frame.pack();
        frame.setVisible(true);
    }

    //clear passwordField
    public void clearPassword(){
        passwordField.setText("");
    }

    //GridBagConstraint methods
    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }

    private void setGridBagConstraints(int x, int y){
        this.gbc.gridx = x;
        this.gbc.gridy = y;
    }
    private void fillGridBag(int direction){
        this.gbc.fill = direction;
    }
    private void setSizeGrid(int x, int y){
        setGridHeight(y);
        setGridWidth(x);
    }
    private void setGridWidth(int x){
        this.gbc.gridwidth = x;
    }
    private void setGridHeight(int y){
        this.gbc.gridheight = y;
    }

    //Getters and setters
    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JTextField getLoginField() {
        return loginField;
    }

    public void setLoginField(JTextField loginField) {
        this.loginField = loginField;
    }

    public JPasswordField getPasswordField() {
        return passwordField;
    }

    public void setPasswordField(JPasswordField passwordField) {
        this.passwordField = passwordField;
    }

    public JButton getLogButton() {
        return logButton;
    }

    public void setLogButton(JButton logButton) {
        this.logButton = logButton;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }
}
