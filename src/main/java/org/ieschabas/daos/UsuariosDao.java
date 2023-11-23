package org.ieschabas.daos;


import org.apache.log4j.PropertyConfigurator;
import org.ieschabas.clases.Usuario;
import org.jboss.logging.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UsuariosDao {

    private static final Logger LOGGER = Logger.getLogger(UsuariosDao.class);
    private static EntityManager em;
    private static EntityManagerFactory emf;
    private static final String QUERY_BUSQUEDA_USUARIO = "SELECT u FROM Usuario u";
    private static final String QUERY_BUSQUEDA_EMAIL_USUARIO = "SELECT u FROM Usuario u WHERE email = :email";

    private static void setUp() {

        // Indicamos al logger el fichero propiedades
        PropertyConfigurator.configure("src/main/resources/log4.properties");

            emf = Persistence.createEntityManagerFactory("videoClub");
            em = emf.createEntityManager();
            em.getTransaction().begin();

    }

    private static void close() {

            em.getTransaction().commit();
            em.close();

    }

    public static void guardarUsuario(Usuario usuario) {
        setUp();
        try {

            if (usuario.getId() != 0) {
                usuario = em.merge(usuario);
            }
            em.persist(usuario);

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método guardarUsuario(): " + e.getMessage());
        }
    }

    public static void eliminarUsuario(Usuario usuario) {

        setUp();
        try {

            if (usuario.getId() != 0) {
                usuario = em.merge(usuario);
            }
            em.remove(usuario);

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método eliminarUsuario(): " + e.getMessage());
        }
    }

    public static List<Usuario> obtenerUsuario() {
        List<Usuario> usuarios = new ArrayList<>();

        setUp();
        try {

            usuarios = em.createQuery(QUERY_BUSQUEDA_USUARIO, Usuario.class).getResultList();

            if (usuarios.isEmpty()) {
                LOGGER.info("No hay datos en la tabla usuarios");
            } else {
                for (Usuario usuario : usuarios) {
                    LOGGER.info(usuario.getId() + "--");
                }
            }

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método obtenerUsuario(): " + e.getMessage());
        }

        return usuarios;
    }

    public static Usuario obtenerUsuarioEmail(String email) {
        Usuario usuario = null;

        setUp();
        try {


            usuario = em.createQuery(QUERY_BUSQUEDA_EMAIL_USUARIO, Usuario.class)
                    .setParameter("email", email).getSingleResult();

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método obtenerUsuarioEmail(): " + e.getMessage());
        }

        return usuario;
    }

    public static Usuario recuperarUsuario(long id) {
        Usuario usuario = null;

        setUp();
        try {

            usuario = em.find(Usuario.class, id);

            close();
        } catch (Exception e) {
            LOGGER.error("Error en el método recuperarUsuario(): " + e.getMessage());
        }

        return usuario;
    }
}