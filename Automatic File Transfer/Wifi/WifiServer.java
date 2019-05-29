package Wifi;

import FileCheck.FileWatcherTest;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;


public class WifiServer extends Thread {
    private ServerSocket ss;
    private Socket clientSock;
    private String Filename;
    private FileWatcherTest watcher = new FileWatcherTest();
    String line = "";
    private int Port;

    public WifiServer(int port,String filename) {
        Filename = filename;
        Port = port;
        try {
            ss = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void push(String change){
        try (Writer writer2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(Filename),"utf-8"))){
            writer2.write(change);
        }
        catch(Exception e){};
        //sleep for 10 seconds to allow write to complete and reset the "change flag"
        //(without sleep, the file will change due to write and the watcher will catch it and send an update to remote device which
        //will also catch it as it has been changed by write and become an infinite loop)
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
    public void main() {
        try {
            clientSock = ss.accept();
            System.out.println("Wifi connection established on port "+ Port);
        } catch (IOException e) {
            e.printStackTrace();
        }
        watcher.setFilename(Filename);
        watcher.run();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSock.getInputStream()));
            while(true) {
                if (br.ready()) {
                    String change = br.readLine();
                    push(change);
                    watcher.getchange();
                }
                if (watcher.getchange()) {
                    try {
                        sendData();
                    } catch (Exception e) {
                    }
                }
            }
        }
        catch(Exception e){};



    }
    public void sendData() throws IOException {
        line = new String(Files.readAllBytes(Paths.get(Filename)));
        PrintWriter pw = new PrintWriter(clientSock.getOutputStream(), true);
        pw.println(line);
    }

    public void run() {
        main();
    }
}