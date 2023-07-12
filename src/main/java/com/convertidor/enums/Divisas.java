package com.convertidor.enums;

public enum Divisas {
  PESO("Peso Mexicano", 1.0f),
  DOLAR("Dólar", 16.88f),
  EURO("Euro", 18.80f),
  LIBRA("Libra Esterlina", 21.93f),
  YEN("Yen Japonés", 0.12f),
  WON("Won Sur-coreano", 0.013f);

  private String label;
  private float valor;

  private Divisas(String label, float valor) {
    this.label = label;
    this.valor = valor;
  }

  public String getLabel() {
    return label;
  }

  public float getValor() {
    return valor;
  }
}
