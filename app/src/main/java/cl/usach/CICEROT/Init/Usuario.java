package cl.usach.CICEROT.Init;

/**
 * Created by Ian on 30-11-2016.
 */
public class Usuario {
    private String nombre;
    private String apellido;
    private String correo;
    private String contraseña;

    public Usuario(){
        setContraseña(null);
        setCorreo(null);
        setNombre(null);
        setApellido(null);
    }
    public Usuario(String nombre, String apellido,String correo,String contraseña){
        setNombre(nombre);
        setApellido(apellido);
        setCorreo(correo);
        setContraseña(contraseña);
    }

    public void setNombre(String nombre){this.nombre=nombre;}
    public String getNombre(){return nombre;}
    public void setApellido(String apellido){this.apellido=apellido;}
    public String getApellido(){return apellido;}
    public void setCorreo(String correo){this.correo=correo;}
    public String getCorreo(){return correo;}
    public void setContraseña(String contraseña){this.contraseña=contraseña;}
    public String getContraseña(){return contraseña;}


}
