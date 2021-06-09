package notifications;

import services.AlertaMetoerologica;

public class NotificacionAlerta {
  private AlertaMetoerologica alerta;

  public NotificacionAlerta(AlertaMetoerologica alerta) {
    this.alerta = alerta;
  }

  public AlertaMetoerologica getAlerta() {
    return alerta;
  }

  public void setAlerta(AlertaMetoerologica alerta) {
    this.alerta = alerta;
  }

  public void getMensaje() {
    alerta.mensaje();
  }
}
