/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_practica_m03.model.dialog;

import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;

/**
 *
 * @author AitramKG
 */
public class InfoPopup extends Dialog{

    public InfoPopup(String info) {
        super("CREACION FINALIZADA");
        FlowPane pane = new FlowPane();
        
        
        pane.getChildren().add(new Text(info));
        
        
        
        Scene dialogScene = new Scene(pane, 400, 100);
        dialog.setScene(dialogScene);
        dialog.show();
        
        
        
    }


    
}
