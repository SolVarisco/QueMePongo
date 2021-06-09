package users.actions;

import notifications.NotificacionAlerta;
import services.AlertaMetoerologica;
import users.User;

public class NotificadorAlertas implements Action{
  @Override
  public void ejecutar(User user, AlertaMetoerologica alerta) {
    user.addAlerta(new NotificacionAlerta(alerta));
  }
}
