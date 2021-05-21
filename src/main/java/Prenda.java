import java.awt.*;

import static java.util.Objects.isNull;
import static java.util.Objects.requireNonNull;

public class Prenda {
  Tipo tipo;
  Material material;
  Color colorPrincipal;
  Color colorSecundario;
  Trama trama;
  private int temperaturaLimite;

  public Prenda(Tipo tipo, Material material, Color colorPrincipal, Color colorSecundario, Trama trama, int temperaturaLimite) {
    this.tipo = requireNonNull(tipo, "Debe ingresar un tipo");
    this.material = requireNonNull(material, "Debe ingresar un material");
    this.colorPrincipal = requireNonNull(colorPrincipal, "Debe ingresar un color");
    this.colorSecundario = colorSecundario;
    this.temperaturaLimite = temperaturaLimite;
    if(isNull(trama)){
      this.trama = Trama.LISA;
    } else {
      this.trama = trama;
    }
  }


  public Categoria getCategoria(){
    return tipo.getCategoria();
  }

  public boolean aptaClima(int temperatura) {
    return temperatura < temperaturaLimite;
  }
}
