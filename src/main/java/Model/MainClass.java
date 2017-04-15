package Model;

import Model.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.logging.Level;
// <property name="hibernate.hbm2ddl.auto" value="create" />

public class MainClass {
    public static void main(String[] args){
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        //User.updateType(User.getUserByLogin("admin"), 0);

    }
}
