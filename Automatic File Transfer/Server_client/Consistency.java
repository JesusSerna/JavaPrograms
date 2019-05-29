package Server_client;//Jesus Serna
//1000975501

import javax.bluetooth.*;
import javax.microedition.io.*;
import java.io.*;

import Wifi.WifiServer;

import java.net.InetAddress;

public class Consistency implements Runnable {

    //************ Set file to be used and updated ********//
    public String FileName = "";
    private boolean firstconnection = true;

    public void set_filename(String file){
        FileName = file;
    }
    public String getFileName(){
        return  FileName;
    }
    // Set server information
    private static final String SERVICE_NAME        = "Consistency Server";
    private static final String SERVICE_UUID_STRING = "5F6C6A6E1CFA49B49C831E0D1C9B9DC9";
    private static final UUID SERVICE_UUID          = new UUID(SERVICE_UUID_STRING, false);
    private LocalDevice localDevice;

    public void init() throws BluetoothStateException {
        localDevice = LocalDevice.getLocalDevice();
    }

    public void begin() throws BluetoothStateException, IOException,InterruptedException {
        //RemoteDeviceDiscovery.main(null);


        //open connection
        String connUrl = "btspp://localhost:" + SERVICE_UUID_STRING + ";" + "name=" + SERVICE_NAME;
        StreamConnectionNotifier scn = (StreamConnectionNotifier) Connector.open(connUrl);
        System.out.println("Ready to accept connections");
        String line = "";
        StreamConnection sc = scn.acceptAndOpen();

        String host = InetAddress.getLocalHost().getHostAddress();
        int port = 8080;
        WifiServer fs = new WifiServer(port,FileName);
        fs.start();
        //set exit parameter
        boolean exitloop = false;

        //set while loop to continue until user types "exit"
        while (exitloop != true) {
            //wait for connection to be established
            if(!firstconnection)
            {
                sc = scn.acceptAndOpen();
            }

            //Get remote device information
            RemoteDevice remoteDevice = RemoteDevice.getRemoteDevice(sc);
            String remoteAddress = remoteDevice.getBluetoothAddress();
            System.out.println("Connection from " + remoteAddress);

            //initialize readers and writers
            BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader reader = new BufferedReader(new InputStreamReader(sc.openDataInputStream()));
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(sc.openDataOutputStream()));

            //set exit parameter
            boolean exit = false;
            String address = host +","+ port;
            writer.println(address);
            writer.flush();

            //set while loop to continue connection until remote device as disconnected
            while (exit!=true) {


                //check if any messages have come from remote server
                if (reader.ready()) {
                    //if remote device disconnected, exit while loop.
                    if (reader.readLine() == null) {
                        exit = true;
                    }
                }
                //check if user has typed in exit command
                if (consoleReader.ready()) {
                    line = consoleReader.readLine();
                    if (line.equals("exit")) {
                        exit = true;
                        exitloop = true;
                    }
                }
            }

            //close connection to remote device
            sc.close();
            System.out.println("Connection from " + remoteAddress + " closed");

        }
System.exit(0);
    }

    public void run() {
        try {
            Consistency server = new Consistency();
            server.init();
            server.begin();
        }
        catch (Exception e) { }

    }
}