import java.io.DataOutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost", 2503);
            DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());
            outputStream.writeUTF("Hello from Client !");
            socket.close();
        }
        catch(Exception e){}
    }
}
