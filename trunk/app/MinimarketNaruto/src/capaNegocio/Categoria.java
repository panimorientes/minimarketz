package capaNegocio;

public class Categoria {
    private int codigo;
    private String nombre;
    private String imagen;

    public Categoria(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
