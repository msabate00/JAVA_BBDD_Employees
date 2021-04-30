/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_practica_m03.model.dialog;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;

/**
 *
 * @author AitramKG
 */
public class ErrorPopup extends Dialog{

    public ErrorPopup(String error) {
        super("ERROR");
        FlowPane pane = new FlowPane();
        
        
        pane.getChildren().add(new Text(error));
        pane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#ffa694"), CornerRadii.EMPTY, Insets.EMPTY)));
        
        
        Scene dialogScene = new Scene(pane, 400, 100);
        dialog.setScene(dialogScene);
        dialog.show();
        
        
        
    }


    
}
