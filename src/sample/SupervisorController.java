package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.text.Text;
import johnsUtil.model.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Controller for supervisor account.
 */
public class SupervisorController {
    private ScreenUtil screenUtil = new ScreenUtil();
    private DatabaseUtil databaseUtil = new DatabaseUtil();
    AccountsUtil accountsUtil = new AccountsUtil();

    @FXML
    Text text1;
    @FXML
    Text text2;
    @FXML
    Text text3;
    @FXML
    TextField field1;
    @FXML
    TextField field2;
    @FXML
    TextField field3;
    @FXML
    Button search;
    @FXML
    TreeView<johnsUtil.Components.TItem> view;

    @FXML
    /**
     * Returns user to main menu.
     */
    public void goBack(){
        screenUtil.switchScene("MainMenu.fxml", "Main Menu");
    }

    /**
     * Initializes the supervisor screen.
     * @throws SQLException
     */
    public void initialize() throws SQLException {

    }

    /**
     * Supervisor search function.
     */
    @FXML
    public void handleSearch(){
        screenUtil = new ScreenUtil();
        databaseUtil = new DatabaseUtil();
        accountsUtil = new AccountsUtil();

        TreeItem<johnsUtil.Components.TItem> root = new TreeItem<johnsUtil.Components.TItem>(new johnsUtil.Components.AccountItem(0,accountsUtil.getUsername()));
        try{
            ArrayList<TreeItem<johnsUtil.Components.TItem>> list = databaseUtil.getAccountItems();
            root.getChildren().addAll(list);


            view.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<johnsUtil.Components.TItem>>() {
                @Override
                public void changed(ObservableValue<? extends TreeItem<johnsUtil.Components.TItem>> observable, TreeItem<johnsUtil.Components.TItem> oldValue, TreeItem<johnsUtil.Components.TItem> newValue) {
                    if(newValue == null){
                        return;
                    }
                    else{
                        johnsUtil.Components.TItem value = newValue.getValue();
                        text1.setText(value.getText1());
                        text2.setText(value.getText2());
                        text3.setText(value.getText3());
                        field1.setText(value.getData1());
                        field2.setText(value.getData2());
                        field3.setText(value.getData3());
                    }
                }
            });

            view.setRoot(root);
            System.out.println("SET ROOT");
        }catch(SQLException e){
            System.out.println("Uh oh");
        }
        System.out.println("DOne");
    }

    /**
     * Switches to supervisor help screen.
     */
    public void needHelp (){
        screenUtil.switchScene("superVisorHelp.fxml","Help");
    }

}
