package Wifi;
import FileCheck.FileWatcherTest;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WifiClient implements Runnable {
    private Socket s;
    String line = "";
    private String Filename;

    public WifiClient(String host, int port, String filename) {
        Filename=filename;
        try {
            s = new Socket(host, port);
            System.out.println("Attempting to connect to Server "+host+" on port "+port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void sendData() throws IOException {
        line = new String(Files.readAllBytes(Paths.get(Filename)));
        PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
        pw.println(line);
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
        //initiate a watcher to watch the file for changes
        FileWatcherTest watcher = new FileWatcherTest();
        watcher.setFilename(Filename);
        watcher.run();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            while(true) {
                if (br.ready()) {
                    String change = br.readLine();
                    push(change);
                    watcher.getchange();
                }
                if (watcher.getchange()) {
                        sendData();
                }
            }
        }
        catch(Exception e){};
    }


    public void run() {
        main();

    }
}