// Przed uruchomieniem należy upewnić się, że tabela 'drug' jest pusta.

package Model.domain;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DrugTest {
    @org.junit.Test
    public void createDrug() throws Exception {
        Drug d = new Drug("createDrugTest", "test", "test", 100, false);
        assertTrue(Drug.createDrug(d));
        assertFalse(Drug.createDrug(d));
        Drug.removeDrug(Drug.getDrugByName(d.getName()));
    }

    @org.junit.Test
    public void getAllDrugs() throws Exception {
        Drug d1 = new Drug("getAllDrugsTest1", "test", "test", 100, false);
        Drug d2 = new Drug("getAllDrugsTest2", "test", "test", 100, false);
        List<Drug> list = Arrays.asList(d1, d2);
        for (Drug d : list)
            Drug.createDrug(d);
        assertEquals(list.size(), Drug.getAllDrugs().size());
        for (int i = 0; i < list.size(); i++)
            assertTrue(Drug.compareDrugs(list.get(i), Drug.getAllDrugs().get(i)));
        for (Drug d : list)
            Drug.removeDrug(Drug.getDrugByName(d.getName()));
    }

    @org.junit.Test
    public void getAllDrugsNames() throws Exception {
        Drug d1 = new Drug("getAllDrugsNamesTest1", "test", "test", 100, false);
        Drug d2 = new Drug("getAllDrugsNamesTest2", "test", "test", 100, false);
        List<Drug> listDrugs = Arrays.asList(d1, d2);
        List<String> listNames = Arrays.asList(d1.getName(), d2.getName());
        for (Drug d : listDrugs)
            Drug.createDrug(d);
        assertEquals(listNames, Drug.getAllDrugsNames());
        for (Drug d : listDrugs)
            Drug.removeDrug(Drug.getDrugByName(d.getName()));
    }

    @org.junit.Test
    public void getDrugById() throws Exception {
        Drug d = new Drug("getDrugByIdTest", "test", "test", 100, false);
        Drug.createDrug(d);
        d = Drug.getDrugByName(d.getName());
        assertTrue(Drug.compareDrugs(d, Drug.getDrugById(d.getId())));
        Drug.removeDrug(Drug.getDrugById(d.getId()));
    }

    @org.junit.Test
    public void getDrugByName() throws Exception {
        Drug d = new Drug("getDrugByNameTest", "test", "test", 100, false);
        Drug.createDrug(d);
        assertTrue(Drug.compareDrugs(d, Drug.getDrugByName(d.getName())));
        Drug.removeDrug(Drug.getDrugByName(d.getName()));
    }

    @org.junit.Test
    public void getDrugsByType() throws Exception {
        Drug d1 = new Drug("getDrugsByType1", "test1", "test", 100, false);
        Drug d2 = new Drug("getDrugsByType2", "test1", "test", 100, false);
        Drug d3 = new Drug("getDrugsByType3", "test2", "test", 100, false);
        List<Drug> list1 = Arrays.asList(d1, d2, d3);
        List<Drug> list2 = Arrays.asList(d1, d2);
        for (Drug d : list1)
            Drug.createDrug(d);
        assertEquals(list2.size(), Drug.getDrugsByType(d1.getType()).size());
        for (int i = 0; i < list2.size(); i++)
            assertTrue(Drug.compareDrugs(list2.get(i), Drug.getDrugsByType(d1.getType()).get(i)));
        for (Drug d : list1)
            Drug.removeDrug(Drug.getDrugByName(d.getName()));
    }

    @org.junit.Test
    public void updateType() throws Exception {
        Drug d = new Drug("updateTypeTest", "test", "test", 100, false);
        Drug.createDrug(d);
        Drug.updateType(Drug.getDrugByName(d.getName()), "type");
        assertEquals("type", Drug.getDrugByName(d.getName()).getType());
        Drug.removeDrug(Drug.getDrugByName(d.getName()));
    }

    @org.junit.Test
    public void updateApplication() throws Exception {
        Drug d = new Drug("updateApplicationTest", "test", "test", 100, false);
        Drug.createDrug(d);
        Drug.updateApplication(Drug.getDrugByName(d.getName()), "application");
        assertEquals("application", Drug.getDrugByName(d.getName()).getApplication());
        Drug.removeDrug(Drug.getDrugByName(d.getName()));
    }

    @org.junit.Test
    public void updateNumber() throws Exception {
        Drug d = new Drug("updateNumberTest", "test", "test", 100, false);
        Drug.createDrug(d);
        Drug.updateNumber(Drug.getDrugByName(d.getName()), 1000);
        assertEquals(1000, Drug.getDrugByName(d.getName()).getNumber());
        Drug.removeDrug(Drug.getDrugByName(d.getName()));
    }

    @org.junit.Test
    public void updateNeed() throws Exception {
        Drug d = new Drug("updateNeedTest", "test", "test", 100, false);
        Drug.createDrug(d);
        Drug.updateNeed(Drug.getDrugByName(d.getName()), true);
        assertEquals(true, Drug.getDrugByName(d.getName()).getNeed());
        Drug.removeDrug(Drug.getDrugByName(d.getName()));
    }

    @org.junit.Test
    public void removeDrug() throws Exception {
        Drug.createDrug("removeDrugTest", "test", "test", 100, false);
        assertTrue(Drug.removeDrug(Drug.getDrugByName("removeDrugTest")));
    }

    @org.junit.Test
    public void compareDrugs() throws Exception {
        Drug d1 = new Drug("test", "test", "test", 100, false);
        Drug d2 = new Drug("test2", "test", "test", 100, false);
        assertTrue(Drug.compareDrugs(d1, d1));
        assertFalse(Drug.compareDrugs(d1, d2));
    }
}