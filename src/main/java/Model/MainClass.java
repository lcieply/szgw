package Model;

import Controller.AdminControlPanelController.UserListController;
//import Controller.DrugController;
import Controller.LoginViewController;
import Model.AdminControlPanelModel.UserListModel;
//import Model.domain.Drug;
import Model.domain.User;
import View.AdminControlPanel.UserListView;
//import View.DrugView;
import View.LoginView;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.*;
import javax.swing.*;
import java.util.List;
import java.util.logging.Level;

// <property name="hibernate.hbm2ddl.auto" value="create" />

public class MainClass {
    public static void main(String[] args){
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //User.createUser("test","test",1);
        User.createUser("admin","admin",1);
        LoginView view = new LoginView();
        LoginViewController controller = new LoginViewController(view);
        controller.control();

        /*DrugView view = new DrugView();
        Drug model = new Drug();
        DrugController controller = new DrugController(view, model);
        view.setVisible(true);*/
     /*   User.createUser("admin", "admin", 0);
        User.createUser("test", "test", 2);
        User.createUser("user", "user", 3);
        UserListView view = new UserListView();
        UserListModel model = new UserListModel();
        UserListController controller = new UserListController(view, model);*/

    }
}
