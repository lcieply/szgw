package Controller.AdminControlPanelController;

import Model.AdminControlPanelModel.CreateUserModel;
import Model.domain.User;
import View.AdminControlPanel.CreateUserView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateUserController {
    private CreateUserView view;
    private CreateUserModel model;
    private ActionListener actionListener;
    public CreateUserController(CreateUserView view, CreateUserModel model){this.view=view;this.model=model;this.control();}
    public void control(){
        actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                view.getErrorPanel().removeAll();
                view.getErrorPanel().updateUI();
                List <String> errorList = new ArrayList<String>();
                if(!Arrays.equals(view.getPasswordField().getPassword(), view.getConfirmPasswordField().getPassword())){
                    errorList.add("The entered passwords do not match.");
                }else{
                    if(view.getPasswordField().getPassword().length < 3){
                        errorList.add("Password cannot be shorter than 3 characters.");
                    }
                }
                if(User.getUserByLogin(view.getLoginField().getText()) != null){
                    errorList.add("That username is already in use.");
                }
                if(view.getLoginField().getText().length() < 3){
                    errorList.add("Your username cannot be shorter than 3 characters.");
                }
                if(errorList.size() > 0){
                    view.printErrors(errorList);
                }else{
                    User.createUser(view.getLoginField().getText(), String.valueOf(view.getPasswordField().getPassword()), User.accountNameToInteger(view.getUserTypeCombo().getSelectedItem().toString()));
                    view.clearAll();
                    model.getUserListView().getModel().updateData();
                    model.getUserListView().search();
                    model.getUserListView().getTable().updateUI();
                }
            }
        };
        view.getCreateButton().addActionListener(actionListener);
    }
}
