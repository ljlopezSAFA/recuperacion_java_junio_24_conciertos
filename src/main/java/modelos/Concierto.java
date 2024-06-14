package modelos;

import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"grupo", "lugar", "precioEntradas","numEntradasPorTipo", "asistentes"})
@ToString(exclude = {"grupo", "lugar", "precioEntradas", "numEntradasPorTipo", "asistentes"})
public class Concierto {

    private LocalDate fecha;
    private Grupo grupo;
    private Lugar lugar;
    private Map<TipoEntrada, Double> precioEntradas;
    private Map<TipoEntrada, Integer> numEntradasPorTipo;
    private List<Asistente> asistentes;

}
