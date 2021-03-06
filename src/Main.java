

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import bbdd_practica_m03.controller.Controller;
import bbdd_practica_m03.model.BaseDeDades;
import bbdd_practica_m03.model.Model;
import bbdd_practica_m03.view.View;
import java.sql.SQLException;

public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) throws SQLException {
       
        BaseDeDades bbdd = new BaseDeDades(); 
        Model m = new Model(bbdd);
        View v = new View(bbdd);
        Controller c = new Controller(m, v, bbdd);
        c.initController();

        primaryStage.setTitle("EmployeesFX");
        primaryStage.setScene(new Scene(v.getRootPane(), 300, 200));
        primaryStage.setMaximized(true);
        primaryStage.show();
        
        
       
        
    }

    public static void main(String[] args) {
        launch(args);
    }
}