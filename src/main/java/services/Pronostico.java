package services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface Pronostico {
  List<Map<String, Object>> consultarClima(String ciudad, LocalDateTime nuevoVencimiento);
}
