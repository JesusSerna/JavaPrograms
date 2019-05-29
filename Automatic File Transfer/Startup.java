import Server_client.Consistency;
import Server_client.ConsistencyClient;

import java.io.IOException;
import java.util.Random;
public class Startup {
        static  Consistency C1 = new Consistency();
        static  ConsistencyClient CC = new ConsistencyClient();
        static Thread thread_server;
        static Thread thread_client;
        static Random NUMgenerator;
        static String Filename =  "/Users/jesus/Desktop/test.txt";


        public static void main(String... args) throws InterruptedException, IOException
        {

            NUMgenerator = new Random();
            thread_server = new Thread(C1);
            thread_client = new Thread(CC);
            int random = NUMgenerator.nextInt(2);
            //System.out.println(random);
            random = 1;
            if(random == 0) { // start client on even
                CC.set_filename(Filename);
                thread_client.start();
                Thread.sleep(60000);
                if(!thread_client.isInterrupted()) {
                    main();
                }
            }
            else { // start server on odd
                C1.set_filename(Filename);
                thread_server.start();
                //thread_server.
                Thread.sleep(600);
                if(!thread_server.isInterrupted()) {
                    main();
                }
            }
while(true);
        }


        public void run()
        {

        }
    }

