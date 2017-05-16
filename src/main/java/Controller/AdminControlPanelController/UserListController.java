package Controller.AdminControlPanelController;

import Model.AdminControlPanelModel.CreateUserModel;
import Model.AdminControlPanelModel.CreateUserTableModel;
import Model.AdminControlPanelModel.UserListModel;
import Model.domain.User;
import View.AdminControlPanel.CreateUserView;
import View.AdminControlPanel.UserListView;
import org.w3c.dom.ranges.RangeException;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by Łukasz on 02.05.2017.
 */
public class UserListController {
    private UserListModel model;
    private UserListView view;
    private ActionListener deleteActionListener;
    private ActionListener editActionListener;
    private MouseListener doubleClickTableListener;
    private KeyListener searchKeyListener;
    private ActionListener newUserActionListener;
    public UserListController(UserListView view, UserListModel model){this.model=model; this.view=view; this.control();}
    public void control(){
        deleteActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int[] rows = view.getTable().getSelectedRows();
                for(int i = 0 ; i < rows.length; i++) {
                    try {
                        if (rows[i] < 0) throw new RangeException(Short.valueOf("-1"), "Out of range!");
                        User.removeUser(User.getUserByLogin(String.valueOf(view.getTable().getValueAt(rows[i], 1))));
                    } catch (RangeException exception) {
                        System.out.println("ERROR");
                    }
                }
                view.getTable().clearSelection();
                view.getModel().updateData();
                view.search();
                view.getTable().updateUI();

            }

        };
        editActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Edit");
            }
        };

        doubleClickTableListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                Point point = e.getPoint();
                int row =view.getTable().rowAtPoint(point);
                if(e.getClickCount() == 2){
                    System.out.println(view.getTable().getValueAt(view.getTable().getSelectedRow(), 1));
                }
            }
        };
        searchKeyListener = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                view.search();
            }
        };

        newUserActionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreateUserModel createUserModel = new CreateUserModel(view);
                CreateUserView createUserView = new CreateUserView();
                CreateUserController createUserController = new CreateUserController(createUserView, createUserModel);
            }
        };

        view.getNewUserButton().addActionListener(newUserActionListener);
        view.getSearchField().addKeyListener(searchKeyListener);
        view.getTable().addMouseListener(doubleClickTableListener);
        view.getDeleteButton().addActionListener(deleteActionListener);
        view.getEditButton().addActionListener(editActionListener);

    }
}
