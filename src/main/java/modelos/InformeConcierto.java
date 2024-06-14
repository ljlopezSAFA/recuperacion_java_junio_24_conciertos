package modelos;

import lombok.*;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class InformeConcierto {
    private Concierto concierto;
    private Integer numAsistentes;
    private Integer entradasNoVendidas;
    private Double recaudacion;
    private Map<TipoEntrada, Integer> entradasVendidasPorTipo;


}
