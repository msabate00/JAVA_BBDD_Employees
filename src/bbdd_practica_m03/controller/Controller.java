package bbdd_practica_m03.controller;

import bbdd_practica_m03.model.BaseDeDades;
import bbdd_practica_m03.model.dialog.InsertPopup;
import bbdd_practica_m03.model.Model;
import bbdd_practica_m03.model.dialog.Dialog;
import bbdd_practica_m03.view.View;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class Controller {

    private Model model;
    private View view;
    private BaseDeDades bbdd;
    private Dialog dialog;

    public Controller(Model m, View v, BaseDeDades bbdd) {
        model = m;
        view = v;
        this.bbdd = bbdd;
        initView();
        initController();
    }

    public void initView() {

    }

    public void initController() {

        view.getBottomPane().getPasarPagina().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                try {
                    view.PasarPagina();
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        view.getBottomPane().getRetrocederPagina().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                try {
                    view.RetrocederPagina();

                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        view.getTopPane().getBuscaNameBut().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                try {
                    view.ActualizarCenter(bbdd.findByName(view.getTopPane().getBuscaName().getText()));
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });
        
        view.getTopPane().getBuscaInsert().setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent t) {
                
                
                if(dialog != null && dialog.getStage().isShowing()){
                    dialog.getStage().close();
                }
                dialog = new InsertPopup();
               InsertPopup aux = (InsertPopup)dialog;
               aux.getAceptar().setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) {
                       System.out.println("AAAAAAAAAAAAAAAAAAAAAAAA");
                        dialog.getStage().close();
                    }
               
               
               });
               
                
            }
        
        
        });
        

    }
}
