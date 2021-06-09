package services;

import users.Users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReporteAlertas {
  private Pronostico servicio;
  private Map<String, List<AlertaMetoerologica>> alertas = new HashMap<>();

  public ReporteAlertas(Pronostico servicio) {
    this.servicio = servicio;
  }

  public List<AlertaMetoerologica> obtenerAlerta(String ciudad) {
    return alertas.get(ciudad);
  }

  public void actualizarAlertas(List<String> ciudades) {
    List<String> ciudadesConAlertas = new ArrayList<>();

    ciudades.forEach(ciudad -> {
      alertas.remove(ciudad);
      List<String> alertasCiudad = servicio.obternerAlerta(ciudad);
      List<AlertaMetoerologica> alertasMeteorologicasCiudad = new ArrayList<>();

      alertasCiudad.forEach(alerta -> {
        String alert = alerta.toUpperCase();
        if(alert.equals("LLUVIA") || alert.equals("STORM")) {
          alertasMeteorologicasCiudad.add(AlertaMetoerologica.LLUVIA);
        }
        if(alert.equals("GRANIZO") || alert.equals("HAIL")) {
          alertasMeteorologicasCiudad.add(AlertaMetoerologica.GRANIZO);
        }
      });

      if (!alertasMeteorologicasCiudad.isEmpty()) {
        ciudadesConAlertas.add(ciudad);
        alertas.put(ciudad, alertasMeteorologicasCiudad);
      }
    });
    Users.INSTANCE.gestionarAlertasClimaticas(ciudadesConAlertas, alertas);
  }
}
