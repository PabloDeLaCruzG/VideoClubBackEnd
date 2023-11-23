package org.ieschabas.clases;

/**
 * Esta clase Director es un clase que extiende de Equipo
 *
 * @author alumno
 */

import javax.persistence.*;

@Entity
@DiscriminatorValue(value = "Director")
public class Director extends Equipo {

    public Director() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Director(String nombre, String apellidos, int anyoNac, String pais) {
        super(nombre, apellidos, anyoNac, pais);
        // TODO Auto-generated constructor stub
    }


}
