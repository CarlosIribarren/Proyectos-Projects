package net.hge.beans;

public class Modelo {

  // *****************
  // *** ATRIBUTOS ***
  // *****************

  /** Numero del modelo */
  private String modelo;

  /** Ejercicio real del modelo */
  private Integer ejercicioReal;

  /** modl_zerga del modelo */
  private String modl_zerga;

  /** modl_reg_activo del modelo */
  private String modl_reg_activo;

  // *******************
  // *** CONSTRUCTOR ***
  // *******************

  public Modelo() {
    super();
  }

  // ***********************
  // *** MÉTODOS GET/SET ***
  // ***********************

  public String getModelo() {
    return this.modelo;
  }

  public void setModelo(final String modelo) {
    this.modelo = modelo;
  }

  public Integer getEjercicioReal() {
    return this.ejercicioReal;
  }

  public void setEjercicioReal(final Integer ejercicioReal) {
    this.ejercicioReal = ejercicioReal;
  }

  public String getModl_zerga() {
    return this.modl_zerga;
  }

  public void setModl_zerga(final String modl_zerga) {
    this.modl_zerga = modl_zerga;
  }

  public String getModl_reg_activo() {
    return this.modl_reg_activo;
  }

  public void setModl_reg_activo(final String modl_reg_activo) {
    this.modl_reg_activo = modl_reg_activo;
  }

}
