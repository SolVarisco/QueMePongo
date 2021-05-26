package services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Respuesta {
  private List<Map<String, Object>> clima;
  private LocalDateTime vencimiento;

  public Respuesta(){

  }

  public Respuesta(List<Map<String, Object>> clima, LocalDateTime vencimiento) {
    this.clima = clima;
    this.vencimiento = vencimiento;
  }

  public void setClima(List<Map<String, Object>> clima) {
    this.clima = clima;
  }

  public void setVencimiento(LocalDateTime vencimiento) {
    this.vencimiento = vencimiento;
  }

  public List<Map<String, Object>> getClima() {
    return clima;
  }

  public LocalDateTime getVencimiento() {
    return vencimiento;
  }
}
