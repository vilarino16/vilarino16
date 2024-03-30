package BaseDeDatos;

import aplicacion.*;

import java.sql.*;
public class DAOPartidas extends AbstractDAO {
    public DAOPartidas(Connection conexion, FachadaAplicacion fa){
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    public void crearPartida(Usuario u, String puerto, String ip){
        Usuario resultado=null;
        Connection con;
        PreparedStatement stmPartida=null;

        con=this.getConexion();

        try {
            stmPartida=con.prepareStatement("insert into partidas(fecha_partida, Host, IPHost, Puerto, Ganador) "+
                    "values (now(),?,?,?,null)");
            stmPartida.setString(1, u.getIdUsuario());
            stmPartida.setString(2, ip);
            stmPartida.setString(3, puerto);
            stmPartida.executeUpdate();
        } catch (SQLException e){
            System.out.println(e.getMessage());
            this.getFachadaAplicacion().muestraExcepcion(e.getMessage());
        }finally{
            try {stmPartida.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
    }

}
