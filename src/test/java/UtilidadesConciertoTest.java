import modelos.*;
import org.junit.jupiter.api.Test;
import utilidades.UtilidadesConcierto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class UtilidadesConciertoTest {

    @Test
    public void testGetGruposConEstiloMusical() {
        // Crear datos de prueba
        Grupo grupo1 = new Grupo("Grupo1", 4, Arrays.asList(TipoMusica.ROCK, TipoMusica.JAZZ), LocalDate.of(2000, 1, 1));
        Grupo grupo2 = new Grupo("Grupo2", 5, Arrays.asList(TipoMusica.POP, TipoMusica.SOUL), LocalDate.of(2005, 1, 1));
        Grupo grupo3 = new Grupo("Grupo3", 3, Arrays.asList(TipoMusica.FLAMENCO, TipoMusica.ROCK), LocalDate.of(2010, 1, 1));

        List<Grupo> grupos = Arrays.asList(grupo1, grupo2, grupo3);

        // Test
        List<Grupo> result = UtilidadesConcierto.getGruposConEstiloMusical(grupos, TipoMusica.ROCK);
        assertEquals(2, result.size());
        assertTrue(result.contains(grupo1));
        assertTrue(result.contains(grupo3));

        result = UtilidadesConcierto.getGruposConEstiloMusical(grupos, TipoMusica.POP);
        assertEquals(1, result.size());
        assertTrue(result.contains(grupo2));
    }


    @Test
    public void testGetAsistentesPorTipoEntrada() {
        // Crear datos de prueba
        Concierto concierto = new Concierto();
        Asistente asistente1 = new Asistente("Nombre1", "Apellido1", "DNI1", LocalDate.of(1990, 1, 1), new Entrada("codigo1", TipoEntrada.PISTA, concierto, 50.0));
        Asistente asistente2 = new Asistente("Nombre2", "Apellido2", "DNI2", LocalDate.of(1995, 1, 1), new Entrada("codigo2", TipoEntrada.GRADA_BAJA, concierto, 60.0));
        Asistente asistente3 = new Asistente("Nombre3", "Apellido3", "DNI3", LocalDate.of(1985, 1, 1), new Entrada("codigo3", TipoEntrada.PISTA, concierto, 50.0));

        concierto.setAsistentes(Arrays.asList(asistente1, asistente2, asistente3));

        // Test
        Map<TipoEntrada, List<Asistente>> result = UtilidadesConcierto.getAsistentesPorTipoEntrada(concierto);
        assertEquals(2, result.size());
        assertEquals(2, result.get(TipoEntrada.PISTA).size());
        assertEquals(1, result.get(TipoEntrada.GRADA_BAJA).size());
        assertTrue(result.get(TipoEntrada.PISTA).contains(asistente1));
        assertTrue(result.get(TipoEntrada.PISTA).contains(asistente3));
        assertTrue(result.get(TipoEntrada.GRADA_BAJA).contains(asistente2));
    }


    @Test
    public void testGetMediaEdadConcierto() {
        // Crear datos de prueba
        Concierto concierto = new Concierto();
        Asistente asistente1 = new Asistente("Nombre1", "Apellido1", "DNI1", LocalDate.of(1990, 1, 1), null);
        Asistente asistente2 = new Asistente("Nombre2", "Apellido2", "DNI2", LocalDate.of(1995, 1, 1), null);
        Asistente asistente3 = new Asistente("Nombre3", "Apellido3", "DNI3", LocalDate.of(1985, 1, 1), null);

        concierto.setAsistentes(Arrays.asList(asistente1, asistente2, asistente3));

        // Test
        Integer result = UtilidadesConcierto.getMediaEdadConcierto(concierto);
        int expected = 34;

        assertEquals(expected, result);
    }


    @Test
    public void testEntradasCorrectas() {
        // Crear datos de prueba
        Concierto concierto = new Concierto();
        Map<TipoEntrada, Double> precioEntradas = new HashMap<>();
        precioEntradas.put(TipoEntrada.PISTA, 50.0);
        precioEntradas.put(TipoEntrada.GRADA_BAJA, 60.0);
        concierto.setPrecioEntradas(precioEntradas);

        Map<TipoEntrada, Integer> numEntradasPorTipo = new HashMap<>();
        numEntradasPorTipo.put(TipoEntrada.PISTA, 2);
        numEntradasPorTipo.put(TipoEntrada.GRADA_BAJA, 1);
        concierto.setNumEntradasPorTipo(numEntradasPorTipo);

        Asistente asistente1 = new Asistente("Nombre1", "Apellido1", "DNI1", LocalDate.of(1990, 1, 1), new Entrada("codigo1", TipoEntrada.PISTA, concierto, 50.0));
        Asistente asistente2 = new Asistente("Nombre2", "Apellido2", "DNI2", LocalDate.of(1995, 1, 1), new Entrada("codigo2", TipoEntrada.GRADA_BAJA, concierto, 60.0));
        Asistente asistente3 = new Asistente("Nombre3", "Apellido3", "DNI3", LocalDate.of(1985, 1, 1), new Entrada("codigo3", TipoEntrada.PISTA, concierto, 50.0));

        concierto.setAsistentes(Arrays.asList(asistente1, asistente2, asistente3));

        // Test
        assertTrue(UtilidadesConcierto.entradasCorrectas(concierto));

        // Test con precio incorrecto
        asistente3.getEntrada().setPrecio(55.0);
        assertFalse(UtilidadesConcierto.entradasCorrectas(concierto));

        // Test con cantidad de entradas incorrecta
        asistente3.getEntrada().setPrecio(50.0);
        concierto.getAsistentes().add(new Asistente("Nombre4", "Apellido4", "DNI4", LocalDate.of(2000, 1, 1), new Entrada("codigo4", TipoEntrada.PISTA, concierto, 50.0)));
        assertFalse(UtilidadesConcierto.entradasCorrectas(concierto));
    }



    @Test
    public void testGetInformeConcierto() {
        // Crear datos de prueba
        Concierto concierto = new Concierto();
        concierto.setLugar(new Lugar("Lugar1", "Direccion1", "Ciudad1", 12345, "Provincia1", 100));

        Asistente asistente1 = new Asistente("Nombre1", "Apellido1", "DNI1", LocalDate.of(1990, 1, 1), new Entrada("codigo1", TipoEntrada.PISTA, concierto, 50.0));
        Asistente asistente2 = new Asistente("Nombre2", "Apellido2", "DNI2", LocalDate.of(1995, 1, 1), new Entrada("codigo2", TipoEntrada.GRADA_BAJA, concierto, 60.0));
        Asistente asistente3 = new Asistente("Nombre3", "Apellido3", "DNI3", LocalDate.of(1985, 1, 1), new Entrada("codigo3", TipoEntrada.PISTA, concierto, 50.0));

        concierto.setAsistentes(Arrays.asList(asistente1, asistente2, asistente3));

        // Test
        InformeConcierto informe = UtilidadesConcierto.getInformeConcierto(concierto);

        assertEquals(concierto, informe.getConcierto());
        assertEquals(3, informe.getNumAsistentes());
        assertEquals(97, informe.getEntradasNoVendidas());
        assertEquals(160.0, informe.getRecaudacion());

        Map<TipoEntrada, Integer> entradasVendidasPorTipo = new HashMap<>();
        entradasVendidasPorTipo.put(TipoEntrada.PISTA, 2);
        entradasVendidasPorTipo.put(TipoEntrada.GRADA_BAJA, 1);
        assertEquals(entradasVendidasPorTipo, informe.getEntradasVendidasPorTipo());
    }


}
