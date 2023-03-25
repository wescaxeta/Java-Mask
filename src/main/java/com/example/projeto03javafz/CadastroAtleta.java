package com.example.projeto03javafz;

import com.example.projeto03javafz.model.Atleta;
import com.example.projeto03javafz.model.MascarasFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class CadastroAtleta implements Initializable {

   private List<Atleta> atletas = new ArrayList <>();

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnSalvar;

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtData;

    @FXML
    private TextField txtNome;

    @FXML
    void btnSalvarOnAction(ActionEvent event) {
        String valorCPF = txtCPF.getText();
        String valorNome = txtNome.getText();
        String valorData = txtData.getText();

        if( ValidaCampos(valorCPF, valorNome, valorData)) {
            //Mensagem de sucesso
            showValidation();
            //adiciona na lista de clientes
            atletas.add(new Atleta(valorData, valorCPF, valorNome));
            //preeche os campos com nulo
            txtCPF.setText("");
            txtNome.setText("");
            txtData.setText("");
        }
    }

    @FXML
    void btnCancelarOnAction(ActionEvent event) {
        txtCPF.setText("");
        txtNome.setText("");
        txtData.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        MascarasFX.maskCPF(txtCPF);
        MascarasFX.maskDate(txtData);
    }

    public void showValidation(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CORRETO:");
        alert.setHeaderText("Dados preenchidos e salvos");
        alert.showAndWait();
    }

    public boolean ValidaCampos(String valorCPF, String valornome, String valorData) {
        if (valornome.isEmpty()){
            txtNome.requestFocus();
            return false;
        } else if (valorData.isEmpty()){
            txtNome.requestFocus();
            return false;
        } else if (valorCPF.isEmpty()) {
            txtCPF.requestFocus();
            return false;
        }
        return true;
    }
}
