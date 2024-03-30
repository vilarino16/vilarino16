public class GestionUsuarios {
    FachadaGui fgui;
    FachadaBaseDatos fbd;


    public GestionUsuarios(FachadaGui fgui, FachadaBaseDatos fbd){
        this.fgui=fgui;
        this.fbd=fbd;
    }

    public Boolean comprobarAutentificacion(String idUsuario, String clave){
        Usuario u;

        u=fbd.validarUsuario(idUsuario, clave);
        if (u!=null){
            return true; // u.getTipoUsuario()==TipoUsuario.Administrador;
        } else return false;
    }
}
