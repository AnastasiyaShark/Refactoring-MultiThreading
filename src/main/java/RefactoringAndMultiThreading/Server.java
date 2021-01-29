package RefactoringAndMultiThreading;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;

public class Server {

    private final int portNumber;

    public Server(int portNumber) {
        this.portNumber = portNumber;
    }

    public void connectServer() throws IOException {
        final var serverSocket = new ServerSocket(portNumber);
        final var threadPool = Executors.newFixedThreadPool(64);
        System.out.println("The server is STARTING!");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                final var serverThread = new ServerThread(socket);
                threadPool.submit(serverThread);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}




