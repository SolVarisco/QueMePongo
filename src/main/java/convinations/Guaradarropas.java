package convinations;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import clothes.Prenda;
import com.google.common.collect.Sets;
import services.Pronostico;

public class Guaradarropas {
  Set<Prenda> prendasSuperiores;
  Set<Prenda> prendasInferiores;
  Set<Prenda> calzados;
  Set<Prenda> accesorios;

  public Guaradarropas(Set<Prenda> prendasSuperiores, Set<Prenda> prendasInferiores, Set<Prenda> calzados, Set<Prenda> accesorios) {
    this.prendasSuperiores = prendasSuperiores;
    this.prendasInferiores = prendasInferiores;
    this.calzados = calzados;
    this.accesorios = accesorios;
  }

  public void addPrendaSuperior(Prenda prenda){
    prendasSuperiores.add(prenda);
  }

  public void addPrendaInferior(Prenda prenda){
    prendasInferiores.add(prenda);
  }

  public void addCazado(Prenda calzado){
    calzados.add(calzado);
  }

  public void addAccesorio(Prenda accesorio){
    calzados.add(accesorio);
  }

  public List<Sugerencia> generarSugerencias(String ciudad){
    HashMap<String, Object> clima = (HashMap<String, Object>) Pronostico.instance().consultarClima(ciudad, LocalDateTime.now().plusHours(4)).get(0).get("Temperature");
    int temperatura = (int) clima.get("Value");
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

}
