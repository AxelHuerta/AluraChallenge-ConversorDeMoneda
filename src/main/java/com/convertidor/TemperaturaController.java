package com.convertidor;

import java.io.IOException;

import com.convertidor.enums.Temperaturas;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TemperaturaController {
  @FXML
  private ChoiceBox<String> entrada;
  @FXML
  private ChoiceBox<String> salida;
  @FXML
  private TextField datoEntrada;
  @FXML
  private Label resultado;

  private Temperaturas temperaturas;

  public void initialize() {
    // divisas
    String[] divisas = obtenerTipos();
    entrada.setItems(FXCollections.observableArrayList(divisas));
    salida.setItems(FXCollections.observableArrayList(divisas));

    // opcion predeterminada
    entrada.setValue(divisas[0]);
    salida.setValue(divisas[1]);
  }

  // obtener los tipos de divisas
  public String[] obtenerTipos() {
    Temperaturas[] temperaturas = this.temperaturas.values();
    String[] arregloTemperaturas = new String[temperaturas.length];

    for (int i = 0; i < temperaturas.length; i++) {
      arregloTemperaturas[i] = temperaturas[i].getTipo();
    }

    return arregloTemperaturas;
  }

  // convertiri divisas
  public void convertir() {
    try {
      convertirDivisas();

    } catch (Exception e) {
      resultado.setText("Ingrese un valor válido");
      System.out.println(e);
    }

  }

  // establecer los tipos divisas
  public Temperaturas establecerTipo(String text) {
    for (int i = 0; i < Temperaturas.values().length; i++) {
      if (Temperaturas.values()[i].getTipo().compareTo(text) == 0) {
        return Temperaturas.values()[i];
      }
    }
    return null;
  }

  // convertir valores de las divisas
  public void convertirDivisas() {
    double valor = Double.parseDouble(datoEntrada.getText());
    String input = establecerTipo(entrada.getValue()).getTipo();
    String output = establecerTipo(salida.getValue()).getTipo();
    String textoResultado = "";

    if (input.compareTo(output) == 0) {
      textoResultado = valor + "";
    }

    if (input.compareTo("Centigrados") == 0 && output.compareTo("Fahrenheit") == 0) {
      textoResultado = (valor * 1.8 + 32) + "";
    }
    if (input.compareTo("Fahrenheit") == 0 && output.compareTo("Centigrados") == 0) {
      textoResultado = ((valor - 32) / 1.8) + "";
    }
    if (input.compareTo("Centigrados") == 0 && output.compareTo("Kelvin") == 0) {
      textoResultado = (valor + 273.15) + "";
    }
    if (input.compareTo("Kelvin") == 0 && output.compareTo("Centigrados") == 0) {
      textoResultado = (valor - 273.15) + "";
    }
    if (input.compareTo("Kelvin") == 0 && output.compareTo("Fahrenheit") == 0) {
      textoResultado = ((valor - 273.15) * 1.8 + 32) + "";
    }
    if (input.compareTo("Fahrenheit") == 0 && output.compareTo("Kelvin") == 0) {
      textoResultado = ((valor - 32) / 1.8 + 273.15) + "";
    }

    resultado.setText(textoResultado);
  }

  @FXML
  private void switchToMenu() throws IOException {
    App.setRoot("menu");
  }
}
