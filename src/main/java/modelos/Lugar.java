package modelos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Lugar {
    private  String nombre;
    private String direccion;
    private String ciudad;
    private Integer codigoPostal;
    private String provincia;
    private Integer aforo;
}
