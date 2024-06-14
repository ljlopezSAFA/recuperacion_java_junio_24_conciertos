package modelos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Entrada {

    private String codigo;
    private TipoEntrada tipoEntrada;
    private Concierto concierto;
    private  Double precio;

}
