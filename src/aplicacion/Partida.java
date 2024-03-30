package aplicacion;

public class Partida {
    private String fechaPartida;
    private String IPHost;
    private String puerto;
    private String ganador;
    private String Host;

    public Partida(String fecha, String host, String ip, String puerto, String ganador){
        this.fechaPartida=fecha;
        this.Host=host;
        this.IPHost=ip;
        this.puerto=puerto;
        this.ganador=ganador;
    }

    public String getFechaPartida() {
        return fechaPartida;
    }

    public String getGanador() {
        return ganador;
    }

    public String getIPHost() {
        return IPHost;
    }

    public String getPuerto() {
        return puerto;
    }
}
