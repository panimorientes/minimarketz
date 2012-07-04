package capaNegocio;

public class Compra {
    
    private int numero, proveedor, ncomprobante;
    private String fecha;
    private String tcomprobante;
    private String fpago;
    private double tcompra;

    public Compra(int numero, int proveedor, String fecha, String tcomprobante, int ncomprobante, String fpago, double tcompra) {
        this.numero = numero;
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.tcomprobante = tcomprobante;
        this.ncomprobante= ncomprobante;
        this.fpago = fpago;
        this.tcompra = tcompra;
    }

    public int getNcomprobante() {
        return ncomprobante;
    }

    public void setNcomprobante(int ncomprobante) {
        this.ncomprobante = ncomprobante;
    }

    
    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFpago() {
        return fpago;
    }

    public void setFpago(String fpago) {
        this.fpago = fpago;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getProveedor() {
        return proveedor;
    }

    public void setProveedor(int proveedor) {
        this.proveedor = proveedor;
    }

    public double getTcompra() {
        return tcompra;
    }

    public void setTcompra(double tcompra) {
        this.tcompra = tcompra;
    }

    public String getTcomprobante() {
        return tcomprobante;
    }

    public void setTcomprobante(String tcomprobante) {
        this.tcomprobante = tcomprobante;
    }
   
}
