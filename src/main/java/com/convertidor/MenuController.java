package com.convertidor;

import java.io.IOException;

import javafx.fxml.FXML;

public class MenuController {
  @FXML
  private void switchToDivisas() throws IOException {
    App.setRoot("divisas");
  }

  @FXML
  private void switchToTemperatura() throws IOException {
    App.setRoot("temperatura");
  }
}
