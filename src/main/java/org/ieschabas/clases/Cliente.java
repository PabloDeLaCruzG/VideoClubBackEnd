package org.ieschabas.clases;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Esta clase extiende de Usuario
 */
@Entity
@DiscriminatorValue(value = "ROLE_USER")
public class Cliente extends Usuario {

    public Cliente() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Cliente(String nombre, String apellidos, String email, String password, boolean activo, String fechaRegistro) {
        super(nombre, apellidos, email, password, activo, fechaRegistro);
        // TODO Auto-generated constructor stub
    }


}
