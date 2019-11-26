package sample.control;

import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.Browser;

public class MenuAdm {
    @FXML
    private JFXToggleButton tgModo;

    @FXML
    void acaoFechar(){
        System.exit(0);
    }

    public void alteraModo(ActionEvent event) {
        Browser.loadWindows(Browser.MENU);
    }
}
