import java.awt.*;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

public class Prenda {
  Tipo tipo;
  Material material;
  Color colorPrincipal;
  Color colorSecundario;
  Trama trama;

  public Prenda(Tipo tipo, Material material, Color colorPrincipal, Color colorSecundario, Trama trama) {
    this.tipo = requireNonNull(tipo, "Debe ingresar un tipo");
    this.material = requireNonNull(material, "Debe ingresar un material");
    this.colorPrincipal = requireNonNull(colorPrincipal, "Debe ingresar un color");
    this.colorSecundario = colorSecundario;
    if(isNull(trama)){
      this.trama = Trama.LISA;
    } else {
      this.trama = trama;
    }
  }

  public Categoria getCategoria(){
    return tipo.getCategoria();
  }
}
