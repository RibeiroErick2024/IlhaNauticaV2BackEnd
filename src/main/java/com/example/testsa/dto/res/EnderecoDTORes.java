package com.example.testsa.dto.res;

import java.util.UUID;


public class EnderecoDTORes {

  private UUID idEndereco;

  private String cidade;

  private float latitude;

  private float longitude;

  private String rua;

  private String bairro;

  private Integer numero;

  private String complemento;

  private String estado;

  public UUID getIdEndereco() {
    return idEndereco;
  }

  public void setIdEndereco(UUID id_endereco) {
    this.idEndereco = id_endereco;
  }

  public String getCidade() {
    return cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public float getLatitude() {
    return latitude;
  }

  public void setLatitude(float latitude) {
    this.latitude = latitude;
  }

  public float getLongitude() {
    return longitude;
  }

  public void setLongitude(float longitude) {
    this.longitude = longitude;
  }

  public String getRua() {
    return rua;
  }

  public void setRua(String rua) {
    this.rua = rua;
  }

  public String getBairro() {
    return bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public Integer getNumero() {
    return numero;
  }

  public void setNumero(Integer numero) {
    this.numero = numero;
  }

  public String getComplemento() {
    return complemento;
  }

  public void setComplemento(String complemento) {
    this.complemento = complemento;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

}
