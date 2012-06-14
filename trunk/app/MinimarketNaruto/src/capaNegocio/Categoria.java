package capaNegocio;

public class Categoria {
    private int codcateg;
    private String nomcateg;
    private String imagen;

    public Categoria(int codcateg, String nomcateg, String imagen) {
        this.codcateg = codcateg;
        this.nomcateg = nomcateg;
        this.imagen = imagen;
    }

    public int getCodcateg() {
        return codcateg;
    }

    public void setCodcateg(int codcateg) {
        this.codcateg = codcateg;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNomcateg() {
        return nomcateg;
    }

    public void setNomcateg(String nomcateg) {
        this.nomcateg = nomcateg;
    }
    
}
