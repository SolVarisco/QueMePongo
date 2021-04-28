import static java.util.Objects.requireNonNull;

public class Uniforme {
  Prenda parteSuperior;
  Prenda parteInferior;
  Prenda calzado;

  Uniforme(Prenda parteSuperior, Prenda parteInferior, Prenda calzado){
    this.parteSuperior = requireNonNull(parteSuperior, "Un uniforme debe contar con una parte superior");
    this.parteInferior = requireNonNull(parteInferior, "Un uniforme debe contar con una parte inferior");
    this.calzado = requireNonNull(calzado, "Un uniforme debe contar con un calzado");
  }

  public void setParteSuperior(Prenda parteSuperior) {
    if(parteSuperior.tipo.getCategoria() != Categoria.SUPERIOR){
      throw new PrendaIncorrectaExeption(parteSuperior.tipo.getCategoria().toString(), "SUPERIOR");
    }
    this.parteSuperior = parteSuperior;
  }

  public void setParteInferior(Prenda parteInferior) {
    if(parteSuperior.tipo.getCategoria() != Categoria.INFERIOR){
      throw new PrendaIncorrectaExeption(parteSuperior.tipo.getCategoria().toString(), "INFERIOR");
    }
    this.parteInferior = parteInferior;
  }

  public void setCalzado(Prenda calzado) {
    if(parteSuperior.tipo.getCategoria() != Categoria.CALZADO){
      throw new PrendaIncorrectaExeption(parteSuperior.tipo.getCategoria().toString(), "CALZADO");
    }
    this.calzado = calzado;
  }

  public Prenda getParteSuperior() {
    return parteSuperior;
  }

  public Prenda getParteInferior() {
    return parteInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }
}
