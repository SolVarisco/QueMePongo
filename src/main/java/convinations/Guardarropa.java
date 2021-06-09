package convinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import clothes.Categoria;
import com.google.common.collect.Sets;

import clothes.Prenda;
import notifications.Notificacion;
import services.EstadoDelTiempo;

public class Guardarropa {
  EstadoDelTiempo estadoDelTiempo;
  Set<Prenda> prendas;
  List<Notificacion> notificaciones = new ArrayList<>();

  public Guardarropa(EstadoDelTiempo estadoDelTiempo, Set<Prenda> prendas) {
    this.estadoDelTiempo = estadoDelTiempo;
    this.prendas = prendas;
  }

  public List<Notificacion> getNotificaciones() {
    return notificaciones;
  }

  public void addPrenda(Prenda prenda){
    prendas.add(prenda);
  }

  public List<Sugerencia> generarSugerencias(String ciudad){
    int temperatura = estadoDelTiempo.getClima(ciudad).getTemperatura();
    Set<Prenda> prendasInferiores = prendasValidasTipo(Categoria.INFERIOR, temperatura);
    Set<Prenda> prendasSuperiores = prendasValidasTipo(Categoria.SUPERIOR, temperatura);
    Set<Prenda> calzados = prendasValidasTipo(Categoria.CALZADO, temperatura);
    Set<Prenda> accesorios = prendasValidasTipo(Categoria.ACCESORIO, temperatura);
    return Sets.cartesianProduct(prendasSuperiores, prendasInferiores, calzados, accesorios)
        .stream()
        .map((list) -> new Sugerencia(new Uniforme(list.get(0), list.get(1), list.get(2)), list.get(3)))
        .collect(Collectors.toList());
  }

  public Sugerencia sugerenciaPrincipal(String ciudad) {
    return generarSugerencias(ciudad).get(0);
  }

  private Set<Prenda> prendasValidasTipo(Categoria categoria, int temperatura) {
    return prendas.stream()
        .filter(p -> p.getCategoria() == categoria && p.aptaClima(temperatura))
        .collect(Collectors.toSet());
  }

  public void deletePrenda(Prenda prenda) {
    prendas.remove(prenda);
  }

  public void agregarNotificacion(Notificacion notificacion){
    notificaciones.add(notificacion);
  }

  public void aceptarPropuesta(int index){
    notificaciones.get(index).aceptar(this);
    notificaciones.remove(index);
  }

  public void declinarPropuesta(int index){
    notificaciones.remove(index);
  }
}
