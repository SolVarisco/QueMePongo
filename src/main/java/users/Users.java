package users;

import services.AlertaMetoerologica;

import java.util.List;
import java.util.Map;

public class Users {
  private List<User> users;
  public static Users INSTANCE = new Users();

  private Users() {
  }

  public Users getInstance() {
    return INSTANCE;
  }

  public void addUser(User user) {
    users.add(user);
  }

  public void generarSugerenciasDiarias() {
    users.forEach(user -> user.generarSugerenciaDiaria());
  }

  public void gestionarAlertasClimaticas(List<String> ciudades, Map<String, List<AlertaMetoerologica>> alertas) {
    users.stream().filter(user -> ciudades.stream().anyMatch(c -> c.equals(user.getCiudad())))
        .forEach(user -> user.gestionarAlertaMeteorologica(alertas.get(user.getCiudad())));
  }
}
