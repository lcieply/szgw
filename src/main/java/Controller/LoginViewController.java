package Controller;

import Model.domain.User;
import View.LoginView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginViewController {
    private LoginView loginView;
    private ActionListener actionListener;
    public LoginViewController(LoginView loginView){
        this.loginView = loginView;
    }
    public void control(){
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(User.checkLogin(loginView.getLoginField().getText(), String.valueOf(loginView.getPasswordField().getPassword()))){
                    loginView.getFrame().dispose();
                    User user = User.getUserByLogin(loginView.getLoginField().getText());

                    //Tutaj nowy controller do glownego okna - User potrzebny zeby go przeslac do modelu kolejnego z ktorego glowne okno bedzie korzystac (uprawnienia)
                    JFrame frame = new JFrame();
                    frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                    //===================
                }else{
                    JOptionPane.showMessageDialog(loginView.getFrame(),
                            "Wrong username or password!",
                            "ERROR",
                            JOptionPane.ERROR_MESSAGE);
                    loginView.clearPassword();
                }
            }
        };
        loginView.getLogButton().addActionListener(actionListener);
    }
}
