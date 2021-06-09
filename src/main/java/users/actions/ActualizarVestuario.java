package users.actions;

import services.AlertaMetoerologica;
import users.User;

public class ActualizarVestuario implements Action{

  @Override
  public void ejecutar(User user, AlertaMetoerologica alerta) {
    user.generarSugerenciaDiaria();
  }
}
