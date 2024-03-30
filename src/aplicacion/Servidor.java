package aplicacion;

import java.io.*;
import java.net.*;

public class Servidor {
    public Servidor(Usuario u) {
        // Puerto en el que el servidor escuchará las conexiones
        int puerto = 12345;

        try {
            // Creamos un socket de servidor en el puerto especificado
            ServerSocket serverSocket = new ServerSocket(puerto);
            System.out.println("aplicacion.Servidor TCP iniciado en el puerto " + puerto + "...");


            // Esperamos a que un cliente se conecte
            Socket clientSocket = serverSocket.accept();
            System.out.println("aplicacion.Cliente conectado desde " + clientSocket.getInetAddress().getHostAddress());

            // Obtenemos los streams de entrada y salida para comunicarnos con el cliente
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Leemos datos del cliente y los mostramos en la consola del servidor
            String mensajeCliente;
            while ((mensajeCliente = in.readLine()) != null) {
                System.out.println("aplicacion.Cliente: " + mensajeCliente);

                // Enviamos una respuesta al cliente
                out.println("Respuesta del servidor: " + mensajeCliente);
            }

            // Cerramos los streams y el socket del cliente
            in.close();
            out.close();
            clientSocket.close();

            // Cerramos el socket del servidor
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

