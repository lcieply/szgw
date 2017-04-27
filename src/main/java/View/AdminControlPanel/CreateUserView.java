package View.AdminControlPanel;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Łukasz on 27.04.2017.
 */
public class CreateUserView {
    private JFrame frame;
    private JPanel panel;
    private JTextField loginField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton createButton;
    private JLabel loginLabel, passwordLabel, confirmPasswordLabel, accountTypeLabel;
    private JComboBox userTypeCombo;
    private GridBagConstraints gbc;
    private JPanel errorPanel;
    //constructor
    public CreateUserView(){
        frame = new JFrame();
        panel = new JPanel();
        loginLabel = new JLabel("Login: ");
        passwordLabel = new JLabel("Password: ");
        confirmPasswordLabel = new JLabel("Confirm password: ");
        userTypeCombo = new JComboBox();
        userTypeCombo.addItem("Client");
        userTypeCombo.addItem("Admin");
        userTypeCombo.addItem("Worker");
        userTypeCombo.addItem("Manager");
        accountTypeLabel = new JLabel("Account type: ");
        loginField = new JTextField(20);
        passwordField = new JPasswordField(20);
        confirmPasswordField = new JPasswordField(20);
        createButton = new JButton("Create");
        panel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5), BorderFactory.createLoweredBevelBorder()));
        panel.setSize(400, 200);
        panel.setMinimumSize(new Dimension(400, 200));
        frame.setMinimumSize(new Dimension(400, 200));
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
        setGridBagConstraints(0, 2);
        panel.add(confirmPasswordLabel, gbc);
        fillGridBag(GridBagConstraints.HORIZONTAL);
        setGridBagConstraints(2, 2);
        panel.add(confirmPasswordField, gbc);
        fillGridBag(GridBagConstraints.HORIZONTAL);
        setGridBagConstraints(0, 3);
        panel.add(accountTypeLabel, gbc);
        fillGridBag(GridBagConstraints.HORIZONTAL);
        setGridBagConstraints(2, 3);
        panel.add(userTypeCombo, gbc);
        fillGridBag(GridBagConstraints.HORIZONTAL);
        setSizeGrid(3, 1);
        setGridBagConstraints(0, 4);
        panel.add(createButton, gbc);

        JPanel jPanelE=new JPanel();
        JPanel jPanelW=new JPanel();
        JPanel jPanelN=new JPanel();
        errorPanel = new JPanel();
        frame.add(jPanelE,BorderLayout.EAST);
        frame.add(jPanelW,BorderLayout.WEST);
        frame.add(jPanelN,BorderLayout.NORTH);
        frame.add(errorPanel,BorderLayout.SOUTH);
        frame.add(panel,BorderLayout.CENTER);

        frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Create new user");
        frame.pack();
        frame.setVisible(true);
    }

    //GridBagConstraint methods
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
    public JFrame getFrame() {
        return frame;
    }
    //view methods
    public void clearAll(){
        loginField.setText("");
        passwordField.setText("");
        confirmPasswordField.setText("");
    }

    public void printErrors(java.util.List <String> errorList){
        int position = 0;
        for(String error: errorList){
            JLabel errorLabel = new JLabel(error);
            errorLabel.setForeground(Color.RED);
            fillGridBag(GridBagConstraints.HORIZONTAL);
            setSizeGrid(3, 2);
            setGridBagConstraints(0, position++);
            errorPanel.add(errorLabel, gbc);
            frame.pack();
            errorPanel.updateUI();
        }
    }
    //getters and setters
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

    public JPasswordField getConfirmPasswordField() {
        return confirmPasswordField;
    }

    public void setConfirmPasswordField(JPasswordField confirmPasswordField) {
        this.confirmPasswordField = confirmPasswordField;
    }

    public JButton getCreateButton() {
        return createButton;
    }

    public void setLogButton(JButton createButton) {
        this.createButton = createButton;
    }

    public JLabel getLoginLabel() {
        return loginLabel;
    }

    public void setLoginLabel(JLabel loginLabel) {
        this.loginLabel = loginLabel;
    }

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public JPanel getErrorPanel() {
        return errorPanel;
    }

    public void setPasswordLabel(JLabel passwordLabel) {
        this.passwordLabel = passwordLabel;
    }

    public JLabel getConfirmPasswordLabel() {
        return confirmPasswordLabel;
    }

    public void setConfirmPasswordLabel(JLabel confirmPasswordLabel) {
        this.confirmPasswordLabel = confirmPasswordLabel;
    }

    public JComboBox getUserTypeCombo() {
        return userTypeCombo;
    }

    public void setUserTypeCombo(JComboBox userTypeCombo) {
        this.userTypeCombo = userTypeCombo;
    }

    public GridBagConstraints getGbc() {
        return gbc;
    }

    public void setGbc(GridBagConstraints gbc) {
        this.gbc = gbc;
    }
    public void setErrorPanel(JPanel errorPanel) {
        this.errorPanel = errorPanel;
    }

    public JLabel getAccountTypeLabel() {
        return accountTypeLabel;
    }

    public void setAccountTypeLabel(JLabel accountTypeLabel) {
        this.accountTypeLabel = accountTypeLabel;
    }
}
