package modelo;

public class Orden {

    private int idOrden;
    private String fechaIngreso;
    private String descripcionFalla;
    private double costoEstimado;

    private int idCliente;
    private int idEquipo;
    private int idTecnico;
    private int idEstado;

    public Orden() {
    }

    public Orden(String fechaIngreso,
                 String descripcionFalla,
                 double costoEstimado,
                 int idCliente,
                 int idEquipo,
                 int idTecnico,
                 int idEstado) {

        this.fechaIngreso = fechaIngreso;
        this.descripcionFalla = descripcionFalla;
        this.costoEstimado = costoEstimado;

        this.idCliente = idCliente;
        this.idEquipo = idEquipo;
        this.idTecnico = idTecnico;
        this.idEstado = idEstado;
    }

    public int getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(int idOrden) {
        this.idOrden = idOrden;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getDescripcionFalla() {
        return descripcionFalla;
    }

    public void setDescripcionFalla(String descripcionFalla) {
        this.descripcionFalla = descripcionFalla;
    }

    public double getCostoEstimado() {
        return costoEstimado;
    }

    public void setCostoEstimado(double costoEstimado) {
        this.costoEstimado = costoEstimado;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(int idTecnico) {
        this.idTecnico = idTecnico;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }
}