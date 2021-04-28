/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_practica_m03.view;

import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

/**
 *
 * @author AitramKG
 */
public class CenterPane extends ScrollPane {

    GridPane grid = new GridPane();

    List<String> columnas;
    Text[][] contenido;

    List<Text> columnasNombres;

    public CenterPane(List<String> columnas, String[][] contenido) {
        this.columnas = columnas;
        //this.contenido = contenido;
        columnasNombres = generarColumnas();
        mostrarColumnas();
        mostrarContenido(contenido);

        setFitToHeight(true);
        setFitToWidth(true);

        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(5);
        setContent(grid);

    }

    private List<Text> generarColumnas() {
        List<Text> cols = new ArrayList<Text>();

        columnas.forEach((c) -> {
            cols.add(new Text(c));
        });
        return cols;

    }

    private void mostrarColumnas() {
        int contador = 0;

        for (Text t : columnasNombres) {
            grid.add(t, contador, 0);
            grid.getColumnConstraints().add(new ColumnConstraints(100));
            contador++;
        }

        grid.getRowConstraints().add(new RowConstraints(40));

    }

    private void mostrarContenido(String[][] contenido) {
        int contadorX = 0;
        int contadorY = 1;
        this.contenido = new Text[contenido.length][contenido[0].length];
        for (int i = 0; i < contenido.length; i++) {
            for (int j = 0; j < contenido[j].length; j++) {

                this.contenido[i][j] = new Text(contenido[i][j]);
                grid.add(this.contenido[i][j], contadorX, contadorY);
                contadorX++;

            }
            if (contenido[i][0] == null) {
                break;
            }
            contadorX = 0;
            contadorY++;
        }

    }

}
