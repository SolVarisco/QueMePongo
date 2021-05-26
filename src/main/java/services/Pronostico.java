package services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Pronostico {
  private Map<String, Respuesta> respuestas;

  private static final Pronostico INSTANCE = new Pronostico();

  private Pronostico(){

  }

  public static Pronostico instance(){
    return INSTANCE;
  }

  public List<Map<String, Object>> consultarClima(String ciudad, LocalDateTime nuevoVencimiento){
    if(respuestas.containsKey(ciudad)){
      Respuesta respuesta = respuestas.get(ciudad);
      if(respuesta.getVencimiento().isBefore(LocalDateTime.now())){
        return respuesta.getClima();
      } else {
        respuestas.remove(ciudad, respuesta);
      }
    }
    Respuesta nuevoClima = new Respuesta();
    nuevoClima.setVencimiento(nuevoVencimiento);
    nuevoClima.setClima(new AccuWeatherAPI().getWeather(ciudad));
    respuestas.put(ciudad, nuevoClima);
    return nuevoClima.getClima();
  }
}
