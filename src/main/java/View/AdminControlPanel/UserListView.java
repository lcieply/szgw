package View.AdminControlPanel;

import Model.AdminControlPanelModel.CreateUserTableModel;
import Model.domain.User;
import org.hibernate.metamodel.source.annotations.JPADotNames;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UserListView{
    private JFrame frame;
    private JScrollPane scrollPane;
    private JTable table;
    private JPanel panel;
    private JPanel southPanel;
    private CreateUserTableModel model;
    private List<JButton> editButtonsList;
    private List<JButton> deleteButtonsList;
    private JLabel searchLabel;
    private JTextField searchField;
    private JButton editButton;
    private JButton deleteButton;
    private JButton newUserButton;

    public UserListView(){
        searchLabel = new JLabel("Specify a word to match: ");
        searchField = new JTextField(20);
        editButton = new JButton("Edit");
        deleteButton = new JButton("Delete");
        newUserButton = new JButton("New user");
        frame = new JFrame();
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());
        model = new CreateUserTableModel();
        table = new JTable(model);
        table.setRowSelectionAllowed(true);
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        table.setAutoCreateRowSorter(true);
        scrollPane = new JScrollPane(table);
        southPanel.add(searchLabel);
        southPanel.add(searchField);
        southPanel.add(editButton);
        southPanel.add(deleteButton);
        southPanel.add(newUserButton);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(southPanel, BorderLayout.SOUTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public JPanel getSouthPanel() {
        return southPanel;
    }

    public void setSouthPanel(JPanel southPanel) {
        this.southPanel = southPanel;
    }

    public CreateUserTableModel getModel() {
        return model;
    }

    public void setModel(CreateUserTableModel model) {
        this.model = model;
    }

    public List<JButton> getEditButtonsList() {
        return editButtonsList;
    }

    public void setEditButtonsList(List<JButton> editButtonsList) {
        this.editButtonsList = editButtonsList;
    }

    public List<JButton> getDeleteButtonsList() {
        return deleteButtonsList;
    }

    public void setDeleteButtonsList(List<JButton> deleteButtonsList) {
        this.deleteButtonsList = deleteButtonsList;
    }

    public JButton getEditButton() {
        return editButton;
    }

    public void setEditButton(JButton editButton) {
        this.editButton = editButton;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(JButton deleteButton) {
        this.deleteButton = deleteButton;
    }

    public JLabel getSearchLabel() {
        return searchLabel;
    }

    public void setSearchLabel(JLabel searchLabel) {
        this.searchLabel = searchLabel;
    }

    public JTextField getSearchField() {
        return searchField;
    }

    public void setSearchField(JTextField searchField) {
        this.searchField = searchField;
    }

    public JButton getNewUserButton() {
        return newUserButton;
    }

    public void setNewUserButton(JButton newUserButton) {
        this.newUserButton = newUserButton;
    }
}