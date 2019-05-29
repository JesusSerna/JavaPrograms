//Jesus Serna
//1000975501

package FileCheck;

import java.util.*;
import java.io.*;
public class FileWatcherTest implements Runnable {
    static String filename = null;
    final static int[] change = {0};
    public static void main(String args[]) {

        // monitor a single file
        TimerTask task = new FileWatcher( new File(filename) ) {
            protected void onChange( File file ) {
                // here we code the action on a change
                change[0] = 1;
            }
        };
        Timer timer = new Timer();
        // repeat the check every minute
        timer.schedule( task , new Date(), 1000 );

    }
    @Override
    public void run() {
         main(null);
    }
    public boolean getchange(){
        System.out.print("");
        if (change[0] == 1){
            change[0]=0;
            return true;}
        else return false;
    }
    public void setFilename(String file){
        filename = file;
    }

}