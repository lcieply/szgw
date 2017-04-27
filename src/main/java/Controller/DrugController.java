package Controller;

import Model.domain.Drug;
import View.DrugView;
import antlr.StringUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrugController {
    private DrugView view;
    private Drug model;

    public DrugController(DrugView view, Drug model) {
        this.view = view;
        this.model = model;
        this.view.addCreateButtonListener(new createButtonListener());
        this.view.addSearchButtonListener(new searchButtonListener());
        this.view.addUpdateButtonListener(new updateButtonListener());
    }

    class createButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                String name = view.getDrugName();
                String type = view.getDrugType();
                String application = view.getApplication();
                long number = view.getNumber();
                boolean need = view.getNeed();

                if (number >= 0) {
                    if (model.createDrug(name, type, application, number, need))
                        view.setResult("OK.");
                    else
                        view.displayErrorMessage("Taki lek już istnieje.");
                }
                else
                    view.displayErrorMessage("Podaj poprawną liczbę sztuk.");
            }
            catch (DrugView.EmptyFieldException e) {
                view.displayErrorMessage("Wypełnij wszystkie pola.");
            }
            catch (NumberFormatException e) {
                view.displayErrorMessage("Podaj poprawną liczbę sztuk.");
            }
        }
    }

    class searchButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                String name = view.getDrugName();
                Drug drug = model.getDrugByName(name);
                if (drug != null) {
                    view.setDrugType(drug.getType());
                    view.setApplication(drug.getApplication());
                    view.setNumber(drug.getNumber());
                    view.setNeed(drug.getNeed());
                } else
                    view.displayErrorMessage("Nie znaleziono.");
            }
            catch (DrugView.EmptyFieldException e) {
                view.displayErrorMessage("Podaj nazwę leku, który chcesz edytować.");
            }
        }
    }

    class updateButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            try {
                Drug drug = Drug.getDrugByName(view.getDrugName());
                String type = view.getDrugType();
                String application = view.getApplication();
                long number = view.getNumber();
                boolean need = view.getNeed();
                if (number >= 0) {
                    if (model.updateType(drug, type) && model.updateApplication(drug, application) && model.updateNumber(drug, number) && model.updateNeed(drug, need))
                        view.setResult("OK.");
                    else
                        view.displayErrorMessage("Błąd.");
                }
                else
                    view.displayErrorMessage("Podaj poprawną liczbę sztuk.");
            }
            catch (DrugView.EmptyFieldException e) {
                view.displayErrorMessage("Wypełnij wszystkie pola.");
            }
            catch (NumberFormatException e) {
                view.displayErrorMessage("Podaj poprawną liczbę sztuk.");
            }
        }
    }
}
