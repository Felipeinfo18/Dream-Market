package sample.control;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Browser;
import sample.model.Cidade;
import sample.model.Controle;

import java.io.IOException;
import java.sql.SQLException;

public class CadastraNormal extends Mensagem{

    @FXML
    private JFXTextField tfNome;
    @FXML
    private JFXTextField tfEmail;
    @FXML
    private JFXPasswordField pfSenha;
    @FXML
    private JFXPasswordField pfConfirmacao;
    @FXML
    private JFXComboBox<Cidade> cbCidade;
    @FXML
    private Label lbInfo;

    public void initialize() throws SQLException {
        ObservableList cidades = FXCollections.observableArrayList();
        cidades.addAll(Controle.getInstance().carregaCidades());
        cbCidade.setItems(cidades);
    }

    @FXML
    void acaoFechar(){
        System.exit(0);
    }

    public void proximoPasso(ActionEvent event) {
        if(tfNome.getLength() < 3 || tfEmail.getLength() < 3 || pfSenha.getLength() < 3 || pfConfirmacao.getLength() < 3 || cbCidade.getSelectionModel().selectedItemProperty().getValue() == null){
            Aviso(Alert.AlertType.WARNING, "Preencha todos os dados exigidos!");
        }
        else {
            String nome = tfNome.getText();
            String email = tfEmail.getText();
            String senha = pfSenha.getText();
            Cidade cidade = cbCidade.getSelectionModel().getSelectedItem();
        }

        Browser.loadWindows(Browser.EXIBECONDICOESNORMAL);
    }

    public void voltar(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(
                getClass().getResourceAsStream(
                        Browser.BASE
                )
        );

        Base controller = loader.getController();

        Browser.setController(controller);
        Browser.loadWindows(Browser.CADASTRAUSUARIO);

        stage.setScene(new Scene(mainPane, 1280, 720));
        stage.show();
    }

    public void mostrarLabel(MouseEvent event) {
        double xOffset = 0;
        double yOffset = 0;

        lbInfo.setVisible(Boolean.TRUE);
        xOffset = event.getSceneX();
        yOffset = event.getSceneY();
        lbInfo.setLayoutX(xOffset);
        lbInfo.setLayoutY(yOffset);
    }

    public void esconderLabel(MouseEvent event) {
        lbInfo.setVisible(Boolean.FALSE);
    }

    public void addCidade(MouseEvent mouseEvent) {

    }
}