package arcicium;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test3 {

    public static void main(String[] arg) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock(true);

    }
}
