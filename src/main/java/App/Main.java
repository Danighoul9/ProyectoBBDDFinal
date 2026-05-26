package App;

import models.*;
import repositories.*;
import services.ReservaServicio;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        IO.println("Iniciando app Sistema de Gestión de Reservas de Restaurante");

        /*
        RestauranteRepository restauranteRepository = new RestauranteRepository();
        MesaRepository mr = new MesaRepository();
        ClienteRepository cr = new ClienteRepository();
        ReservaRepository rr = new ReservaRepository();


        // 1. RESTAURANTES
        restauranteRepository.save(new Restaurante(null, "Ichiraku Ramen", "Konoha",
                "Avenida del Séptimo Hokage 7", "954000100", new ArrayList<>()));
        restauranteRepository.save(new Restaurante(null, "Baratie Ocean Restaurant", "East Blue",
                "Ruta Marítima Grand Line", "915000222", new ArrayList<>()));

        Restaurante r1 = restauranteRepository.findById(1L).orElse(null);
        Restaurante r2 = restauranteRepository.findById(2L).orElse(null);

        // 2.MESAS
        // Mesas de Ichiraku Ramen (ID 1 al 6)
        mr.save(new Mesa(null, 1, 4, false, r1, new ArrayList<>()));
        mr.save(new Mesa(null, 2, 4, true, r1, new ArrayList<>()));
        mr.save(new Mesa(null, 3, 2, false, r1, new ArrayList<>()));
        mr.save(new Mesa(null, 4, 6, true, r1, new ArrayList<>()));
        mr.save(new Mesa(null, 5, 2, false, r1, new ArrayList<>()));
        mr.save(new Mesa(null, 6, 8, true, r1, new ArrayList<>()));

        // Mesas del Baratie (ID 7 al 12)
        mr.save(new Mesa(null, 1, 2, false, r2, new ArrayList<>()));
        mr.save(new Mesa(null, 2, 4, true, r2, new ArrayList<>()));
        mr.save(new Mesa(null, 3, 4, false, r2, new ArrayList<>()));
        mr.save(new Mesa(null, 4, 6, true, r2, new ArrayList<>()));
        mr.save(new Mesa(null, 5, 2, false, r2, new ArrayList<>()));
        mr.save(new Mesa(null, 6, 10, true, r2, new ArrayList<>()));

        // 3. INSERTAR 10 CLIENTES
        cr.save(new Cliente(null, "Goku", "goku.saiyan@email.com", "600112233", false, new ArrayList<>()));
        cr.save(new Cliente(null, "Kakashi Hatake", "kakashiH@email.com", "600445566", true, new ArrayList<>()));
        cr.save(new Cliente(null, "Luffy", "pirateking@email.com", "611223344", false, new ArrayList<>()));
        cr.save(new Cliente(null, "Naruto Uzumaki", "ramenlover@email.com", "622334455", true, new ArrayList<>()));
        cr.save(new Cliente(null, "Zoro Roronoa", "marimo@email.com", "633445566", false, new ArrayList<>()));
        cr.save(new Cliente(null, "Vegeta", "prince.saiyan@email.com", "644556677", true, new ArrayList<>()));
        cr.save(new Cliente(null, "Sakura Haruno", "sakura@email.com", "655667788", false, new ArrayList<>()));
        cr.save(new Cliente(null, "Sanji Vinsmoke", "allblue@email.com", "666778899", true, new ArrayList<>()));
        cr.save(new Cliente(null, "Bulma", "capsulecorp@email.com", "677889900", true, new ArrayList<>()));
        cr.save(new Cliente(null, "Chopper", "cottoncandy@email.com", "688990011", false, new ArrayList<>()));

        // MESAS Y CLIENTES

        Mesa m1 = mr.findById(1L).orElse(null);
        Mesa m2 = mr.findById(2L).orElse(null);
        Mesa m3 = mr.findById(3L).orElse(null);
        Mesa m4 = mr.findById(4L).orElse(null);
        Mesa m5 = mr.findById(5L).orElse(null);
        Mesa m6 = mr.findById(6L).orElse(null);
        Mesa m7 = mr.findById(7L).orElse(null);
        Mesa m8 = mr.findById(8L).orElse(null);
        Mesa m9 = mr.findById(9L).orElse(null);
        Mesa m10 = mr.findById(10L).orElse(null);
        Mesa m11 = mr.findById(11L).orElse(null);
        Mesa m12 = mr.findById(12L).orElse(null);

        Cliente c1 = cr.findById(1L).orElse(null);
        Cliente c2 = cr.findById(2L).orElse(null);
        Cliente c3 = cr.findById(3L).orElse(null);
        Cliente c4 = cr.findById(4L).orElse(null);
        Cliente c5 = cr.findById(5L).orElse(null);
        Cliente c6 = cr.findById(6L).orElse(null);
        Cliente c7 = cr.findById(7L).orElse(null);
        Cliente c8 = cr.findById(8L).orElse(null);
        Cliente c9 = cr.findById(9L).orElse(null);
        Cliente c10 = cr.findById(10L).orElse(null);

        // 4. 30 RESERVAS CON MEZCLA DE ESTADOS
        rr.save(new Reserva(null, LocalDate.now(), LocalTime.of(14,0), 3, EstadoReserva.CONFIRMADA, 45.0, m1, c1));
        rr.save(new Reserva(null, LocalDate.now(), LocalTime.of(15,30), 2, EstadoReserva.PENDIENTE, 30.0, m2, c1));
        rr.save(new Reserva(null, LocalDate.now(), LocalTime.of(21,0), 2, EstadoReserva.PENDIENTE, 25.0, m5, c3));
        rr.save(new Reserva(null, LocalDate.now(), LocalTime.of(22,15), 4, EstadoReserva.CONFIRMADA, 80.0, m6, c4));
        rr.save(new Reserva(null, LocalDate.now(), LocalTime.of(13,45), 5, EstadoReserva.PENDIENTE, 95.0, m4, c6));
        rr.save(new Reserva(null, LocalDate.now(), LocalTime.of(20,30), 2, EstadoReserva.PENDIENTE, 40.0, m7, c8));
        rr.save(new Reserva(null, LocalDate.now().minusDays(2), LocalTime.of(14,30), 4, EstadoReserva.CANCELADA, 60.0, m1, c2));
        rr.save(new Reserva(null, LocalDate.now().minusDays(1), LocalTime.of(21,30), 2, EstadoReserva.NO_SHOW, 35.0, m2, c2));
        rr.save(new Reserva(null, LocalDate.now().minusDays(3), LocalTime.of(22,0), 6, EstadoReserva.CANCELADA, 120.0, m4, c5));
        rr.save(new Reserva(null, LocalDate.now().minusDays(5), LocalTime.of(15,0), 3, EstadoReserva.NO_SHOW, 55.0, m3, c7));
        rr.save(new Reserva(null, LocalDate.now().minusDays(1), LocalTime.of(13,0), 2, EstadoReserva.CANCELADA, 30.0, m8, c9));
        rr.save(new Reserva(null, LocalDate.now().minusDays(4), LocalTime.of(21,0), 4, EstadoReserva.NO_SHOW, 90.0, m10, c1));
        rr.save(new Reserva(null, LocalDate.now().plusDays(1), LocalTime.of(14,0), 4, EstadoReserva.CONFIRMADA, 70.0, m3, c3));
        rr.save(new Reserva(null, LocalDate.now().plusDays(2), LocalTime.of(21,30), 2, EstadoReserva.CONFIRMADA, 50.0, m7, c4));
        rr.save(new Reserva(null, LocalDate.now().plusDays(3), LocalTime.of(22,0), 3, EstadoReserva.CONFIRMADA, 65.0, m8, c5));
        rr.save(new Reserva(null, LocalDate.now().plusDays(1), LocalTime.of(15,0), 6, EstadoReserva.CONFIRMADA, 150.0, m12, c6));
        rr.save(new Reserva(null, LocalDate.now().plusDays(5), LocalTime.of(14,15), 4, EstadoReserva.CONFIRMADA, 85.0, m9, c7));
        rr.save(new Reserva(null, LocalDate.now().plusDays(2), LocalTime.of(20,45), 2, EstadoReserva.CONFIRMADA, 40.0, m11, c9));
        rr.save(new Reserva(null, LocalDate.now().plusDays(4), LocalTime.of(13,30), 5, EstadoReserva.CONFIRMADA, 110.0, m4, c10));
        rr.save(new Reserva(null, LocalDate.now().plusDays(1), LocalTime.of(21,15), 2, EstadoReserva.CONFIRMADA, 45.0, m1, c8));
        rr.save(new Reserva(null, LocalDate.now().plusDays(6), LocalTime.of(14,0), 3, EstadoReserva.CONFIRMADA, 55.0, m1, c4));
        rr.save(new Reserva(null, LocalDate.now().plusDays(7), LocalTime.of(21,0), 2, EstadoReserva.CONFIRMADA, 40.0, m1, c6));
        rr.save(new Reserva(null, LocalDate.now().plusDays(3), LocalTime.of(20,0), 4, EstadoReserva.CONFIRMADA, 85.0, m3, c4));
        rr.save(new Reserva(null, LocalDate.now().plusDays(2), LocalTime.of(15,0), 2, EstadoReserva.CONFIRMADA, 35.0, m3, c1));
        rr.save(new Reserva(null, LocalDate.now().plusDays(8), LocalTime.of(22,30), 5, EstadoReserva.CONFIRMADA, 130.0, m12, c9));
        rr.save(new Reserva(null, LocalDate.now().plusDays(9), LocalTime.of(14,30), 2, EstadoReserva.CONFIRMADA, 40.0, m12, c9));
        rr.save(new Reserva(null, LocalDate.now().plusDays(1), LocalTime.of(21,0), 4, EstadoReserva.CONFIRMADA, 95.0, m6, c2));
        rr.save(new Reserva(null, LocalDate.now().plusDays(2), LocalTime.of(13,15), 3, EstadoReserva.CONFIRMADA, 60.0, m10, c10));
        rr.save(new Reserva(null, LocalDate.now().plusDays(3), LocalTime.of(20,30), 2, EstadoReserva.CONFIRMADA, 45.0, m2, c6));
        rr.save(new Reserva(null, LocalDate.now().plusDays(4), LocalTime.of(14,0), 4, EstadoReserva.CONFIRMADA, 75.0, m9, c5));
         */

        ReservaServicio rs = new ReservaServicio();

        // ==================== EJECUCIÓN DE LAS CONSULTAS ====================
        IO.println("\n1. Reservas confirmadas ordenadas por fecha:");
        rs.getReservasConfirmadas().forEach(System.out::println);

        IO.println("\n2. Reservas de un restaurante concreto (ID 1):");
        rs.getReservasPorRestaurante(1L).forEach(System.out::println);

        IO.println("\n3. Reservas pendientes para hoy:");
        rs.getReservasPendientesHoy().forEach(System.out::println);

        /*IO.println("4. Recaudación total por restaurante:");*/

        IO.println("\n5. Restaurante con más mesas:");
        IO.println(rs.getRestauranteConMasMesas());

        IO.println("\n6. Reservas canceladas o no presentadas:");
        rs.getReservasProblematicas().forEach(System.out::println);

        IO.println("\n7. Número de reservas por ciudad:");
        rs.getReservasPorCiudad().forEach((k, v) -> IO.println(k + " -> " + v + "reservas"));

        /*IO.println("8. Mesas más solicitadas:");*/

        /*IO.println("9. Importe medio por reserva según terraza:");*/

        IO.println("\n10. Clientes frecuentes:");
        rs.getClientesFrecuentes(2).forEach(System.out::println);
    }
}