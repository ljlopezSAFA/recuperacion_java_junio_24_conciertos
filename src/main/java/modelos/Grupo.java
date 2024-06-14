package modelos;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Grupo {
    private String nombre;
    private Integer numComponentes;
    private List<TipoMusica> tiposMusica;
    private LocalDate fechaFundacion;

}
