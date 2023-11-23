package org.ieschabas.clases;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

/**
 * Clase para crear clave compuesta
 */
@Embeddable
public class AlquilerId implements Serializable {

    private LocalDate fechaAlquiler;
    private Usuario idCliente;
    private Pelicula idPelicula;

    /**
     * Constructor vacio
     */
    public AlquilerId() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Contructor sobrecargado
     *
     * @param idPelicula
     * @param idCliente
     * @param fechaAlquiler
     */
    public AlquilerId(Pelicula idPelicula, Usuario idCliente, LocalDate fechaAlquiler) {
        super();
        this.fechaAlquiler = fechaAlquiler;
        this.idCliente = idCliente;
        this.idPelicula = idPelicula;
    }

    /**
     * Recoge el campo
     *
     * @return
     */
    public LocalDate getFechaAlquiler() {
        return fechaAlquiler;
    }

    /**
     * Establece el campo
     *
     * @param fechaAlquiler
     */
    public void setFechaAlquiler(LocalDate fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    /**
     * Recoge el campo y establece la relacion MtO
     *
     * @return
     */
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    public Usuario getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el campo
     *
     * @param idCliente
     */
    public void setIdCliente(Usuario idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Recoge el campo y establece la relacion MtO
     *
     * @return
     */
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    public Pelicula getIdPelicula() {
        return idPelicula;
    }

    /**
     * Establece el campo
     *
     * @param idPelicula
     */
    public void setIdPelicula(Pelicula idPelicula) {
        this.idPelicula = idPelicula;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fechaAlquiler, idCliente, idPelicula);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AlquilerId other = (AlquilerId) obj;
        return fechaAlquiler == other.fechaAlquiler && idCliente == other.idCliente && idPelicula == other.idPelicula;
    }

    @Override
    public String toString() {
        return "AlquilerId [idAlquiler=" + fechaAlquiler + ", idCliente=" + idCliente + ", idPelicula=" + idPelicula
                + "]";
    }

}
