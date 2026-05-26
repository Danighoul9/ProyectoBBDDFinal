package repositories;

import models.EstadoReserva;
import models.Reserva;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

import java.util.List;

public class ReservaRepository extends JpaRepository<Reserva, Long> {

    public ReservaRepository() {
        super(Reserva.class);
    }

    // CONSULTAS PERSONALIZADAS (JPQL)

    public List<Reserva> buscarPorEstado(EstadoReserva estado) {
        EntityManager em = JpaUtil.createEntityManager();
        try {
            return em.createQuery("SELECT r FROM Reserva r WHERE r.estado = :estado", Reserva.class)
                    .setParameter("estado", estado)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public List<Reserva> buscarPorCliente(Long clienteId) {
        EntityManager em = JpaUtil.createEntityManager();
        try {
            return em.createQuery("SELECT r FROM Reserva r WHERE r.cliente.id = :clienteId", Reserva.class)
                    .setParameter("clienteId", clienteId)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
