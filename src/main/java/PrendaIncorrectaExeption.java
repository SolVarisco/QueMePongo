public class PrendaIncorrectaExeption extends RuntimeException{
  public PrendaIncorrectaExeption(String categoriaCargada, String categoriaSolicitada){
    super("La categoría de la prenda cargada es " + categoriaCargada + ", no " + categoriaSolicitada);
  }
}
