/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_practica_m03.model.dialog;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
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
public class InfoPopup extends Dialog{

    public InfoPopup(String info) {
        super("CREACION FINALIZADA");
        FlowPane pane = new FlowPane();
        
        
        pane.getChildren().add(new Text(info));
        // pane.backgroundProperty().set(new Background(new BackgroundFill(Color.CORNFLOWERBLUE)));
        pane.setBackground(new Background(new BackgroundFill(Paint.valueOf("#a7ff70"), CornerRadii.EMPTY, Insets.EMPTY)));
        pane.alignmentProperty().set(Pos.CENTER);
        
        
        Scene dialogScene = new Scene(pane, 400, 100);
        dialog.setScene(dialogScene);
        dialog.show();
        
        
        
    }


    
}
