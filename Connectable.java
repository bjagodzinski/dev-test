package WebPkg;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by Rafal on 2016-08-15.
 */
public interface Connectable {
    
    // cosider not void methods
    
    // maybe it it worth to return coooection when you connect? or sth else
    void URLConnect() throws IOException;
    void URLDisconnect();
}
