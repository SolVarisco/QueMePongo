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
  Set<Prenda> prendasSuperiores;
  Set<Prenda> prendasInferiores;
  Set<Prenda> calzados;
  Set<Prenda> accesorios;
  List<Notificacion> notificaciones = new ArrayList<>();

  public Guardarropa(EstadoDelTiempo estadoDelTiempo, Set<Prenda> prendasSuperiores, Set<Prenda> prendasInferiores, Set<Prenda> calzados, Set<Prenda> accesorios) {
    this.estadoDelTiempo = estadoDelTiempo;
    this.prendasSuperiores = prendasSuperiores;
    this.prendasInferiores = prendasInferiores;
    this.calzados = calzados;
    this.accesorios = accesorios;
  }

  public List<Notificacion> getNotificaciones() {
    return notificaciones;
  }

  public void addPrenda(Prenda prenda){
    Categoria categoria = prenda.getTipo().getCategoria();
    if(categoria.equals(Categoria.SUPERIOR)){
      prendasSuperiores.add(prenda);
    } else if (categoria.equals(Categoria.INFERIOR)){
      prendasInferiores.add(prenda);
    } else if (categoria.equals((Categoria.CALZADO))){
      calzados.add(prenda);
    } else {
      accesorios.add(prenda);
    }
  }

  public List<Sugerencia> generarSugerencias(String ciudad){
    int temperatura = estadoDelTiempo.getClima(ciudad).getTemperatura();
    Set<Prenda> prendasSuperioresValidas = getPrendasValidas(temperatura, prendasSuperiores);
    Set<Prenda> prendasInferioresValidas = getPrendasValidas(temperatura, prendasInferiores);
    Set<Prenda> calzadosValidos = getPrendasValidas(temperatura, calzados);
    Set<Prenda> accesoriosValidos = getPrendasValidas(temperatura, accesorios);
    return Sets.cartesianProduct(prendasSuperioresValidas, prendasInferioresValidas, calzadosValidos, accesoriosValidos)
        .stream()
        .map((list) -> new Sugerencia(new Uniforme(list.get(0), list.get(1), list.get(2)), list.get(3)))
        .collect(Collectors.toList());
  }

  private Set<Prenda> getPrendasValidas(int temperatura, Set<Prenda> prendas) {
    return prendas.stream().filter(p -> p.aptaClima(temperatura)).collect(Collectors.toSet());
  }

  public void deletePrenda(Prenda prenda) {
    Categoria categoria = prenda.getTipo().getCategoria();
    if(categoria.equals(Categoria.SUPERIOR)){
      prendasSuperiores.remove(prenda);
    } else if (categoria.equals(Categoria.INFERIOR)){
      prendasInferiores.remove(prenda);
    } else if (categoria.equals((Categoria.CALZADO))){
      calzados.remove(prenda);
    } else {
      accesorios.remove(prenda);
    }
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
