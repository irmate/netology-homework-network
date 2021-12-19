import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Server startup");
        int port = 8089;
        while (true) {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            System.out.printf("New connection accepted. Port: %d\n", clientSocket.getPort());
            out.println("Hello, please enter your name");
            final String name = in.readLine();
            out.println("Are you child? (yes/no)");
            final String answer = in.readLine();
            if (answer.equals("yes")) out.println(String.format("Welcome to the kids area, %s! Let's play!", name));
            if (answer.equals("no"))
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            serverSocket.close();
        }
    }
}