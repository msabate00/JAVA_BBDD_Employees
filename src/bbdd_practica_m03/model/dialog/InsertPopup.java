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
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author AitramKG
 */
public class InsertPopup extends Dialog {

    private Button aceptar = new Button("Aceptar");
    private TextField first_name = new TextField();
    private TextField last_name = new TextField();
    private ChoiceBox gender = new ChoiceBox(FXCollections.observableArrayList(
            "M", "F", "O")
    );
    private DatePicker birth_date = new DatePicker();
    private DatePicker hire_date = new DatePicker();

    public InsertPopup() {
        super("Añadir Nuevo Empleado");
        GridPane pane = new GridPane();
        pane.setHgap(20);

        pane.add(new Text(columnas[0]), 0, 0);
        pane.add(new Text(columnas[1]), 1, 0);
        pane.add(new Text(columnas[2]), 2, 0);
        pane.add(new Text(columnas[3]), 3, 0);
        pane.add(new Text(columnas[4]), 4, 0);

        pane.add(first_name, 0, 1);
        pane.add(last_name, 1, 1);
        pane.add(gender, 2, 1);
        pane.add(birth_date, 3, 1);
        pane.add(hire_date, 4, 1);

        pane.add(aceptar, 0, 2);
        pane.setPadding(new Insets(10));
        pane.getRowConstraints().add(new RowConstraints(25));
        pane.getRowConstraints().add(new RowConstraints(25));
        pane.getRowConstraints().add(new RowConstraints(60));

        Scene dialogScene = new Scene(pane, 600, 100);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    public Button getAceptar() {
        return aceptar;
    }

    /**
     * @return the first_name
     */
    public TextField getFirst_name() {
        return first_name;
    }

    /**
     * @return the last_name
     */
    public TextField getLast_name() {
        return last_name;
    }

    /**
     * @return the gender
     */
    public ChoiceBox getGender() {
        return gender;
    }

    /**
     * @return the birth_date
     */
    public DatePicker getBirth_date() {
        return birth_date;
    }

    /**
     * @return the hire_date
     */
    public DatePicker getHire_date() {
        return hire_date;
    }

}
