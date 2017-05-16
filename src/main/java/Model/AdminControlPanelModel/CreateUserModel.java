package Model.AdminControlPanelModel;

import View.AdminControlPanel.UserListView;

public class CreateUserModel {
    private UserListView userListView;
    public CreateUserModel(UserListView userListView){this.userListView = userListView;
    }

    public UserListView getUserListView() {
        return userListView;
    }

    public void setUserListView(UserListView userListView) {
        this.userListView = userListView;
    }
}
