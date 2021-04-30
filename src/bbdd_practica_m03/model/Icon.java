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

    public Icon(Image i, String id) {
        this.setGraphic(new ImageView(i));
        this.id = id;
    }

    public String getid() {
        return id;
    }

}
