package org.ieschabas.daos;

import org.apache.log4j.PropertyConfigurator;
import org.ieschabas.clases.Alquiler;
import org.jboss.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class AlquilerDao {

    private static final Logger LOGGER = Logger.getLogger(PeliculaDao.class);
    private static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String SQL_BUSQUEDA_ALQUILER = "Select a FROM Alquiler a";

    private static void setUp() {
        try {
            PropertyConfigurator.configure("src/main/resources/log4.properties");
            emf = Persistence.createEntityManagerFactory("videoClub");
            em = emf.createEntityManager();
            em.getTransaction().begin();
        } catch (Exception e) {
            LOGGER.error("Error en el metodo setUp(): " + e.getMessage());
        }
    }

    private static void close() {
        try {
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            LOGGER.error("Error en el metodo close(): " + e.getMessage());
        }
    }

    public static void guardarAlquiler(Alquiler alquiler) {
        setUp();
        try {

            alquiler = em.merge(alquiler);
            em.persist(alquiler);

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el metodo guardarAlquiler(): " + e.getMessage());
        }
    }

    public static void eliminarAlquiler(Alquiler alquiler) {
        setUp();
        try {

            alquiler = em.merge(alquiler);
            em.remove(alquiler);

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el metodo eliminarAlquiler(): " + e.getMessage());
        }
    }

    public static List<Alquiler> obtenerAlquiler() {

        List<Alquiler> alquileres = new ArrayList<>();

        setUp();
        try {

            alquileres = em.createQuery(SQL_BUSQUEDA_ALQUILER, Alquiler.class).getResultList();

            if (alquileres.isEmpty()) {
                LOGGER.info("No hay datos en la tabla alquiler");
            } else {
                for (Alquiler alquiler : alquileres) {
                    LOGGER.info(alquiler.getIdCompuesta() + "--" + alquiler.getIdAlquiler() + "--" + alquiler.getFechaRetorno());
                }
            }

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el metodo obtenerAlquiler(): " + e.getMessage());
        }

        return alquileres;
    }

    public static void modificarPelicula(Alquiler alquiler) {
        setUp();
        try {

            alquiler = em.find(Alquiler.class, alquiler.getIdCompuesta());

            if (alquiler.getIdCompuesta() != null) {
                alquiler = em.merge(alquiler);
            }
            em.persist(alquiler);

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el metodo modificarPelicula(): " + e.getMessage());
        }
    }
}
