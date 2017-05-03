package Model.AdminControlPanelModel;

import Model.domain.User;
import org.w3c.dom.ranges.RangeException;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class CreateUserTableModel extends AbstractTableModel {
    List<User> data;
    String[] header = new String[]{"User ID", "Username", "Account type"};
    public CreateUserTableModel(List list){
        this.data = list;
    }
    public void updateData(){
        this.data = new ArrayList<User>();
        for(User user: User.getAllUsers()){
            this.data.add(user);
        }
    }
    public CreateUserTableModel(){
        this.data = new ArrayList<User>();
        for(User user: User.getAllUsers()){
            this.data.add(user);
        }
    }
    public int getRowCount() {
        return this.data.size();
    }

    public int getColumnCount() {
        return header.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        User user = null;
        user = data.get(rowIndex);
        switch(columnIndex){
            case 0:
                return user.getId();
            case 1:
                return user.getLogin();
            case 2:
                return user.getAccountTypeName();
            default:
                return "";
        }
    }

    public void removeRow(int rowIndex){
        this.data.remove(rowIndex);
        this.fireTableDataChanged();
    }
    public void removeRowByUserName(String name){
        User userToRemove = null;
        for(User user: this.data){
            if(user.getLogin().equals(name)){
                userToRemove = user;
            }
        }
        if(userToRemove!=null){
            this.data.remove(userToRemove);
        }
    }
    public String getColumnName(int columnIndex) {
        return header[columnIndex];
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

}
