package Controller;

import Model.domain.User;
import View.LoginView;
import View.MainMenuView;

import javax.swing.*;
import java.awt.*;
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

                    MainMenuView view=new MainMenuView();
                    MainMenuController menu=new MainMenuController(view);

                    //Tutaj nowy controller do glownego okna - User potrzebny zeby go przeslac do modelu kolejnego z ktorego glowne okno bedzie korzystac (uprawnienia)
                  /*  button1.setPreferredSize(new Dimension(40,40));
                    button2.setPreferredSize(new Dimension(40,40));
                    button3.setPreferredSize(new Dimension(40,40));
                    button4.setPreferredSize(new Dimension(40,40));
*/
  //===================
                }
                else{
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
