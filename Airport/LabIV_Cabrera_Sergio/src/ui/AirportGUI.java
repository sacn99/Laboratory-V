package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Pagination;
import javafx.scene.control.TextField;
import model.Airport;

public class AirportGUI {
	private Airport airport;
    @FXML
    private Pagination pageIndicator;

    @FXML
    private TextField flightsQuantity;

    @FXML
    void changeOrientation(ActionEvent event) {

    }

    @FXML
    void createFlights(ActionEvent event) {
    	if(!flightsQuantity.getPromptText().equals("") && Integer.parseInt(flightsQuantity.getPromptText()) >= 0){
    		airport.createSimulation(Integer.parseInt(flightsQuantity.getPromptText()));    		
    		airport.orderByAirline();
    	}
    }

    @FXML
    void orderByAirline(ActionEvent event) {
    	airport.orderByAirline();
    }

    @FXML
    void orderByDestination(ActionEvent event) {
    	airport.orderByDestination();
    }

    @FXML
    void orderByFlight(ActionEvent event) {
    	airport.orderByFlight();
    }

    @FXML
    void orderByGate(ActionEvent event) {
    	airport.orderByGate();
    }

    @FXML
    void orderByHour(ActionEvent event) {
    	airport.orderByHour();
    }

    @FXML
    void orderByRemark(ActionEvent event) {
    	airport.orderByRemark();
    }

    @FXML
    void orderByTerminal(ActionEvent event) {
    	airport.orderByTerminal();
    }

    @FXML
    void reset(ActionEvent event) {
    	
    }

}
