/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_practica_m03.view;

import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;

/**
 *
 * @author AitramKG
 */
public class BottomPane extends FlowPane{
    
    private Button pasarPagina = new Button("Siguiente");
    private Button retrocederPagina = new Button("Anterior");
    
    public BottomPane(){
    
        getChildren().addAll(retrocederPagina,pasarPagina);
     
        
    }

    /**
     * @return the pasarPagina
     */
    public Button getPasarPagina() {
        return pasarPagina;
    }

    /**
     * @return the retrocederPagina
     */
    public Button getRetrocederPagina() {
        return retrocederPagina;
    }
    
    
    
    
}
