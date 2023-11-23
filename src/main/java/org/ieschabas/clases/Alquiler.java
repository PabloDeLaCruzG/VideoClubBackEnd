package org.ieschabas.clases;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

/**
 * Clase que establece los campos y metodos de Alquiler
 */
@Entity
public class Alquiler {

    private AlquilerId idCompuesta;
    private long idAlquiler;
    private LocalDate fechaRetorno;

    /**
     * Contructor por defecto
     */
    public Alquiler() {
        super();
    }

    /**
     * Constructor sobrecargado
     *
     * @param pelicula
     * @param usuario
     * @param fechaAlquiler
     * @param fechaRetorno
     */
    public Alquiler(Pelicula pelicula, Usuario usuario, LocalDate fechaAlquiler, LocalDate fechaRetorno) {
        super();
        this.idCompuesta = new AlquilerId(pelicula, usuario, fechaAlquiler);
        this.fechaRetorno = fechaRetorno;
    }

    /**
     * Obtiene el campo
     *
     * @return
     */
    @EmbeddedId
    public AlquilerId getIdCompuesta() {
        return idCompuesta;
    }

    /**
     * Establece el campo
     *
     * @param idCompuesta
     */
    public void setIdCompuesta(AlquilerId idCompuesta) {
        this.idCompuesta = idCompuesta;
    }

    /**
     * Obtiene el campo
     *
     * @return
     */
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getIdAlquiler() {
        return idAlquiler;
    }

    /**
     * Establece el campo
     *
     * @param idAlquiler
     */
    public void setIdAlquiler(long idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    /**
     * Obtiene el campo
     *
     * @return
     */
    public LocalDate getFechaRetorno() {
        return fechaRetorno;
    }

    /**
     * Establece el campo
     *
     * @param fechaRetorno
     */
    public void setFechaRetorno(LocalDate fechaRetorno) {
        this.fechaRetorno = fechaRetorno;
    }

    @Override
    public String toString() {
        return "Alquiler [idAlquiler=" + idAlquiler + ", fechaRetorno=" + fechaRetorno + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAlquiler, fechaRetorno);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Alquiler other = (Alquiler) obj;
        return Objects.equals(idAlquiler, other.idAlquiler) && Objects.equals(fechaRetorno, other.fechaRetorno);
    }


}
