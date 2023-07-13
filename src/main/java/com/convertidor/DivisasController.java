package com.convertidor;

import java.io.IOException;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import com.convertidor.enums.Divisas;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DivisasController {
  @FXML
  private ChoiceBox<String> entrada;
  @FXML
  private ChoiceBox<String> salida;
  @FXML
  private TextField datoEntrada;
  @FXML
  private Label resultado;

  private Divisas divisas;

  public void initialize() {
    // divisas
    String[] divisas = obtenerTiposDivisas();
    entrada.setItems(FXCollections.observableArrayList(divisas));
    salida.setItems(FXCollections.observableArrayList(divisas));

    // opcion predeterminada
    entrada.setValue(divisas[0]);
    salida.setValue(divisas[1]);
  }

  // obtener los tipos de divisas
  public String[] obtenerTiposDivisas() {
    Divisas[] divisas = this.divisas.values();
    String[] arregloDivisas = new String[divisas.length];

    for (int i = 0; i < divisas.length; i++) {
      arregloDivisas[i] = divisas[i].getLabel();
    }

    return arregloDivisas;
  }

  // convertir divisas
  public void convertir() {
    try {
      convertirDivisas();

    } catch (Exception e) {
      resultado.setText("Ingrese un valor válido");
      System.out.println(e);
    }

  }

  // establecer los tipos divisas
  public Divisas establecerTipoDivisa(String text) {
    for (int i = 0; i < Divisas.values().length; i++) {
      if (Divisas.values()[i].getLabel().compareTo(text) == 0) {
        return Divisas.values()[i];
      }
    }
    return null;
  }

  // convertir valores de las divisas
  public void convertirDivisas() {
    float inputValor = establecerTipoDivisa(entrada.getValue()).getValor();
    float outputValor = establecerTipoDivisa(salida.getValue()).getValor();

    float operacion = Float.parseFloat(datoEntrada.getText()) * (inputValor / outputValor);

    // formato de 5 decimales
    DecimalFormat decimalFormat = new DecimalFormat("#.#####");
    decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
    String op = decimalFormat.format(operacion);

    resultado.setText(op);
  }

  @FXML
  private void switchToMenu() throws IOException {
    App.setRoot("menu");
  }
}
