package bbdd_practica_m03.view;

import bbdd_practica_m03.model.BaseDeDades;
import java.sql.SQLException;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class View {

    private BorderPane rootPane;
    private CenterPane centerPane;
    private TopPane topPane;
    private BottomPane bottomPane;
    private BaseDeDades bbdd;

    public View(BaseDeDades bbdd) throws SQLException {
        this.bbdd = bbdd;
        rootPane = new BorderPane();
        
        
        centerPane = new CenterPane(this.bbdd.getColumns(), this.bbdd.getContent(0));
        topPane = new TopPane();
        
        bottomPane = new BottomPane();

        rootPane.setCenter(centerPane);
        rootPane.setTop(topPane);
        rootPane.setBottom(bottomPane);

    }

    public BorderPane getRootPane() {
        return rootPane;
    }

    public void PasarPagina() throws SQLException {
        centerPane = new CenterPane(this.bbdd.getColumns(), this.bbdd.getContent(this.bbdd.getLastrow()));
        rootPane.setCenter(getCenterPane());

    }

    public void RetrocederPagina() throws SQLException {

        centerPane = new CenterPane(this.bbdd.getColumns(), (this.bbdd.getContent(Math.max(this.bbdd.getLastrow() - (this.bbdd.getMostrarFilas() * 2), 0))));
        rootPane.setCenter(getCenterPane());

    }
    public CenterPane getCenterPane() {
        return centerPane;
    }
    
    public void ActualizarCenter(String[][] ar) throws SQLException{
        centerPane = new CenterPane(this.bbdd.getColumns(), ar);
        rootPane.setCenter(getCenterPane());
    }

    /**
     * @return the bottomPane
     */
    public BottomPane getBottomPane() {
        return bottomPane;
    }

    /**
     * @return the topPane
     */
    public TopPane getTopPane() {
        return topPane;
    }

}
