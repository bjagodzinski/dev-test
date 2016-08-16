package WebPkg;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by Rafal on 2016-08-09.
 */
// Make more meaningful class names
public class CSVCreator {
    
    // Do we really need theese members?
    
    private String columnList;
    
    // Object is unstable -> current state is depending on previus states
    // WRONG DESIGN!
    private StringBuilder resultString;

    public CSVCreator() {
        resultString = new StringBuilder();
        columnList = AppData.columnList;
        resultString.append(columnList + "\n");
    }

    public StringBuilder makeResultString(JSONArray jsonArray) {
        for (Object jObject : jsonArray) {
            JSONObject jsonObject = (JSONObject) jObject;

            Object objId = jsonObject.get("_id");
            Object objName = jsonObject.get("name");
            Object objType = jsonObject.get("type");
            Object geo_position = jsonObject.get("geo_position");
            JSONObject json_geo_position = (JSONObject) geo_position;
            Object objLatitude = json_geo_position.get("latitude");
            Object objLongitude = json_geo_position.get("longitude");

            resultString.append(objId.toString() + "," + objName.toString() + "," + objType.toString() + "," + objLatitude.toString() + "," + objLongitude.toString() + "\n");
        }
        return resultString;
    }
}
