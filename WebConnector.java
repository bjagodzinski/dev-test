package WebPkg;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileWriter;
import java.io.PrintWriter;

/**
 * Created by Rafal on 2016-08-06.
 */
public class WebConnector {

    public static void main(String [ ] args) throws Exception {

        Connector urlReader = new Connector();
        urlReader.setConnectionURL(args[0]);
        urlReader.URLConnect();

        JSONParser jParser = new JSONParser();
        TextReader urlResponse = new TextReader();
        String urlJsonTxt = urlResponse.getStringData(urlReader.getConnection());

        Object jsonString = jParser.parse(urlJsonTxt);

        urlReader.URLDisconnect();

        JSONArray jArray = (JSONArray) jsonString;

        CSVCreator csvOutput = new CSVCreator();

        String result = csvOutput.makeResultString(jArray).toString();

        PrintWriter printWriter = new PrintWriter(new FileWriter(AppData.fileName));
        printWriter.write(result);
        printWriter.close();

        System.out.println(result);
    }
}
