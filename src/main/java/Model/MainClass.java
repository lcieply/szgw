package Model;

import Controller.DrugController;
import Controller.LoginViewController;
import Model.domain.Drug;
import Model.domain.User;
import View.DrugView;
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
        /*User.createUser("test","test",1);
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        LoginView view = new LoginView();
        LoginViewController controller = new LoginViewController(view);
        controller.control();*/

        DrugView view = new DrugView();
        Drug model = new Drug();
        DrugController controller = new DrugController(view, model);
        view.setVisible(true);
    }
}
