package Server_client;//Jesus Serna
//1000975501

import java.io.*;
import javax.bluetooth.*;
import javax.microedition.io.*;
import FileCheck.RemoteDeviceDiscovery;

import Wifi.WifiClient;

public class ConsistencyClient implements Runnable{

    //****** Set file to be used and updated ******?/
    public String filename="";
    public String line;
    public void set_filename(String file){
        filename = file;
    }

    // set server information
    private static final String SERVICE_UUID_STRING = "5F6C6A6E1CFA49B49C831E0D1C9B9DC9";
    private static final UUID SERVICE_UUID          = new UUID(SERVICE_UUID_STRING, false);
    private LocalDevice localDevice;
    private DiscoveryAgent discoveryAgent;

    public void init() throws BluetoothStateException {
        localDevice = LocalDevice.getLocalDevice();
        discoveryAgent = localDevice.getDiscoveryAgent();
        try {
            RemoteDeviceDiscovery.main(null);
        }
        catch(Exception e){};
    }

    public void connect() throws IOException {
        String host;
        int port;
        System.out.println("Trying to connect to Bluetooth server");
        //establish connection
        String connectionUrl = discoveryAgent.selectService(SERVICE_UUID, ServiceRecord.NOAUTHENTICATE_NOENCRYPT, false);
        System.out.println("Connecting to " + connectionUrl);
        StreamConnection sc = (StreamConnection) Connector.open(connectionUrl);
        RemoteDevice remoteDevice = RemoteDevice.getRemoteDevice(sc);
        String remoteAddress = remoteDevice.getBluetoothAddress();

        System.out.println("Connection opened to " + remoteAddress);

        //set readers and writers
        BufferedReader consolReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader = new BufferedReader(new InputStreamReader(sc.openDataInputStream()));

        //set exit parameter
        boolean exit = false;

        //loop until user types exit command
        while (exit!=true) {
            //check if any messages from remote device
            if(reader.ready()) {
                line = reader.readLine();
                String[] parts = line.split(",", 2);
                host = parts[0];
                port = Integer.parseInt(parts[1]);

                //close connection
                sc.close();
                System.out.println("Closing Bluetooth connection");
                exit= true;
                WifiClient wifi = new WifiClient(host, port, filename);
                wifi.run();

            }
            else if(consolReader.ready()){
                line = consolReader.readLine();
                if(line.equals("exit")){
                    exit = true;
                    //close connection
                    sc.close();
                    System.out.println("exiting");
                }
            }

        }
        System.exit(0);
    }

    public void run() {
        try {
        ConsistencyClient client = new ConsistencyClient();
        client.init();
        client.connect();
            }
            catch(Exception e){};
    }


}
