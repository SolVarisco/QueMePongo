import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.Timer;

public class Pronostico {
  private Map<String, List<Map<String, Object>>> respuestas;

  private static final Pronostico INSTANCE = new Pronostico();

  private Pronostico(){

  }

  public static Pronostico instance(){
    return INSTANCE;
  }

  public List<Map<String, Object>> consultarClima(String ciudad){
    if(respuestas.containsKey(ciudad)){
      return respuestas.get(ciudad);
    }
    List<Map<String, Object>> respuesta = new AccuWeatherAPI().getWeather(ciudad);
    respuestas.put(ciudad, respuesta);
    return respuesta;
  }
}
