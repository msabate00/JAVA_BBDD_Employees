/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_practica_m03.model;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author AitramKG
 */
public class Icon extends Button {

    private String id;
    private String[] datos = new String[5];

    public Icon(Image i, String id, String fn, String ln, String g, String bd, String hd) {
        this.setGraphic(new ImageView(i));
        this.id = id;
        this.datos[0] = fn;
        this.datos[1] = ln;
        this.datos[2] = g;
        this.datos[3] = bd;
        this.datos[4] = hd;
        
    }

    public Icon(Image i, String id) {
        this.setGraphic(new ImageView(i));
        this.id = id;

    }

    public String getid() {
        return id;
    }

    /**
     * @return the datos
     */
    public String[] getDatos() {
        return datos;
    }

}
