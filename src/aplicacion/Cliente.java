package aplicacion;

import java.io.*;
import java.net.*;

public class Cliente {
    public Cliente(Usuario u) {
        // Dirección IP y puerto del servidor al que nos conectaremos
        String serverIP = "127.0.0.1"; // IP local
        int puerto = 12345;

        try {
            // Creamos un socket de cliente y nos conectamos al servidor
            Socket socket = new Socket(serverIP, puerto);
            System.out.println("Conectado al servidor en " + serverIP + ":" + puerto);

            // Obtenemos los streams de entrada y salida para comunicarnos con el servidor
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Enviamos un mensaje al servidor
            out.println("Hola, servidor!");

            // Leemos la respuesta del servidor y la mostramos en la consola del cliente
            String respuestaServidor = in.readLine();
            System.out.println("aplicacion.Servidor: " + respuestaServidor);

            // Cerramos los streams y el socket del cliente
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
