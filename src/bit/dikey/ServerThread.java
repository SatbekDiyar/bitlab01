package bit.dikey;

import javax.xml.crypto.Data;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ServerThread extends Thread{
    Socket socket;


    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        Scanner in = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();
        try{
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            while (true){
                DataPackage dataPackage = (DataPackage) inputStream.readObject();
                if (dataPackage.getOperationType().equals("add")){
                    System.out.println("HERE IS ADD");
                    Book book = dataPackage.getBook();
                    books.add(book);
                }else if (dataPackage.getOperationType().equals("list")){
                    DataPackage dataPackage2 = new DataPackage();
                    System.out.println(books);
                    dataPackage2.setBooks(books);
                    System.out.println(dataPackage2);
                    outputStream.writeObject(dataPackage2);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
