package services;

import models.EstadoReserva;
import models.Reserva;
import models.Restaurante;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReservaServicio {

    /** * Consulta 1 — Reservas confirmadas ordenadas por fecha
     */
    public List<Reserva> getReservasConfirmadas() {
        EntityManager em = JpaUtil.createEntityManager();
        try {
            return em.createQuery("FROM Reserva r WHERE r.estado = :estado ORDER BY r.fechaReserva ASC", Reserva.class)
                    .setParameter("estado", EstadoReserva.CONFIRMADA)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    /** * Consulta 2 — Reservas de un restaurante concreto
     */
    public List<Reserva> getReservasPorRestaurante(Long restauranteId) {
        EntityManager em = JpaUtil.createEntityManager();
        try {
            return em.createQuery("SELECT r FROM Reserva r JOIN r.mesa m WHERE m.restaurante.id = :restauranteId", Reserva.class)
                    .setParameter("restauranteId", restauranteId)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    /** * Consulta 3 — Reservas pendientes para hoy
     */
    public List<Reserva> getReservasPendientesHoy() {
        EntityManager em = JpaUtil.createEntityManager();
        try {
            return em.createQuery("FROM Reserva r WHERE r.estado = :estado AND r.fechaReserva = :hoy", Reserva.class)
                    .setParameter("estado", EstadoReserva.PENDIENTE)
                    .setParameter("hoy", LocalDate.now())
                    .getResultList();
        } finally {
            em.close();
        }
    }

    /** * Consulta 4 — Recaudación total por restaurante
     */
    //Lo de ordenar me mató, nose porque pero no sale de ninguna manera, y como no me sale pos nada

    /** * Consulta 5 — Restaurante con más mesas
     */
    public Restaurante getRestauranteConMasMesas() {
        EntityManager em = JpaUtil.createEntityManager();
        try {
            return em.createQuery("FROM Restaurante rest ORDER BY SIZE(rest.mesas) DESC", Restaurante.class)
                    .getResultList().stream()
                    .findFirst().orElse(null);
        } finally {
            em.close();
        }
    }

    /** * Consulta 6 — Reservas canceladas o no presentadas
     */
    public List<Reserva> getReservasProblematicas() {
        EntityManager em = JpaUtil.createEntityManager();
        try {
            return em.createQuery("FROM Reserva r WHERE r.estado IN (:estados) ORDER BY r.fechaReserva DESC", Reserva.class)
                    .setParameter("estados", Arrays.asList(EstadoReserva.CANCELADA, EstadoReserva.NO_SHOW))
                    .getResultList();
        } finally {
            em.close();
        }
    }

    /** * Consulta 7 — Número de reservas por ciudad
     */
    public Map<String, Long> getReservasPorCiudad() {
        //Es el unico que he podido sacar y aun asi no se si esta bien, me he ido guiando de tu ejercicio de github
        // de jpa pero literalmente no la comprendía hasta ahora porque no sabia como  coger la ciudad cogiendo tambien la mesa
        // hasta que cai que como tenian una relacion MANYtoONE me salio, esta literalmente es la unica que me ha
        // salido y que mas o menos comprendo..., 4 y 9 IMPOSIBLEE
        EntityManager em = JpaUtil.createEntityManager();
        try {
            List<Object[]> lista = em.createQuery(
                    "SELECT r.mesa.restaurante.ciudad, COUNT(r) " +
                            "FROM Reserva r GROUP BY r.mesa.restaurante.ciudad", Object[].class).getResultList();


            return lista.stream()
                    .collect(Collectors.toMap(
                            x -> (String) x[0],
                            x -> (Long) x[1]
                    ));
        } finally {
            em.close();
        }
    }

    /** * Consulta 8 — Mesas más solicitadas
     */
    //No

    /** * Consulta 9 — Importe medio por reserva según terraza
     */

    //No

    /** * Consulta 10 — Clientes frecuentes
     */
    public List<String> getClientesFrecuentes(int minimoReservas) {
        EntityManager em = JpaUtil.createEntityManager();
        try {
            List<Object[]> lista = em.createQuery("SELECT r.cliente.nombre, COUNT(r) " +
                    "FROM Reserva r GROUP BY r.cliente.nombre", Object[].class).getResultList();

            return lista.stream()
                    .filter(obj -> (Long) obj[1] >= minimoReservas)
                    .map(obj -> (String) obj[0])
                    .distinct()
                    .toList();
        } finally {
            em.close();
        }
    }
}