package cl.usach.CICEROT.EDA;

/**
 * Created by Ian on 05-12-2016.
 */
public class tours {
    private String titulo;
    private String precio;
    private String descripcion;
    private String key;

    public tours(){
        setDescripcion(null);
        setKey(null);
        setPrecio(null);
        setTitulo(null);
    }
    public tours(String titulo, String precio, String descripcion, String key){
        setPrecio(precio);
        setTitulo(titulo);
        setKey(key);
        setDescripcion(descripcion);
    }

    public void setTitulo(String titulo){
        this.titulo=titulo;
    }

    public void setPrecio(String precio){
        this.precio = precio;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setKey(String key){
        this.key = key;
    }
    public String getTitulo(){return titulo;}
    public  String getPrecio(){return precio;}
    public String getDescripcion(){return descripcion;}
    public String getKey(){return key;}
}
