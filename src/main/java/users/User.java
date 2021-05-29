package users;

import convinations.Guardarropa;
import notifications.Notificacion;

import java.util.Collection;
import java.util.List;

public class User {
  private Collection<Guardarropa> guardarropas;

  public User(Collection<Guardarropa> guardarropas) {
    this.guardarropas = guardarropas;
  }

  public void addGuardarropa(Guardarropa guardarropa){
    guardarropas.add(guardarropa);
  }

/*  public List<Notificacion> verNotificacionesDe(Guardarropa guardarropa){
    return guardarropa.getNotificaciones();
  }

  public void aceptarPropuestaNotificacion(Guardarropa guardarropa, int index){
    guardarropa.aceptarPropuesta(index);
  }

  public void declinarPropuestaNotificacion(Guardarropa guardarropa, int index){
    guardarropa.declinarPropuesta(index);
  } */
}
