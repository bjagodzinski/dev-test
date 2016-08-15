package WebPkg;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Rafal on 2016-08-09.
 */
public class Connector implements Connectable {

    private URL connectionURL;
    private HttpURLConnection connection;

    public URL getConnectionURL() {
        return connectionURL;
    }

    public void setConnectionURL(String URLSpecifier) throws IOException {
        this.connectionURL = new URL(AppData.baseURL + URLSpecifier);
        setConnection();
    }

    public HttpURLConnection getConnection() {
        return connection;
    }

    public void setConnection() throws IOException {
        this.connection = (HttpURLConnection) connectionURL.openConnection();
    }

    public void URLConnect() throws IOException {
        connection.connect();
    }
    public void URLDisconnect() {
        connection.disconnect();
    }
}
