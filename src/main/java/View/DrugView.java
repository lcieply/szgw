package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrugView extends JFrame {
    private JPanel drugPanel = new JPanel();
    private JTextField drugName = new JTextField(20);
    private JTextField drugType = new JTextField(20);
    private JTextField application = new JTextField(20);
    private JTextField number = new JTextField(20);
    private JCheckBox need = new JCheckBox();
    private JTextField result = new JTextField(20);
    private JLabel nameLabel = new JLabel("Nazwa");
    private JLabel typeLabel = new JLabel("Typ");
    private JLabel applicationLabel = new JLabel("Przeznaczenie");
    private JLabel numberLabel = new JLabel("Liczba sztuk");
    private JLabel needLabel = new JLabel("Potrzeba zamówienia");
    private JLabel resultLabel = new JLabel("Rezultat");
    private JButton createButton = new JButton("Dodaj");
    private JButton searchButton = new JButton("Wyszukaj");
    private JButton updateButton = new JButton("Zapisz");
    private JButton deleteButton = new JButton("Usuń");

    public String getDrugName() throws EmptyFieldException {
        if (!drugName.getText().isEmpty())
            return drugName.getText();
        throw new EmptyFieldException();
    }

    public void setDrugName(String drugName) {
        this.drugName.setText(drugName);
    }

    public String getDrugType() throws EmptyFieldException {
        if (!drugType.getText().isEmpty())
            return drugType.getText();
        throw new EmptyFieldException();
    }

    public void setDrugType(String drugType) {
        this.drugType.setText(drugType);
    }

    public String getApplication() throws EmptyFieldException {
        if (!application.getText().isEmpty())
            return application.getText();
        throw new EmptyFieldException();
    }

    public void setApplication(String application) {
        this.application.setText(application);
    }

    public long getNumber() { return Long.parseLong(number.getText()); }

    public void setNumber(long number) {
        this.number.setText(Long.toString(number));
    }

    public boolean getNeed() {

        return need.isSelected();
    }

    public void setNeed(boolean need) {
        this.need.setSelected(need);
    }

    public String getResult() {

        return result.getText();
    }

    public void setResult(String result) {
        this.result.setText(result);
    }

    public void addCreateButtonListener(ActionListener actionListener) {
        createButton.addActionListener(actionListener);
    }

    public void addSearchButtonListener(ActionListener actionListener) {
        searchButton.addActionListener(actionListener);
    }

    public void addUpdateButtonListener(ActionListener actionListener) {
        updateButton.addActionListener(actionListener);
    }

    public void addDeleteButtonListener(ActionListener actionListener) {
        deleteButton.addActionListener(actionListener);
    }

    public void displayErrorMessage(String errorMessage) {
        JOptionPane.showMessageDialog(this, errorMessage);
    }

    public DrugView() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        createMenu();
    }

    private void createMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opcje");
        JMenuItem itemCreateDrug = new JMenuItem("Dodaj nowy lek");
        JMenuItem itemReadDrug = new JMenuItem("Wyświetl leki");
        JMenuItem itemUpdateDrug = new JMenuItem("Edytuj lek");
        JMenuItem itemDeleteDrug = new JMenuItem("Usuń lek");

        setJMenuBar(menuBar);
        menuBar.add(menu);
        menu.add(itemCreateDrug);
        menu.add(itemReadDrug);
        menu.add(itemUpdateDrug);
        menu.add(itemDeleteDrug);
        itemCreateDrug.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drugPanel.removeAll();
                clearAllFields();
                showCreate();
                drugPanel.updateUI();
            }
        });
        itemReadDrug.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drugPanel.removeAll();
                //
                drugPanel.updateUI();
            }
        });
        itemUpdateDrug.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drugPanel.removeAll();
                clearAllFields();
                showUpdate();
                drugPanel.updateUI();
            }
        });
        itemDeleteDrug.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                drugPanel.removeAll();
                //
                drugPanel.updateUI();
            }
        });
        menuBar.setVisible(true);
    }

    private void showCreate() {
        drugPanel.add(nameLabel);
        drugPanel.add(drugName);
        drugPanel.add(typeLabel);
        drugPanel.add(drugType);
        drugPanel.add(applicationLabel);
        drugPanel.add(application);
        drugPanel.add(numberLabel);
        drugPanel.add(number);
        drugPanel.add(needLabel);
        drugPanel.add(need);
        drugPanel.add(createButton);
        drugPanel.add(resultLabel);
        drugPanel.add(result);
        this.add(drugPanel);
    }

    private void showUpdate() {
        drugPanel.add(nameLabel);
        drugPanel.add(drugName);
        drugPanel.add(searchButton);
        drugPanel.add(typeLabel);
        drugPanel.add(drugType);
        drugPanel.add(applicationLabel);
        drugPanel.add(application);
        drugPanel.add(numberLabel);
        drugPanel.add(number);
        drugPanel.add(needLabel);
        drugPanel.add(need);
        drugPanel.add(updateButton);
        drugPanel.add(resultLabel);
        drugPanel.add(result);
        this.add(drugPanel);
    }

    private void clearAllFields() {
        drugName.setText("");
        drugType.setText("");
        application.setText("");
        number.setText("");
        need.setSelected(false);
        result.setText("");
    }

    public class EmptyFieldException extends Exception {
        public EmptyFieldException() {
            super("EmptyFieldException");
        }
    }
}
