package net.eurohelp.hge.beans;

import java.util.Date;


public class Periodo {

  // *****************
  // *** ATRIBUTOS ***
  // *****************

  /** Codigo interno del modelo */
  private Integer modl_num;
  /** Numero de Modelo */
  private String modl_tmod_cod;
  /** Ejercicio Real */
  private Integer modl_ejercicio_ini;
  /** Fecha inicio vigente */
  private Date modl_fec_ini_vig;
  /** Periodo */
  private Integer peri_periodo;
  /** Tipo Periodo */
  private String peri_tper_cod;
  /** Periodo Activo (s/n) */
  private Integer peri_reg_activo;

  // *******************
  // *** CONSTRUCTOR ***
  // *******************

  public Periodo() {
    super();
  }

  // ***********************
  // *** MÉTODOS GET/SET ***
  // ***********************

  public Integer getModl_num() {
    return this.modl_num;
  }

  public void setModl_num(final Integer modl_num) {
    this.modl_num = modl_num;
  }

  public String getModl_tmod_cod() {
    return this.modl_tmod_cod;
  }

  public void setModl_tmod_cod(final String modl_tmod_cod) {
    this.modl_tmod_cod = modl_tmod_cod;
  }

  public Integer getModl_ejercicio_ini() {
    return this.modl_ejercicio_ini;
  }

  public void setModl_ejercicio_ini(final Integer modl_ejercicio_ini) {
    this.modl_ejercicio_ini = modl_ejercicio_ini;
  }

  public Date getModl_fec_ini_vig() {
    return this.modl_fec_ini_vig;
  }

  public void setModl_fec_ini_vig(final Date modl_fec_ini_vig) {
    this.modl_fec_ini_vig = modl_fec_ini_vig;
  }

  public Integer getPeri_periodo() {
    return this.peri_periodo;
  }

  public void setPeri_periodo(final Integer peri_periodo) {
    this.peri_periodo = peri_periodo;
  }

  public String getPeri_tper_cod() {
    return this.peri_tper_cod;
  }

  public void setPeri_tper_cod(final String peri_tper_cod) {
    this.peri_tper_cod = peri_tper_cod;
  }

  public Integer getPeri_reg_activo() {
    return this.peri_reg_activo;
  }

  public void setPeri_reg_activo(final Integer peri_reg_activo) {
    this.peri_reg_activo = peri_reg_activo;
  }

}
