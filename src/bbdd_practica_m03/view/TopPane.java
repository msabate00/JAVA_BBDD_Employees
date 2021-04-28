/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_practica_m03.view;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author AitramKG
 */


   
public class TopPane extends FlowPane{
     private final TextField buscaName = new TextField();
     private final Button buscaNameBut = new Button("Buscar Nombre");
     
     public TopPane(){
         getChildren().addAll(buscaName, buscaNameBut);
     }

    /**
     * @return the buscaName
     */
    public TextField getBuscaName() {
        return buscaName;
    }

    /**
     * @return the buscaNameBut
     */
    public Button getBuscaNameBut() {
        return buscaNameBut;
    }
     
}
