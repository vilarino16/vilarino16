package gui;
import aplicacion.*;
public class FachadaGui {

    FachadaAplicacion fa;

    public FachadaGui(FachadaAplicacion fa){
        this.fa=fa;
    }

    public void iniciaVista(){
        VAutentificacion va;

        va = new VAutentificacion(fa);
        va.setVisible(true);
    }
    public void muestraExcepcion(String txtExcepcion){
        VAviso va;

        va = new VAviso(txtExcepcion);
        va.setVisible(true);
    }
}
