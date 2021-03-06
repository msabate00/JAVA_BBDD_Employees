package bbdd_practica_m03.controller;

import bbdd_practica_m03.model.BaseDeDades;
import bbdd_practica_m03.model.Icon;
import bbdd_practica_m03.model.dialog.InsertPopup;
import bbdd_practica_m03.model.Model;
import bbdd_practica_m03.model.dialog.DeletePopup;
import bbdd_practica_m03.model.dialog.Dialog;
import bbdd_practica_m03.model.dialog.ErrorPopup;
import bbdd_practica_m03.model.dialog.InfoPopup;
import bbdd_practica_m03.model.dialog.UpdatePopup;
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
        UpdateController();
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
                    UpdateController();
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        });

        view.getTopPane().getBuscaInsert().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                insertTop();

            }

        });

        view.getTopPane().getBuscaDelete().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                delete();
            }
        });

    }

    private void UpdateController() {
        /*for (Icon i : view.getCenterPane().getDeletes()) {
            i.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    delete(i.getid());
                }
            });
        }*/

        view.getCenterPane().getDeletes().forEach((i) -> {
            i.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    delete(i.getid());
                }
            });
        });

        view.getCenterPane().getEdits().forEach((i) -> {
            i.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {
                    update(i.getid(), i.getDatos());
                }
            });
        });

    }

    private void insertTop() {
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
                        dialog = new ErrorPopup("NO SE A PODIDO A??ADIR EL EMPLEADO");
                    } else {
                        if (dialog != null && dialog.getStage().isShowing()) {
                            dialog.getStage().close();
                        }
                        dialog = new InfoPopup("EL EMPLEADO SE A A??ADIDO CORRECTAMENTE");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    private void delete() {

        if (dialog != null && dialog.getStage().isShowing()) {
            dialog.getStage().close();
        }
        dialog = new DeletePopup();
        DeletePopup aux = (DeletePopup) dialog;

        aux.getAceptar().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                dialog.getStage().close();
                try {
                    if (!bbdd.delete(aux.getId().getText())) {
                        if (dialog != null && dialog.getStage().isShowing()) {
                            dialog.getStage().close();
                        }
                        dialog = new ErrorPopup("NO SE A PODIDO ELIMINAR AL EMPLEADO");
                    } else {
                        if (dialog != null && dialog.getStage().isShowing()) {
                            dialog.getStage().close();
                        }
                        dialog = new InfoPopup("EL EMPLEADO SE A ELIMINADO CORRECTAMENTE");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    private void delete(String id) {

        if (dialog != null && dialog.getStage().isShowing()) {
            dialog.getStage().close();
        }
        dialog = new DeletePopup();
        DeletePopup aux = (DeletePopup) dialog;

        aux.getId().setText(id);

        aux.getAceptar().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                dialog.getStage().close();
                try {
                    if (!bbdd.delete(aux.getId().getText())) {
                        if (dialog != null && dialog.getStage().isShowing()) {
                            dialog.getStage().close();
                        }
                        dialog = new ErrorPopup("NO SE A PODIDO ELIMINAR AL EMPLEADO");
                    } else {
                        if (dialog != null && dialog.getStage().isShowing()) {
                            dialog.getStage().close();
                        }
                        dialog = new InfoPopup("EL EMPLEADO SE A ELIMINADO CORRECTAMENTE");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

    private void update(String id, String[] datos1) {

        if (dialog != null && dialog.getStage().isShowing()) {
            dialog.getStage().close();
        }
        dialog = new UpdatePopup(id, datos1);
        UpdatePopup aux = (UpdatePopup) dialog;

        aux.getAceptar().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                String[] datos = new String[5];
                datos[0] = aux.getFirst_name().getText();
                datos[1] = aux.getLast_name().getText();
                datos[2] = aux.getGender().getSelectionModel().getSelectedItem().toString();
                datos[3] = aux.getBirth_date().getValue().toString();
                datos[4] = aux.getHire_date().getValue().toString();
                dialog.getStage().close();
                try {
                    if (!bbdd.update(id,datos)) {
                        if (dialog != null && dialog.getStage().isShowing()) {
                            dialog.getStage().close();
                        }
                        dialog = new ErrorPopup("NO SE A PODIDO EDITAR EL EMPLEADO");
                    } else {
                        if (dialog != null && dialog.getStage().isShowing()) {
                            dialog.getStage().close();
                        }
                        dialog = new InfoPopup("EL EMPLEADO SE A EDITADO CORRECTAMENTE");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }

}
