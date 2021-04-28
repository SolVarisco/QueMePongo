import org.junit.jupiter.api.Test;

import java.awt.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class AtuendosTest {
  @Test
  public void guardarUnBorradorDevuelveUnaPrendaConLosMismosAtributos(){
    assertEquals(polleraBorrador(pollera(), Color.pink, Color.black, Material.ALGODON, Trama.LUNARES).guardarPrenda().getCategoria(), Categoria.INFERIOR);
  }
  @Test
  public void unUniformeEstaCompuestoPorUnaParteSuperiorUnaInferiorYCalzado(){
    assertEquals(uniformeSanJuan().getCalzado().getCategoria(), Categoria.CALZADO);
    assertEquals(uniformeSanJuan().getParteInferior().getCategoria(), Categoria.INFERIOR);
    assertEquals(uniformeSanJuan().getParteSuperior().getCategoria(), Categoria.SUPERIOR);
    assertEquals(uniformeJohnson().getCalzado().getCategoria(), Categoria.CALZADO);
    assertEquals(uniformeJohnson().getParteInferior().getCategoria(), Categoria.INFERIOR);
    assertEquals(uniformeJohnson().getParteSuperior().getCategoria(), Categoria.SUPERIOR);
  }

  private Borrador polleraBorrador(Tipo tipo, Color colorPrincipal, Color colorSecundario, Material material, Trama trama){
    Borrador borrador = new Borrador(tipo);
    borrador.setColorPrincipal(colorPrincipal);
    borrador.setColorSecundario(colorSecundario);
    borrador.setMaterial(material);
    borrador.setTrama(trama);
    return borrador;
  }

  private Tipo pollera(){
    return new Tipo(Categoria.INFERIOR);
  }

  private Prenda chombaVerde(){
    Tipo chomba = new Tipo(Categoria.SUPERIOR);
    return new Prenda(chomba, Material.PIQUE, Color.green, null, null);
  }

  private Tipo pantalon(){
    return new Tipo(Categoria.INFERIOR);
  }

  private Prenda pantalonGris(){
    return new Prenda(pantalon(), Material.ACETATO, Color.gray, null, null);
  }

  private Prenda zapatillasBlancas(){
    Tipo zapatillas = new Tipo(Categoria.CALZADO);
    return new Prenda(zapatillas, Material.CUERO, Color.white, null, null);
  }

  private Uniforme uniformeSanJuan(){
    return new Uniforme(chombaVerde(), pantalonGris(), zapatillasBlancas());
  }

  private Prenda camisaBlanca(){
    Tipo camisa = new Tipo(Categoria.SUPERIOR);
    return new Prenda(camisa, Material.ALGODON, Color.white, null, null);
  }

  private Prenda pantalonNegro(){
    return new Prenda(pantalon(), Material.DEVESTIR, Color.black, null, null);
  }

  private Prenda zapatosNegros(){
    Tipo zapatos = new Tipo(Categoria.CALZADO);
    return new Prenda(zapatos, Material.CUERO, Color.black, null, null);
  }

  private Uniforme uniformeJohnson(){
    return new Uniforme(camisaBlanca(), pantalonNegro(), zapatosNegros());
  }
}
