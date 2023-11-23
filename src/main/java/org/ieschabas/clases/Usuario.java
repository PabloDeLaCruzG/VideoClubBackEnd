package org.ieschabas.clases;

import java.net.PasswordAuthentication;
import java.util.Objects;

import javax.persistence.*;
import javax.swing.JPasswordField;

/**
 * Establece los campos y metodos a la clase Usuario
 */
@Entity
@DiscriminatorColumn(name = "rol", discriminatorType = DiscriminatorType.STRING)
public class Usuario {

    private long id;
    private String nombre;
    private String apellidos;
    private String email;
    private String password;
    private boolean activo;
    private String fechaRegistro;
    @Transient
    private transient String rol;

    /**
     * Constructor vacio
     */
    public Usuario() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Contructor sobrecargado
     *
     * @param nombre
     * @param apellidos
     * @param email
     * @param password
     * @param activo
     * @param fechaRegistro
     */
    public Usuario(String nombre, String apellidos, String email, String password, boolean activo, String fechaRegistro) {
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.activo = activo;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Recoge el campo y establece el campo clave primaria
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    /**
     * Establece el campo
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * Recoge el campo
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el campo
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Recoge el campo
     *
     * @return
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Establece el campo
     *
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Recoge el campo
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el campo
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Recoge el campo
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece el campo
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Recoge el campo
     *
     * @return
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * Establece el campo
     *
     * @param activo
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * Recoge el campo
     *
     * @return
     */
    public String getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * Establece el campo
     *
     * @param fechaRegistro
     */
    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * Recoge el campo y establece el campo
     *
     * @return
     */
    @Column(insertable = false, updatable = false)
    public String getRol() {
        return rol;
    }

    /**
     * Establece el campo
     *
     * @param rol
     */
    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public int hashCode() {
        return Objects.hash(activo, apellidos, email, fechaRegistro, id, nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Usuario other = (Usuario) obj;
        return activo == other.activo && Objects.equals(apellidos, other.apellidos)
                && Objects.equals(email, other.email) && Objects.equals(fechaRegistro, other.fechaRegistro)
                && id == other.id && Objects.equals(nombre, other.nombre);
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", email=" + email
                + ", password= " + password + ", activo=" + activo + ", fechaRegistro=" + fechaRegistro + "]";
    }

}
