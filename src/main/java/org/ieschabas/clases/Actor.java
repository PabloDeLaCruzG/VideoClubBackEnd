package org.ieschabas.clases;

/**
 * Esta clase Actor es una clase que extiende de Equipo
 *
 * @author alumno
 */

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "Actor")
public class Actor extends Equipo {

    public Actor() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Actor(String nombre, String apellidos, int anyoNac, String pais) {
        super(nombre, apellidos, anyoNac, pais);
        // TODO Auto-generated constructor stub
    }


}
