/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_practica_m03.model.dialog;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javax.swing.text.DateFormatter;

/**
 *
 * @author AitramKG
 */
public class UpdatePopup extends Dialog {

    private Button aceptar = new Button("Aceptar");
    private TextField first_name = new TextField();
    private TextField last_name = new TextField();
    private ChoiceBox gender = new ChoiceBox(FXCollections.observableArrayList(
            "M", "F")
    );
    private DatePicker birth_date = new DatePicker();
    private DatePicker hire_date = new DatePicker();

    public UpdatePopup(String id, String[] datos) {
        super("Actualizar Empleado");
        GridPane pane = new GridPane();
        pane.setHgap(20);

        pane.add(new Text("emp_no"), 0, 0);
        pane.add(new Text(columnas[0]), 1, 0);
        pane.add(new Text(columnas[1]), 2, 0);
        pane.add(new Text(columnas[2]), 3, 0);
        pane.add(new Text(columnas[3]), 4, 0);
        pane.add(new Text(columnas[4]), 5, 0);
        
        first_name.setText(datos[1]);
        last_name.setText(datos[2]);
        
       /* switch(datos[3]){
            case "M":
                gender.setValue(0);
                break;
            case "F":
                gender.setValue(1);
                break;
        }*/
        
      
        gender.setValue(datos[3]);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate bd = LocalDate.parse(datos[0], formatter);
        birth_date.setValue(bd);
        
        LocalDate hd = LocalDate.parse(datos[4], formatter);
        hire_date.setValue(hd);

        pane.add(new Text(id),0,1);
        pane.add(first_name, 1, 1);
        pane.add(last_name, 2, 1);
        pane.add(gender, 3, 1);
        pane.add(birth_date, 4, 1);
        pane.add(hire_date, 5, 1);

        pane.add(aceptar, 0, 2);
        aceptar.setPrefWidth(140);
        
        
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
