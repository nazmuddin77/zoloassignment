package mavliwala.nazmuddin.data.network;

import android.net.Uri;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by nazmuddinmavliwala on 29/12/16.
 */
public class UrlUtil {

    private final String baseUrl;
    private static UrlUtil instance;

    private UrlUtil(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public UrlUtil staticInstance(String baseUrl) {
        if (instance == null) {
            instance = new UrlUtil(baseUrl);
        }
        return instance;
    }

    public static String getUrl(String path, HashMap<String,Object> params) {
        Uri.Builder builder = Uri.parse(instance.baseUrl + path)
                .buildUpon();
        if (!params.isEmpty()) {
            for (HashMap.Entry<String,Object> entry : params.entrySet()) {
                Object value = entry.getValue();
                if (value != null && value.toString().length() > 0) {
                    builder.appendQueryParameter(entry.getKey(),value.toString());
                }
            }
        }
        return builder.build().toString();
    }

    public static String convertHashMapToJSON(HashMap<String,String> param) throws JSONException {
        if (param.isEmpty()) {
            return "";
        }
        JSONObject jsonObject = new JSONObject();
        for (HashMap.Entry<String,String> entry : param.entrySet()) {
            jsonObject.put(entry.getKey(),entry.getValue());
        }
        return jsonObject.toString();
    }

    public static String wrap(String value) {
        return "{"+value+"}";
    }
}
