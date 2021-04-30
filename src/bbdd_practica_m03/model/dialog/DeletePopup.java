/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_practica_m03.model.dialog;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author AitramKG
 */
public class DeletePopup extends Dialog {

    private Button aceptar = new Button("Aceptar");
    private TextField id = new TextField();

    public DeletePopup() {
        super("Eliminar Empleado");
        GridPane pane = new GridPane();
        pane.setHgap(20);

        pane.add(new Text("Id"), 0, 0);
   

        pane.add(id, 0, 1);


        pane.add(aceptar, 0, 2);
        pane.setPadding(new Insets(10));
        pane.getRowConstraints().add(new RowConstraints(25));
        pane.getRowConstraints().add(new RowConstraints(25));
        pane.getRowConstraints().add(new RowConstraints(60));
        pane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#ffa694"), CornerRadii.EMPTY, Insets.EMPTY)));

        Scene dialogScene = new Scene(pane, 100, 100);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    public Button getAceptar() {
        return aceptar;
    }

    /**
     * @return the id
     */
    public TextField getId() {
        return id;
    }

    /**
     * @return the first_name
     */
   

}
