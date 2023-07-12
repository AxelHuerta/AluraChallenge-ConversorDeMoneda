package com.convertidor.enums;

public enum Temperaturas {
  CENTIGRADOS("Centigrados"),
  FAHRENHEIT("Fahrenheit"),
  KELVIN("Kelvin");

  private String tipo;

  private Temperaturas(String tipo) {
    this.tipo = tipo;
  }

  public String getTipo() {
    return tipo;
  }

}
