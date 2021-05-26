package users;

import convinations.Guaradarropas;

import java.util.Set;

public class User {
  private Set<Guaradarropas> conjuntoGuardarropas;

  public User(Set<Guaradarropas> conjuntoGuardarropas) {
    this.conjuntoGuardarropas = conjuntoGuardarropas;
  }

  public void addGuardarropa(Guaradarropas guardarropa){
    conjuntoGuardarropas.add(guardarropa);
  }
}
