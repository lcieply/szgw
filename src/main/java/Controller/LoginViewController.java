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
                    System.out.print("Success!");
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
