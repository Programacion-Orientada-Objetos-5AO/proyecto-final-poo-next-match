package ar.edu.huergo.scaputo.sbigliardi.nextmatch.entity;

public class Partido {
    private String fecha;
    private String local;
    private String visitante;
    private String estado;

    public Partido(String fecha, String local, String visitante, String estado) {
        this.fecha = fecha;
        this.local = local;
        this.visitante = visitante;
        this.estado = estado;
    }

    public String getFecha() { return fecha; }
    public String getLocal() { return local; }
    public String getVisitante() { return visitante; }
    public String getEstado() { return estado; }

    @Override
    public String toString() {
        return fecha + ": " + local + " vs " + visitante + " — Estado: " + estado;
    }
}
