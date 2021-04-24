import java.awt.*;

import static java.util.Objects.requireNonNull;

public class Prenda {
  private Tipo tipo;
  private Material material;
  private Color colorPrincipal;
  private Color colorSecundario;

  public Prenda(Tipo tipo, Material material, Color colorPrincipal, Color colorSecundario) {
    this.tipo = requireNonNull(tipo, "Debe ingresar un tipo");
    this.material = requireNonNull(material, "Debe ingresar un material");
    this.colorPrincipal = requireNonNull(colorPrincipal, "Debe ingresar un color");
    this.colorSecundario = colorSecundario;
  }

  public Categoria getCategoria(){
    return tipo.getCategoria();
  }
}
