package aplicacion;

import BaseDeDatos.FachadaBaseDatos;
import gui.FachadaGui;

public class FachadaAplicacion {

    FachadaGui fgui;
    FachadaBaseDatos fbd;
    GestionUsuarios cu;
    GestionPartida cp;

    public FachadaAplicacion(){
        fgui=new FachadaGui(this);
        fbd= new FachadaBaseDatos(this);
        cu= new GestionUsuarios(fgui, fbd);
        cp= new GestionPartida(fgui, fbd);
        fgui.iniciaVista();
    }

    public Boolean comprobarAutentificacion(String idUsuario, String clave, Usuario u){
        return cu.comprobarAutentificacion(idUsuario, clave, u);
    }
    public void crearPartida(Usuario u, String puerto, String ip){
        cp.crearPartida(u,puerto,ip);
    }
    public void muestraExcepcion(String e){
        fgui.muestraExcepcion(e);
    }
}
