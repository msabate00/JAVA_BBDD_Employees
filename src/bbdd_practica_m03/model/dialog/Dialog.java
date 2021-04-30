/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_practica_m03.model.dialog;

import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author AitramKG
 */
public class Dialog {
    
    protected Stage dialog;
    protected String[] columnas = new String[5];
    
    public Dialog(String title){
     this.dialog = new Stage();
     dialog.setTitle(title);
     dialog.initModality(Modality.APPLICATION_MODAL);
     dialog.resizableProperty().set(false);
     
     columnas[0] = "first_name";
     columnas[1] = "last_name";
     columnas[2] = "gender";
     columnas[3] = "birth_date";
     columnas[4] = "hire_date";
     
     
    
    }
    
    
    public Stage getStage(){
        return dialog;
    }
    
    
}
