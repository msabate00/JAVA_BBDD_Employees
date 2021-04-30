/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbdd_practica_m03.view;

import bbdd_practica_m03.model.Icon;
import java.util.ArrayList;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

/**
 *
 * @author AitramKG
 */
public class CenterPane extends ScrollPane {

    
    private Image delete = new Image(".\\bbdd_practica_m03\\img\\icons\\eliminar.png");
    private Image edit = new Image(".\\bbdd_practica_m03\\img\\icons\\editar.png");
    
    GridPane grid = new GridPane();

    List<String> columnas;
    Text[][] contenido;

    List<Text> columnasNombres;
    private List<Icon> edits;
    private List<Icon> deletes;

    public CenterPane(List<String> columnas, String[][] contenido) {
        this.edits = new ArrayList<Icon>();
        this.deletes = new ArrayList<Icon>();
        this.columnas = columnas;
        //this.contenido = contenido;
        columnasNombres = generarColumnas();
        mostrarColumnas();
        mostrarContenido(contenido);

        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(5);
        setContent(grid);
        setFitToHeight(true);
        setFitToWidth(true);

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
        grid.add(new Text("Acciones"), contador, 0);

        grid.getRowConstraints().add(new RowConstraints(40));

    }

    private void mostrarContenido(String[][] contenido) {
        int contadorX = 0;
        int contadorY = 1;

        //   System.out.println(contenido.length + " -- " + contenido[0].length);
        if (contenido.length > 0) {
            this.contenido = new Text[contenido.length][contenido[0].length];
            for (int i = 0; i < contenido.length; i++) {
                for (int j = 0; j < contenido[j].length; j++) {

                    this.contenido[i][j] = new Text(contenido[i][j]);
                    grid.add(this.contenido[i][j], contadorX, contadorY);
                    contadorX++;
                    //  if(j == 0)   System.out.println(contenido[i][0]);
                }
                Icon edit = new Icon(this.edit, contenido[i][0],contenido[i][1],contenido[i][2],contenido[i][3],contenido[i][4],contenido[i][5]);
               
                getEdits().add(edit);
                grid.add(edit, contadorX, contadorY);
                
                Icon delete = new Icon(this.delete, contenido[i][0]);
                getDeletes().add(delete);
                grid.add(delete, contadorX+1, contadorY);
                
                if (contenido[i][0] == null) {
                    break;
                }
                contadorX = 0;
                contadorY++;
            }
        }

    }

    /**
     * @return the edits
     */
    public List<Icon> getEdits() {
        return edits;
    }

    /**
     * @return the deletes
     */
    public List<Icon> getDeletes() {
        return deletes;
    }

}
