import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(2503);
            Socket socket = serverSocket.accept();
            DataInputStream inputStream = new DataInputStream(socket.getInputStream());
            String clientData = inputStream.readUTF();
            System.out.println(clientData);
            serverSocket.close();
        }
        catch(Exception e){
            
        }
    }
}
