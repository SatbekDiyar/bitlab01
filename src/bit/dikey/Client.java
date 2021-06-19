package bit.dikey;

import javax.xml.crypto.Data;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            Socket socket = new Socket("127.0.0.1", 1111);
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            while (true){

                System.out.println("[1] to list");
                System.out.println("[2] to add");
                System.out.println("[0] to exit");

                int choice = in.nextInt();

                if (choice==1){
                    DataPackage dataPackage = new DataPackage();
                    dataPackage.setOperationType("list");
                    outputStream.writeObject(dataPackage);
                    dataPackage = (DataPackage) inputStream.readObject();
                    System.out.println(dataPackage);
//                    System.out.println(dataPackage.getBooks());
                }else if (choice==2){
                    DataPackage dataPackage = new DataPackage();
                    int id = in.nextInt();
                    String name = in.next();
                    String author = in.next();
                    Book book = new Book(id, name, author);

                    dataPackage.setBook(book);
                    dataPackage.setOperationType("add");
                    outputStream.writeObject(dataPackage);
                    System.out.println("BOOK IS SENT");

                }else {
                    break;
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
