package Model.domain;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import java.util.List;

@Entity
public class User {
    @Id @GeneratedValue
    private Long id;
    @Column(name="login", nullable = false, unique = true)
    private String login;
    @Column(name="password")
    private String password;
    @Column(name="accountType")
    private Integer type;
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public static Integer accountNameToInteger(String name){
        if(name.equals("Admin")) return new Integer(0);
        else if(name.equals("Manager")) return new Integer(1);
        else if(name.equals("Worker")) return new Integer(2);
        return new Integer(3);
    }
    public static boolean updateType(User user, Integer type){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            user.setType(type);
            entityManager.merge(user);
        }
        catch(NullPointerException e){
            //System.out.println("User not found!");
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }
    public static boolean updatePassword(User user, String password){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            user.setPassword(password);
            entityManager.merge(user);
        }
        catch(NullPointerException e){
            //System.out.println("User not found!");
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }
    public static boolean removeUsers(List<User> users){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        boolean result = true;
        for(User user: users) {
            try {
                if(entityManager.contains(user))
                    entityManager.remove(user);
                else{
                    entityManager.remove(entityManager.merge(user));
                }
                entityManager.getTransaction().commit();
            } catch (PersistenceException e) {
                //System.out.println("User not found!");
                entityManager.getTransaction().rollback();
                result = false;
            } finally {
                entityManager.close();
                entityManagerFactory.close();
            }
        }
        return result;
    }
    public static boolean removeUser(User user){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        boolean result = true;
        try{
            if(entityManager.contains(user))
                entityManager.remove(user);
            else{
                entityManager.remove(entityManager.merge(user));
            }
            entityManager.getTransaction().commit();
        }
        catch (PersistenceException e){
            //System.out.println("User not found!");
            entityManager.getTransaction().rollback();
            result = false;
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return result;
    }
    public static List<User> getUsersByType(Integer type){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            TypedQuery<User> query = entityManager.createQuery("select u from User u where u.type =:searchType", User.class).setParameter("searchType", type);
            List<User> users = query.getResultList();
            return users;
        }catch (NoResultException e){
            //System.out.println("User not found!");
            return null;
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
    public static User getUserByLogin(String condition){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            TypedQuery<User> query = entityManager.createQuery("select u from User u where u.login =:searchLogin", User.class).setParameter("searchLogin", condition);
            User user = query.getSingleResult();
            return user;
        }catch (NoResultException e){
            //System.out.println("User not found!");
            return null;
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
    public User(){}
    public User(String login, String password, Integer type){
        this.login = login;
        this.password = password;
        this.type = type;
    }

    public static boolean createUser(String login, String password, Integer type) {
        User user = new User(login, password, type);
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        boolean result = true;
        try{
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        }
        catch (PersistenceException e){
            //System.out.println("Login already exist!");
            entityManager.getTransaction().rollback();
            result = false;
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
        return result;
    }
    public static boolean checkLogin(String login, String password){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        try {
            TypedQuery<User> query = entityManager.createQuery("select u from User u where u.login =:searchLogin AND u.password =:searchPassword", User.class).setParameter("searchLogin", login).setParameter("searchPassword", password);
            User user = query.getSingleResult();
            return true;
        }catch (NoResultException e){
            //System.out.println("Wrong username or password!");
            return false;
        }finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
