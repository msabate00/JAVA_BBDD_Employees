/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_practica_m03.model.dialog;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author AitramKG
 */
public class InsertPopup extends Dialog {
    
    private Button aceptar = new Button("Aceptar");
    
    public InsertPopup() {
        super("Añadir Nuevo Empleado");
        GridPane pane = new GridPane();
        pane.getChildren().addAll(aceptar);
        Scene dialogScene = new Scene(pane, 400, 150);
        dialog.setScene(dialogScene);
        dialog.show();
    }
    
    
    public Button getAceptar(){
        return aceptar;
    }
    
}
