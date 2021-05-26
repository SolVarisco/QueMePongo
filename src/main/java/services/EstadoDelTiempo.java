package services;

import java.time.LocalDateTime;
import java.util.HashMap;

public class EstadoDelTiempo {
  private int precipitaciones;
  private int temperatura;
  private LocalDateTime parametorDuracion;
  private Pronostico servicio;

  public EstadoDelTiempo(LocalDateTime parametorDuracion, Pronostico servicio) {
    this.parametorDuracion = parametorDuracion;
    this.servicio = servicio;
  }

  public EstadoDelTiempo getClima(String ciudad){
    HashMap<String, Object> clima = (HashMap<String, Object>) servicio.consultarClima(ciudad, parametorDuracion).get(0);
    precipitaciones = (int)clima.get("PrecipitationProbability");
    HashMap<String, Object> datosTemperatura = (HashMap<String, Object>)clima.get("Temperature");
    temperatura = (int)datosTemperatura.get("Value");
    return this;
  }

  public int getTemperatura() {
    return temperatura;
  }

  public void setParametorDuracion(LocalDateTime parametorDuracion) {
    this.parametorDuracion = parametorDuracion;
  }

  public void setServicio(Pronostico servicio) {
    this.servicio = servicio;
  }
}
