package com.sanu.hospital;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/patientDischargeForm.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Patient Discharge Form");
        Controller controller = loader.getController();
        controller.setMain(this);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();

        ComboBox bloodGroupBox = (ComboBox) scene.lookup("#bloodGroup");
        bloodGroupBox.setItems(FXCollections.observableArrayList("A+", "B+", "AB+", "O+", "A-", "B-", "AB-", "O-"));
        bloodGroupBox.getSelectionModel().select(0);
        ComboBox genderBox = (ComboBox) scene.lookup("#gender");
        genderBox.setItems(FXCollections.observableArrayList("Boy", "Girl"));
        genderBox.getSelectionModel().select(0);

        ComboBox hoursBox = (ComboBox) scene.lookup("#hours");
        ObservableList hours = FXCollections.observableArrayList();
        for (int i = 23; i >= 0; i--) {
            String hour = String.valueOf(i);
            if (hour.length() == 1) {
                hour = "0" + hour;
            }
            hours.add(hour);
        }
        hoursBox.setItems(hours);
        hoursBox.getSelectionModel().select(11);

        ComboBox minutesBox = (ComboBox) scene.lookup("#minutes");
        ObservableList minutes = FXCollections.observableArrayList();
        for (int i = 59; i >= 0; i--) {
            String minute = String.valueOf(i);
            if (minute.length() == 1) {
                minute = "0" + minute;
            }
            minutes.add(minute);
        }
        minutesBox.setItems(minutes);
        minutesBox.getSelectionModel().select(59);

        ComboBox contraceptionAdviceBox = (ComboBox) scene.lookup("#contraceptionAdvice");
        contraceptionAdviceBox.setItems(FXCollections.observableArrayList("None", "OCP", "Dipo Provera", "IUCD", "Sterilization"));
        contraceptionAdviceBox.getSelectionModel().select(0);

        DatePicker dateOfDischarge = (DatePicker) scene.lookup("#dateOfDischarge");
        dateOfDischarge.setValue(LocalDate.now());

//        DatePicker currentDate = (DatePicker) scene.lookup("#currentDate");
//        currentDate.setValue(LocalDate.now());

        ComboBox pogWeeksBox = (ComboBox) scene.lookup("#pogWeeks");
        ObservableList weeks = FXCollections.observableArrayList();
        for (int i = 52; i >=0 ;i--) {
            weeks.add(String.valueOf(i));
        }
        pogWeeksBox.setItems(weeks);
        pogWeeksBox.getSelectionModel().select(12);

        ComboBox pogDaysBox = (ComboBox) scene.lookup("#pogDays");
        ObservableList days = FXCollections.observableArrayList();
        for (int i = 6; i >=0 ;i--) {
            days.add(String.valueOf(i));
        }
        pogDaysBox.setItems(days);
        pogDaysBox.getSelectionModel().select(0);

        ComboBox apgarAtBirthBox = (ComboBox) scene.lookup("#apgarAtBirth");
        ComboBox apgarAt5minBox = (ComboBox) scene.lookup("#apgarAt5min");

        ObservableList apgars = FXCollections.observableArrayList();
        for (int i = 10; i >=0 ;i--) {
            apgars.add(String.valueOf(i));
        }
        apgarAtBirthBox.setItems(apgars);
        apgarAt5minBox.setItems(apgars);
        apgarAtBirthBox.getSelectionModel().select(0);
        apgarAt5minBox.getSelectionModel().select(0);


        ComboBox gravidityBox = (ComboBox) scene.lookup("#gravidity");
        ComboBox parityBox = (ComboBox) scene.lookup("#parity");
        ComboBox childrenBox = (ComboBox) scene.lookup("#children");
        ObservableList gpcValues = FXCollections.observableArrayList();

        for (int i = 0; i <= 20; i++) {
            gpcValues.add(String.valueOf(i));
        }

        gravidityBox.setItems(gpcValues);
        parityBox.setItems(gpcValues);
        childrenBox.setItems(gpcValues);
        gravidityBox.getSelectionModel().select(1);
        parityBox.getSelectionModel().select(0);
        childrenBox.getSelectionModel().select(0);


        ComboBox<String> indicationsBox = (ComboBox<String>) scene.lookup("#indication");
        indicationsBox.setItems(FXCollections.observableArrayList("Past Section", "Past Dates", "IUGR", "CPD", "Fetal Distress", "Malpresentation", "PIH/ Pre Eclampsia", "Other"));

    }


    public static void main(String[] args) {
        launch(args);
    }
}
