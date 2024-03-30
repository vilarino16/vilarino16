package aplicacion;

import BaseDeDatos.FachadaBaseDatos;
import gui.FachadaGui;

public class GestionPartida {
    FachadaGui fgui;
    FachadaBaseDatos fbd;


    public GestionPartida(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fgui=fgui;
        this.fbd=fbd;
    }

    public void crearPartida(Usuario u, String puerto, String ip){
        fbd.crearPartida(u, puerto, ip);
    }
}
