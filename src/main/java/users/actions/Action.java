package users.actions;

import services.AlertaMetoerologica;
import users.User;

public interface Action {
  void ejecutar(User user, AlertaMetoerologica alerta);
}
