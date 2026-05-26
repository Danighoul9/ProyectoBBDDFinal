package models;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_reserva", nullable = false)
    private LocalDate fechaReserva;

    @Column(name = "hora_reserva",nullable = false)
    private LocalTime horaReserva;

    @Column(name = "num_personas",nullable = false)
    private int numPersonas;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    @Column(name = "importe_estimado",nullable = false)
    private double importeEstimado;

    @ManyToOne
    @JoinColumn(name = "mesa_id")
    @ToString.Exclude
    private Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @ToString.Exclude
    private Cliente cliente;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("ID: ").append(id);
        sb.append(" | ").append(fechaReserva).append(" ").append(horaReserva);
        sb.append(" | ").append(numPersonas).append(" personas");
        sb.append(" | ").append(estado);
        sb.append(" | ").append(importeEstimado).append("€");
        sb.append(" | ").append(cliente.getNombre());
        sb.append(" | ").append("Mesa: ").append(mesa.getNumero());
        return sb.toString();
    }
}