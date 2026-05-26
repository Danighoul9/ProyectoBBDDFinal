package models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "mesas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int numero;
    @Column(nullable = false)
    private int capacidad;

    @Column(nullable = false)
    private boolean terraza;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    @ToString.Exclude
    private Restaurante restaurante;

    @OneToMany(mappedBy = "mesa", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Reserva> reservas;


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("ID: ").append(id);
        sb.append(" | ").append(numero);
        sb.append(" | ").append(capacidad);
        sb.append(" | ").append(terraza);
        sb.append(" | ").append(restaurante);
        sb.append(" | ").append(reservas);
        return sb.toString();
    }
}