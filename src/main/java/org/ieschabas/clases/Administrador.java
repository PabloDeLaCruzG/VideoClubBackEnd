package org.ieschabas.clases;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Clase que extiende de Usuario
 */
@Entity
@DiscriminatorValue(value = "ROLE_ADMIN")
public class Administrador extends Usuario {

    public Administrador() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Administrador(String nombre, String apellidos, String email, String password, boolean activo, String fechaRegistro) {
        super(nombre, apellidos, email, password, activo, fechaRegistro);
        // TODO Auto-generated constructor stub
    }


}
