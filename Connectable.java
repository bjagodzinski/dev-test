package WebPkg;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by Rafal on 2016-08-15.
 */
public interface Connectable {
    void URLConnect() throws IOException;
    void URLDisconnect();
}
