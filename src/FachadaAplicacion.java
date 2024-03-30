public class FachadaAplicacion {

    FachadaGui fgui;
    FachadaBaseDatos fbd;
    GestionUsuarios cu;

    public FachadaAplicacion(){
        fgui=new FachadaGui(this);
        fbd= new FachadaBaseDatos(this);
        cu= new GestionUsuarios(fgui, fbd);
        fgui.iniciaVista();
    }

    public Boolean comprobarAutentificacion(String idUsuario, String clave){
        return cu.comprobarAutentificacion(idUsuario, clave);
    }
    public void muestraExcepcion(String e){
        fgui.muestraExcepcion(e);
    }
}
