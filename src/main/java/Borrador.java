import java.awt.*;

import static java.util.Objects.requireNonNull;

public class Borrador {
  Tipo tipo;
  Material material;
  Color colorPrincipal;
  Color colorSecundario;
  Trama trama;

  Borrador(Tipo tipo){
    this.tipo = requireNonNull(tipo, "Debe ingresar un tipo");
  }

  public void setMaterial(Material material) {
    this.material = material;
  }

  public void setColorPrincipal(Color colorPrincipal) {
    this.colorPrincipal = colorPrincipal;
  }

  public void setColorSecundario(Color colorSecundario) {
    this.colorSecundario = colorSecundario;
  }

  public void setTrama(Trama trama) {
    this.trama = trama;
  }

  public void guardarPrenda(){
    new Prenda(tipo, material, colorPrincipal, colorSecundario, trama);
  }
}
