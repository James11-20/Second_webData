package com.example.second_webdata;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

import java.net.URL;
import java.util.ResourceBundle;

public class UniversityController implements Initializable {
    @FXML
    private TextField NameField;
    @FXML
    private TextField UniversityCountyField;
    @FXML
    private TextField websiteDisplayField;
    @FXML
    private ListView<DataHandler.UniverityDatatype> ListControl;
    private DataHandler Model;

    public void loaData(){
        var site ="http://universities.hipolabs.com/search?name=";
        String pram = getQueryPeram();
        var wholeSite = site+pram;
        Model = new DataHandler(wholeSite);
        var universities = Model.getData();
        ObservableList<DataHandler.UniverityDatatype> UnivList = FXCollections.observableArrayList(universities);
        ListControl.setItems(UnivList);
    }

    private String getQueryPeram() {
        var inputDialog = new TextInputDialog("Young");
        inputDialog.setContentText("What University should we search for?");
        inputDialog.setHeaderText("Gatering information");
        var response = inputDialog.showAndWait();
        if (response.isEmpty()) {
            return "";
        } else {
            return response.get();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loaData();
    }
}