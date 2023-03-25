package com.example.projeto03javafz.model;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class MascarasFX {

    public static void maskDate(TextField textField){
        tamanhoMaximo(textField, 10);

        textField.setOnKeyTyped((KeyEvent event) -> {
            if("0123456789".contains(event.getCharacter())==false){
                event.consume();
            }

            if(event.getCharacter().trim().length()==0){

                if(textField.getText().length()==3){
                    textField.setText(textField.getText().substring(0,2));
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==6){
                    textField.setText(textField.getText().substring(0,5));
                    textField.positionCaret(textField.getText().length());
                }

            }else{

                if(textField.getText().length()==10) event.consume();

                if(textField.getText().length()==2){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==5){
                    textField.setText(textField.getText()+"/");
                    textField.positionCaret(textField.getText().length());
                }
            }
        });

        textField.setOnKeyReleased((KeyEvent evt) -> {

            if(!textField.getText().matches("\\d/*")){
                textField.setText(textField.getText().replaceAll("[^\\d/]", ""));
                textField.positionCaret(textField.getText().length());
            }
        });

    }

    public static void maskCPF (TextField textField){
        tamanhoMaximo(textField, 14);

        textField.setOnKeyTyped((KeyEvent event) -> {
            if("0123456789".contains(event.getCharacter())==false){
                event.consume();
            }

            if(event.getCharacter().trim().length()==0){ // apagando

                if(textField.getText().length()==4){
                    textField.setText(textField.getText().substring(0,3));
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==8){
                    textField.setText(textField.getText().substring(0,7));
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==12){
                    textField.setText(textField.getText().substring(0,11));
                    textField.positionCaret(textField.getText().length());
                }

            }else{ // escrevendo

                if(textField.getText().length()==14) event.consume();

                if(textField.getText().length()==3){
                    textField.setText(textField.getText()+".");
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==7){
                    textField.setText(textField.getText()+".");
                    textField.positionCaret(textField.getText().length());
                }
                if(textField.getText().length()==11){
                    textField.setText(textField.getText()+"-");
                    textField.positionCaret(textField.getText().length());
                }

            }
        });

        textField.setOnKeyReleased((KeyEvent evt) -> {

            if(!textField.getText().matches("\\d.-*")){
                textField.setText(textField.getText().replaceAll("[^\\d.-]", ""));
                textField.positionCaret(textField.getText().length());
            }
        });

    }

    private static void tamanhoMaximo(final TextField textField, final Integer length) {
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if (newValue.length() > length)
                    textField.setText(oldValue);
            }
        });
    }
}
