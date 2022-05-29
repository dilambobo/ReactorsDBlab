package com.example.reactorslaba;

import com.example.reactorslaba.dbReactor.*;
import com.example.reactorslaba.jsonObjects.JsonParser;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.File;

public class Controller {

    JsonParser jsonParser;
    DBConnector dbConnector;
    Calculation calculation;

    @FXML
    private TableView<TableClass> countyTable;

        @FXML
        private TableColumn<TableClass, SimpleStringProperty> countyNameColumn;

        @FXML
        private TableColumn<TableClass, SimpleStringProperty> countyTotalConsumption;

    @FXML
    private TableView<TableClass> companyTable;

        @FXML
        private TableColumn<TableClass, SimpleStringProperty> companyNameColumn;

        @FXML
        private TableColumn<TableClass, SimpleStringProperty> companyTotalConsumption;

    @FXML
    private TableView<TableClass> regionTable;

        @FXML
        private TableColumn<TableClass, SimpleStringProperty> regionNameColumn;

        @FXML
        private TableColumn<TableClass, SimpleStringProperty> regionTotalConsumption;

    @FXML
    void makeCalculation() {
        try {
            jsonParser = new JsonParser(new File("/Users/dazorina/Documents/private/асус не умирай/files_for_laba4/ReactorType.json"));
            dbConnector = new DBConnector();
            dbConnector.connect(new File("/Users/dazorina/Documents/private/асус не умирай/files_for_laba4/Lab3.accdb"));
            dbConnector.setAll(jsonParser.getReactorArrayList());
            dbConnector.close();
            calculation = new Calculation(dbConnector);
            tableFilling();
            System.out.println();
        } catch (Exception e) {
            error(e);
        }
    }

    void tableFilling(){

        //заполнение таблицы регионов
        ObservableList<TableClass> dataRegions = FXCollections.observableArrayList();
        for (Region region : dbConnector.getRegions()) {
            dataRegions.add(new TableClass(new SimpleStringProperty(region.getName()), new SimpleDoubleProperty(region.getConsumption())));
        }
        regionNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        regionTotalConsumption.setCellValueFactory(new PropertyValueFactory("consumption"));
        regionTable.setItems(dataRegions);

        //заполнение таблицы стран
        ObservableList<TableClass> dataCountry = FXCollections.observableArrayList();
        for (Country country : dbConnector.getCountries()) {
            dataCountry.add(new TableClass(new SimpleStringProperty(country.getName()), new SimpleDoubleProperty(country.getConsumption())));
        }
        countyNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        countyTotalConsumption.setCellValueFactory(new PropertyValueFactory("consumption"));
        countyTable.setItems(dataCountry);

        //заполнение таблицы компаний (??)
        ObservableList<TableClass> dataCompany = FXCollections.observableArrayList();
        for (Company company : dbConnector.getCompanies()) {
            dataCompany.add(new TableClass(new SimpleStringProperty(company.getName()), new SimpleDoubleProperty(company.getConsumption())));
        }
        companyNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        companyTotalConsumption.setCellValueFactory(new PropertyValueFactory("consumption"));
        companyTable.setItems(dataCountry);
    }

    public static void error(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(String.valueOf(e));
        alert.showAndWait();
    }

}