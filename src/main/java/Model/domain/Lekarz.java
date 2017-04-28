package Model.domain;

import org.hibernate.PropertyValueException;

import javax.persistence.*;
import java.util.List;

@Entity
public class Lekarz {
    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "specialization")
    private String spec;
    @Column(name = "affable")
    private String affable;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSpecialization() {
        return spec;
    }

    public void setSpecialization(String name) {
        this.spec = spec;
    }

    public String getAffable() {
        return affable;
    }

    public void setAffable(String affable) {
        this.affable = affable;
    }

    public Lekarz() {

    }

    public Lekarz(String name, String surname, String spec, String affable) {
        this.name = name;
        this.surname = surname;
        this.spec = spec;
        this.affable = affable;

    }
    public static boolean createLekarz(String name, String surname, String spec,String affable){
    Lekarz lekarz = new Lekarz(name, surname,spec,affable);
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    boolean result = true;

    try {
        entityManager.persist(lekarz);
        entityManager.getTransaction().commit();
    }
    catch (PersistenceException e) {
        System.out.print("Taki lekarz już istnieje.");
        entityManager.getTransaction().rollback();
        result = false;
    }
    catch (PropertyValueException e) {
        System.out.print("Niepełne dane");
        entityManager.getTransaction().rollback();
        result = false;
    }
    finally {
        entityManager.close();
        entityManagerFactory.close();
    }
    return result;
}

    public static List<Lekarz> getAllLekarze() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            return entityManager.createQuery("SELECT l FROM Lekarz l", Lekarz.class).getResultList();
        }
        catch (NoResultException e) {
            System.out.print("Brak wyników.");
            return null;
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static List<Drug> getAllLekarzSurnames() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            return entityManager.createQuery("SELECT l FROM Lekarz l", Drug.class).getResultList();
        }
        catch (NoResultException e) {
            System.out.print("Brak wyników");
            return null;
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    public static Lekarz getLekarzById(long id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            return entityManager.createQuery("SELECT l FROM Lekarz l WHERE l.id =:SEARCHED", Lekarz.class).setParameter("SEARCHED", id).getSingleResult();
        }
        catch (NoResultException e) {
            System.out.print("Brak wyników.");
            return null;
        }
        finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
    public static Lekarz getLekarzBySurname(String surname) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            return entityManager.createQuery("SELECT l FROM Lekarz l WHERE l.surname =:SEARCHED", Lekarz.class).setParameter("SEARCHED", surname).getSingleResult();
        } catch (NoResultException e) {
            System.out.print("Brak wyników");
            return null;
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }
    }
        public static List<Lekarz> getLekarzeByAccess(String affable) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            try {
                return entityManager.createQuery("SELECT l FROM Lekarz l WHERE l.affable =:SEARCHED", Lekarz.class).setParameter("SEARCHED", affable).getResultList();
            } catch (NoResultException e) {
                System.out.print("Brak wyników.");
                return null;
            } finally {
                entityManager.close();
                entityManagerFactory.close();
            }
        }
        public static boolean removeLekarz(Lekarz lekarz){
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            boolean result = true;
            try{
                if(entityManager.contains(lekarz))
                    entityManager.remove(lekarz);
                else{
                    entityManager.remove(entityManager.merge(lekarz));
                }
                entityManager.getTransaction().commit();
            }
            catch (PersistenceException e){
                System.out.println("Nie ma takiego lekarza w bazie!");
                entityManager.getTransaction().rollback();
                result = false;
            }finally {
                entityManager.close();
                entityManagerFactory.close();
            }
            return result;
        }

    public static boolean updateName(Lekarz lekarz, String name) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            lekarz.setName(name);
            entityManager.merge(lekarz);
        }
        catch (NullPointerException e) {
            System.out.print("Próba zmiany zastosowania nieistnejącego lekarza.");
            return false;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    public static boolean updateSurname(Lekarz lekarz, String surname) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            lekarz.setSurname(surname);
            entityManager.merge(lekarz);
        }
        catch (NullPointerException e) {
            System.out.print("Próba zmiany zastosowania nieistnejącego lekarza.");
            return false;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    public static boolean updateAccess(Lekarz lekarz, String affable) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            lekarz.setSurname(affable);
            entityManager.merge(lekarz);
        }
        catch (NullPointerException e) {
            System.out.print("Próba zmiany zastosowania nieistnejącego lekarza.");
            return false;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }

    public static boolean updateSpec(Lekarz lekarz, String spec) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mydb");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        try {
            lekarz.setSurname(spec);
            entityManager.merge(lekarz);
        }
        catch (NullPointerException e) {
            System.out.print("Próba zmiany zastosowania nieistnejącego lekarza.");
            return false;
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
        return true;
    }








}