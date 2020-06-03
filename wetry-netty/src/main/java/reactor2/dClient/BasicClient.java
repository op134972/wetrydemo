package reactor2.dClient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: tangwenchuan
 * @Date: 2020-05-25 17:12
 * 经典 BIO client
 */
public class BasicClient {


    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 9999);
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        try {
            Scanner sc = new Scanner(System.in);
            while (true) {
                String nextLine = sc.nextLine();
                System.out.println("send:" + nextLine);
                bufferedWriter.write(nextLine);
                bufferedWriter.flush();
            }
        } finally {
            bufferedWriter.close();
            socket.close();
        }
    }
}
