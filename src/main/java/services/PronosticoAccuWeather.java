package services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class PronosticoAccuWeather implements Pronostico{
  private Map<String, Respuesta> respuestas;

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
