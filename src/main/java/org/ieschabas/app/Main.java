package org.ieschabas.app;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.text.DateFormatter;

import org.hibernate.internal.util.io.CharSequenceReader;
import org.ieschabas.clases.Actor;
import org.ieschabas.clases.Administrador;
import org.ieschabas.clases.Alquiler;
import org.ieschabas.clases.Cliente;
import org.ieschabas.clases.Director;
import org.ieschabas.clases.Equipo;
import org.ieschabas.clases.Pelicula;
import org.ieschabas.clases.Usuario;
import org.ieschabas.daos.AlquilerDao;
import org.ieschabas.daos.EquipoDao;
import org.ieschabas.daos.PeliculaDao;
import org.ieschabas.daos.UsuariosDao;
import org.jboss.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    //private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);


    public static void main(String[] args) {
		
		Usuario user1 = new Cliente("pablo","si","pablo@gmail.com","1234",true,"12213");
		Usuario user2 = new Administrador("admin","si","admin@gmail.com","1234",true,"12213");
		UsuariosDao.guardarUsuario(user1);
		UsuariosDao.guardarUsuario(user2);

        LOGGER.info("Inicio de la aplicacion");


    }

}
