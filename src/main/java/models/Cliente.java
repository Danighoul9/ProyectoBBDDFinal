package models;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "clientes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefono;

    @Column(nullable = false)
    private boolean vip;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Reserva> reservas;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer();
        sb.append("ID: ").append(id);
        sb.append(" | ").append(nombre);
        sb.append(" | ").append(email);
        sb.append(" | ").append(telefono);
        sb.append(" | ").append(vip);
        return sb.toString();
    }
}