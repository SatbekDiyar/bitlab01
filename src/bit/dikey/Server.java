package bit.dikey;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {
        try{
            ServerSocket server = new ServerSocket(1111);
            while (true){
                Socket socket = server.accept();
                ServerThread thread = new ServerThread(socket);
                thread.start();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
