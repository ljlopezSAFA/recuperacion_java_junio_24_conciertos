package modelos;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Asistente {
    private String nombre;
    private String apellidos;
    private String dni;
    private LocalDate fechaNacimiento;
    private Entrada entrada;
}
