package repositories;

import models.Restaurante;

public class RestauranteRepository extends JpaRepository<Restaurante, Long> {
    public RestauranteRepository() {
        super(Restaurante.class);
    }
}
