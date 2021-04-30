package bbdd_practica_m03.controller;

import bbdd_practica_m03.model.BaseDeDades;
import bbdd_practica_m03.model.dialog.InsertPopup;
import bbdd_practica_m03.model.Model;
import bbdd_practica_m03.model.dialog.Dialog;
import bbdd_practica_m03.model.dialog.ErrorPopup;
import bbdd_practica_m03.model.dialog.InfoPopup;
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
                    String[][] aux = bbdd.findByName(view.getTopPane().getBuscaName().getText());
                    if (aux.length == 0) {
                        if (dialog != null && dialog.getStage().isShowing()) {
                            dialog.getStage().close();
                        }
                        dialog = new ErrorPopup("NO SE A ENCONTRADO NINGUN RESULTADO");
                    }
                    view.ActualizarCenter(aux);
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        view.getTopPane().getBuscaInsert().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                if (dialog != null && dialog.getStage().isShowing()) {
                    dialog.getStage().close();
                }
                dialog = new InsertPopup();
                InsertPopup aux = (InsertPopup) dialog;

                String[] datos = new String[5];

                aux.getAceptar().setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent t) {
                        datos[0] = aux.getFirst_name().getText();
                        datos[1] = aux.getLast_name().getText();
                        datos[2] = aux.getGender().getSelectionModel().getSelectedItem().toString();
                        datos[3] = aux.getBirth_date().getValue().toString();
                        datos[4] = aux.getHire_date().getValue().toString();
                        dialog.getStage().close();
                        try {
                            if (!bbdd.insert(datos)) {
                                if (dialog != null && dialog.getStage().isShowing()) {
                                    dialog.getStage().close();
                                }
                                dialog = new ErrorPopup("NO SE A PODIDO AÑADIR EL EMPLEADO");
                            } else {
                                if (dialog != null && dialog.getStage().isShowing()) {
                                    dialog.getStage().close();
                                }
                                dialog = new InfoPopup("EL EMPLEADO SE A AÑADIDO CORRECTAMENTE");
                            }

                        } catch (SQLException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                });

            }

        });

    }
}
