package ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity;

public class Partido {

    private String fecha;
    private String local;
    private String visitante;
    private String estado;

    public Partido() {}

    public Partido(String fecha, String local, String visitante, String estado) {
        this.fecha = fecha;
        this.local = local;
        this.visitante = visitante;
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
