package convinations;

import clothes.Prenda;

import static java.util.Objects.requireNonNull;

public class Sugerencia {
  private Uniforme prendasPrincipales;
  private Prenda accesorio;

  Sugerencia(Uniforme prendasPrincipales, Prenda accesorio){
    this.prendasPrincipales = requireNonNull(prendasPrincipales, "Un atuendo no puede contar solo con accesorios");
    this.accesorio = requireNonNull(accesorio, "Un atuendo debe contar con un accesorio");
  }
}
