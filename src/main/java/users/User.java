package users;

import convinations.Guardarropa;
import convinations.Sugerencia;
import notifications.NotificacionAlerta;
import services.AlertaMetoerologica;
import users.actions.Action;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class User {
  private String mail;
  private List<Guardarropa> guardarropas;
  private int indexGuardarropaPreferido;
  private Sugerencia sugerenciaDia;
  private String ciudad;
  private List<NotificacionAlerta> alertasMeteorologicas = new ArrayList<>();
  private Set<Action> actions;

  public User(String mail, List<Guardarropa> guardarropas, int indexGuardarropaPreferido,
              String ciudad, Set<Action> actions) {
    this.mail = mail;
    this.guardarropas = guardarropas;
    this.indexGuardarropaPreferido = indexGuardarropaPreferido;
    this.ciudad = ciudad;
    this.actions = actions;
  }

  public String getMail() {
    return mail;
  }

  public String getCiudad() {
    return ciudad;
  }

  public Set<Action> getActions() {
    return actions;
  }

  public void setActions(Set<Action> actions) {
    this.actions = actions;
  }

  public void addAlerta(NotificacionAlerta alerta) {
    alertasMeteorologicas.add(alerta);
  }

  public int getIndexGuardarropaPreferido() {
    return indexGuardarropaPreferido;
  }

  public void setIndexGuardarropaPreferido(int indexGuardarropaPreferido) {
    this.indexGuardarropaPreferido = indexGuardarropaPreferido;
  }

  public void addGuardarropa(Guardarropa guardarropa){
    guardarropas.add(guardarropa);
  }

  public void generarSugerenciaDiaria() {
    sugerenciaDia = guardarropas.get(indexGuardarropaPreferido).sugerenciaPrincipal(ciudad);
  }

  public void gestionarAlertaMeteorologica(List<AlertaMetoerologica> alertas) {
    alertas.forEach(alerta -> actions.forEach(action -> action.ejecutar(this, alerta)));
  }
}
