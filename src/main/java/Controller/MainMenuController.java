package Controller;

import Controller.AdminControlPanelController.UserListController;
import Model.AdminControlPanelModel.UserListModel;
import View.AdminControlPanel.UserListView;
import View.MainMenuView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Agnieszka on 2017-05-05.
 */
public class MainMenuController {

    private MainMenuView view;
    private ActionListener action,action2;

    public MainMenuController(MainMenuView view)
    {
        this.view=view;
        control();
    }

    public void control(){

        action=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                UserListView view = new UserListView();
                UserListModel model = new UserListModel();
                UserListController controller = new UserListController(view, model);

            }
        };
        view.getButton1().addActionListener(action);

        action2=new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //LekarzView view= new LekarzView()
            }
        };
    }
}


