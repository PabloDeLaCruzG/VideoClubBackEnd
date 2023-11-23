package org.ieschabas.daos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.ieschabas.clases.Equipo;

public class EquipoDao {

    private static final Logger LOGGER = Logger.getLogger(EquipoDao.class);
    private static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String SQL_BUSQUEDA_EQUIPO = "SELECT e FROM Equipo e";
    private static final String SQL_BUSQUEDA_ACTOR = "SELECT e FROM Equipo e WHERE rol = :Actor";
    private static final String SQL_BUSQUEDA_DIRECTOR = "SELECT e FROM Equipo e WHERE rol = :Director";

    private static void setUp() {

        // Indicamos al logger el fichero propiedades
        PropertyConfigurator.configure("src/main/resources/log4.properties");

        try {
            emf = Persistence.createEntityManagerFactory("videoClub");
            em = emf.createEntityManager();
            em.getTransaction().begin();

        } catch (Exception e) {
            LOGGER.error("Error en el método setUp(): " + e.getMessage());
        }
    }

    private static void close() {
        try {
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            LOGGER.error("Error en el método close(): " + e.getMessage());
        }
    }

    public static void guardarEquipo(Equipo equipo) {
        setUp();
        try {

            if (equipo.getId() != 0) {
                equipo = em.merge(equipo);
            }
            em.persist(equipo);

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método guardarEquipo(): " + e.getMessage());
        }
    }

    public static void eliminarEquipo(Equipo equipo) {
        setUp();
        try {

            equipo = em.merge(equipo);
            em.remove(equipo);

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método eliminarEquipo(): " + e.getMessage());
        }
    }

    public static List<Equipo> obtenerActor(String rol) {
        List<Equipo> actores = new ArrayList<>();

        setUp();
        try {

            actores = em.createQuery(SQL_BUSQUEDA_ACTOR, Equipo.class).setParameter("Actor", rol).getResultList();

            if (actores.isEmpty()) {
                LOGGER.info("No hay datos en la tabla equipo");
            } else {
                for (Equipo equipo : actores) {
                    LOGGER.info(equipo.getId() + "--" + equipo.getNombre() + "--" + equipo.getApellidos() + "--"
                            + equipo.getAnyoNac() + "--" + equipo.getPais() + "--" + equipo.getRol());
                }
            }

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método obtenerActor(): " + e.getMessage());
        }

        return actores;
    }

    public static List<Equipo> obtenerDirector(String rol) {
        List<Equipo> directores = new ArrayList<>();

        setUp();
        try {

            directores = em.createQuery(SQL_BUSQUEDA_DIRECTOR, Equipo.class).setParameter("Director", rol).getResultList();

            if (directores.isEmpty()) {
                LOGGER.info("No hay datos en la tabla equipo");
            } else {
                for (Equipo equipo : directores) {
                    LOGGER.info(equipo.getId() + "--" + equipo.getNombre() + "--" + equipo.getApellidos() + "--"
                            + equipo.getAnyoNac() + "--" + equipo.getPais() + "--" + equipo.getRol());
                }
            }

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método obtenerDirector(): " + e.getMessage());
        }

        return directores;
    }

    public static List<Equipo> obtenerEquipo() {
        List<Equipo> equipos = new ArrayList<>();

        setUp();

        try {

            equipos = em.createQuery(SQL_BUSQUEDA_EQUIPO, Equipo.class).getResultList();

            if (equipos.isEmpty()) {
                LOGGER.info("No hay datos en la tabla equipo");
            } else {
                for (Equipo equipo : equipos) {
                    LOGGER.info(equipo.getId() + "--" + equipo.getNombre() + "--" + equipo.getApellidos() + "--"
                            + equipo.getAnyoNac() + "--" + equipo.getPais() + "--" + equipo.getRol());
                }
            }

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método obtenerEquipo(): " + e.getMessage());
        }

        return equipos;
    }

    public static void modificarEquipo(Equipo equipo) {
        setUp();
        try {

            equipo = em.merge(equipo);
            em.persist(equipo);

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método modificarEquipo(): " + e.getMessage());
        }
    }
}