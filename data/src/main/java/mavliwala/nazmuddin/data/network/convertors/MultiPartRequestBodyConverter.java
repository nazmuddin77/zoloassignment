package mavliwala.nazmuddin.data.network.convertors;

import java.io.IOException;

import mavliwala.nazmuddin.data.network.MultiPartObject;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Converter;

/**
 * Created by nazmuddinmavliwala on 16/01/17.
 */
public class MultiPartRequestBodyConverter implements Converter<MultiPartObject, RequestBody> {

    private final MediaType MEDIA_TYPE;

    public MultiPartRequestBodyConverter(String type) {
        MEDIA_TYPE = MediaType.parse(type);
    }

    @Override
    public RequestBody convert(MultiPartObject value) throws IOException {
        return RequestBody.create(MEDIA_TYPE, value.getFile());
    }
}
