package notifications;

import clothes.Prenda;
import convinations.Guardarropa;

public class Eliminar implements Notificacion {
  private Prenda prenda;

  public Eliminar(Prenda prenda) {
    this.prenda = prenda;
  }

  @Override
  public void aceptar(Guardarropa guardarropa) {
    guardarropa.deletePrenda(prenda);
  }
}
