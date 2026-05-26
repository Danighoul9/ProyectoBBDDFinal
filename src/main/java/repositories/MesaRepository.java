package repositories;

import models.Mesa;
import jakarta.persistence.EntityManager;
import utils.JpaUtil;

import java.util.List;

public class MesaRepository extends JpaRepository<Mesa, Long> {

    public MesaRepository() {
        super(Mesa.class);
    }

    /**
     * Devuelve las mesas de un restaurante usando JPQL
     */
    public List<Mesa> buscarPorRestaurante(Long restauranteId) {
        EntityManager em = JpaUtil.createEntityManager();
        try {
            return em.createQuery("SELECT m FROM Mesa m WHERE m.restaurante.id = :restauranteId", Mesa.class)
                    .setParameter("restauranteId", restauranteId)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}