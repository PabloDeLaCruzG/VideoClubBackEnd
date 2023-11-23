package org.ieschabas.daos;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.PropertyConfigurator;
import org.ieschabas.clases.Equipo;
import org.ieschabas.clases.Pelicula;
import org.ieschabas.enums.Categoria;
import org.ieschabas.enums.Formato;
import org.ieschabas.enums.Valoracion;
import org.jboss.logging.Logger;

public class PeliculaDao {

    private static final Logger LOGGER = Logger.getLogger(PeliculaDao.class);
    private static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String SQL_BUSQUEDA_PELICULA = "SELECT p FROM Pelicula p";
    private static final String SQL_BUSQUEDA_PELICULA_TITULO = "SELECT p FROM Pelicula p WHERE titulo = :titulo";

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

    public static void guardarPelicula(Pelicula pelicula) {
        setUp();
        try {

            if (pelicula.getId() != 0) {
                pelicula = em.merge(pelicula);
            }
            em.persist(pelicula);

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método guardarPelicula(): " + e.getMessage());
        }
    }

    public static void eliminarPelicula(Pelicula pelicula) {
        setUp();
        try {

            pelicula = em.merge(pelicula);
            em.remove(pelicula);

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método eliminarPelicula(): " + e.getMessage());
        }
    }

    public static List<Pelicula> obtenerPelicula() {
        List<Pelicula> peliculas = new ArrayList<>();

        setUp();
        try {

            peliculas = em.createQuery(SQL_BUSQUEDA_PELICULA, Pelicula.class).getResultList();

            if (peliculas.isEmpty()) {
                LOGGER.info("No hay datos en la tabla equipo");
            } else {
                for (Pelicula pelicula : peliculas) {
                    LOGGER.info(pelicula.getId() + "--" + pelicula.getTitulo() + "--" + pelicula.getDescripcion() + "--"
                            + pelicula.getDuracion() + "--" + pelicula.getAñopublicacion() + pelicula.getCategoria() + "--"
                            + pelicula.getFormato() + "--" + pelicula.getValoracion());
                }
            }

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método obtenerPelicula(): " + e.getMessage());
        }

        return peliculas;
    }

    public static Pelicula obtenerPeliculaPorTitulo(String titulo) {
        Pelicula pelicula = null;

        setUp();
        try {

            pelicula = em.createQuery(SQL_BUSQUEDA_PELICULA_TITULO, Pelicula.class)
                    .setParameter("titulo", titulo).getSingleResult();

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método obtenerPeliculaPorTitulo(): " + e.getMessage());
        }

        return pelicula;
    }

    public static List<Equipo> obtenerActorPorPelicula(Pelicula pelicula) {
        List<Equipo> actores = new ArrayList<>();

        setUp();
        try {

            actores = em.createQuery("SELECT a FROM Equipo a JOIN a.titulo p WHERE p = :titulo", Equipo.class)
                    .setParameter("pelicula", pelicula).getResultList();

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método obtenerActorPorPelicula(): " + e.getMessage());
        }

        return actores;
    }

    public static void modificarPelicula(Pelicula pelicula) {
        setUp();
        try {

            pelicula = em.merge(pelicula);
            em.persist(pelicula);

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método modificarPelicula(): " + e.getMessage());
        }
    }
}
