import service.Consumer;
import service.Producer;
import service.ReadDataFromDatabase;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) throws SQLException {

        var blockingQueue = new LinkedBlockingQueue<Timestamp>();

        if (!Arrays.toString(args).equals("[-p]")) {

            new Thread(new Producer(blockingQueue)).start();
            new Thread(new Consumer(blockingQueue)).start();

        } else {

            ReadDataFromDatabase.printData();
        }
    }
}
