package notifications;

import clothes.Prenda;
import convinations.Guardarropa;

public class Agregar implements Notificacion{
  private Prenda prenda;

  public Agregar(Prenda prenda) {
    this.prenda = prenda;
  }

  @Override
  public void aceptar(Guardarropa guardarropa) {
    guardarropa.addPrenda(prenda);
  }
}
