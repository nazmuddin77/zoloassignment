package mavliwala.nazmuddin.data.network;

import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.webkit.MimeTypeMap;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import mavliwala.nazmuddin.data.network.convertors.GsonRequestBodyConverter;
import mavliwala.nazmuddin.data.network.convertors.GsonResponseBodyConverter;
import mavliwala.nazmuddin.data.network.convertors.MultiPartRequestBodyConverter;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import rx.Observable;
import rx.functions.Func1;

import static retrofit2.Response.error;
import static retrofit2.Response.success;

/**
 * Created by nazmuddinmavliwala on 12/01/17.
 */

@Singleton
public class RetrofitManager implements RetrofitService {

    private static final String TAG = RetrofitManager.class.getName();
    private final Gson gson;
    private final ContentResolver resolver;
    private final RestService restService;

    @Inject
    public RetrofitManager(Retrofit retrofit,
                           Gson gson,
                           ContentResolver resolver) {
        this(retrofit.create(RestService.class),gson,resolver);
    }

    private RetrofitManager(RestService restService,
                           Gson gson,
                           ContentResolver resolver) {
        this.restService = restService;
        this.gson = gson;
        this.resolver = resolver;
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> get(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path) {
        Observable<Response<ResponseBody>> ob = restService.get(path);
        return response(clazz,ob);
    }


    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> get(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap) {
        Observable<Response<ResponseBody>> ob = restService.get(
                path, headerMap);
        return response(clazz,ob);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> getWithQueries(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> queryMap) {
        Observable<Response<ResponseBody>> ob = restService.getWithQueries(
                path, queryMap);
        return response(clazz,ob);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> getWithQueries(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String,String> queryMap,
            @NonNull Map<String, String> headerMap) {
        Observable<Response<ResponseBody>> ob = restService.getWithQueries(
                path, queryMap, headerMap);
        return response(clazz,ob);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> getFrom(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url) {
        Observable<Response<ResponseBody>> ob = restService.getFrom(url);
        return response(clazz,ob);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> getFrom(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap) {
        Observable<Response<ResponseBody>> ob = restService.getFrom(
                url, headerMap);
        return response(clazz,ob);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> post(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body) {
        final RequestBody requestBody = getRequestBodyFromRequest(body);
        Observable<Response<ResponseBody>> ob = restService.post(
                path, requestBody);
        return response(clazz,ob);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> post(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body) {
        final RequestBody requestBody = getRequestBodyFromRequest(body);
        Observable<Response<ResponseBody>> ob = restService.post(
                path, headerMap, requestBody);
        return response(clazz,ob);
    }


    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> postAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body) {
        RequestBody requestBody = getRequestBodyFromRequest(body);
        Observable<Response<ResponseBody>> ob = restService.postAt(
                url, requestBody);
        return response(clazz,ob);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> postAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String,String> headerMap,
            @NonNull REQUEST body) {
        RequestBody requestBody = getRequestBodyFromRequest(body);
        Observable<Response<ResponseBody>> ob = restService.postAt(
                url, headerMap, requestBody);
        return response(clazz,ob);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> postAt(
            Class<RESPONSE> clazz,
            String url,
            Map<String, String> headerMap,
            Map<String, String> params,
            REQUEST body) {
        RequestBody requestBody = getRequestBodyFromRequest(body);
        Observable<Response<ResponseBody>> ob = restService.postAt(
                url, headerMap, params, requestBody);
        return response(clazz,ob);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> put(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body) {
        RequestBody requestBody = getRequestBodyFromRequest(body);
        Observable<Response<ResponseBody>> ob = restService.put(
                path, requestBody);
        return response(clazz,ob);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> put(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body) {
        RequestBody requestBody = getRequestBodyFromRequest(body);
        Observable<Response<ResponseBody>> ob = restService.put(
                path, headerMap, requestBody);
        return response(clazz,ob);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> putAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body) {
        RequestBody requestBody = getRequestBodyFromRequest(body);
        Observable<Response<ResponseBody>> ob = restService.putAt(
                url, requestBody);
        return response(clazz,ob);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> putAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body) {
        RequestBody requestBody = getRequestBodyFromRequest(body);
        Observable<Response<ResponseBody>> ob = restService.putAt(
                url, headerMap, requestBody);
        return response(clazz,ob);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> patch(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body) {
        RequestBody requestBody = getRequestBodyFromRequest(body);
        Observable<Response<ResponseBody>> ob = restService.patch(
                path, requestBody);
        return response(clazz,ob);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> patch(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body) {
        RequestBody requestBody = getRequestBodyFromRequest(body);
        Observable<Response<ResponseBody>> ob = restService.patch(
                path, headerMap, requestBody);
        return response(clazz,ob);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> patchAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body) {
        RequestBody requestBody = getRequestBodyFromRequest(body);
        Observable<Response<ResponseBody>> ob = restService.patchAt(
                url, requestBody);
        return response(clazz,ob);
    }

    @Override
    public <REQUEST, RESPONSE> Observable<Response<RESPONSE>> patchAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String,String> headerMap,
            @NonNull REQUEST body) {
        RequestBody requestBody = getRequestBodyFromRequest(body);
        Observable<Response<ResponseBody>> ob = restService.patchAt(
                url, headerMap, requestBody);
        return response(clazz,ob);
    }

    @Override
    public Observable<Response<Void>> delete(@NonNull String path) {
        return this.restService.delete(path);
    }

    public Observable<Response<Void>> deleteAt(@NonNull String url) {
        return this.restService.deleteAt(url);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> postFile(
            @NonNull Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull MultiPartObject object) {
        MultipartBody.Part body = getMultiPartBody(object);
        Observable<Response<ResponseBody>> ob = this.restService
                .postFile(path, body);
        return response(clazz,ob);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> postFile(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String,String> headerMap,
            @NonNull MultiPartObject object) {
            MultipartBody.Part body = getMultiPartBody(object);
            Observable<Response<ResponseBody>> ob = this.restService
                    .postFile(path,headerMap,body);
            return response(clazz,ob);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> postFileAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull MultiPartObject object) {
        MultipartBody.Part body = getMultiPartBody(object);
        Observable<Response<ResponseBody>> ob = this.restService
                .postFileAt(url, body);
        return response(clazz,ob);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> postFileAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull MultiPartObject object) {
        MultipartBody.Part body = getMultiPartBody(object);
        Observable<Response<ResponseBody>> ob = this.restService
                .postFileAt(url, headerMap, body);
        return response(clazz,ob);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> putFile(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull MultiPartObject object) {
        MultipartBody.Part body = getMultiPartBody(object);
        Observable<Response<ResponseBody>> ob = this.restService
                .putFile(path, body);
        return response(clazz,ob);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> putFile(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull MultiPartObject object) {
        MultipartBody.Part body = getMultiPartBody(object);
        Observable<Response<ResponseBody>> ob = this.restService
                .putFile(path, headerMap, body);
        return response(clazz,ob);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> putFileAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull MultiPartObject object) {
        MultipartBody.Part body = getMultiPartBody(object);
        Observable<Response<ResponseBody>> ob = this.restService
                .putFileAt(url, body);
        return response(clazz,ob);
    }

    @Override
    public <RESPONSE> Observable<Response<RESPONSE>> putFileAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull MultiPartObject object) {
        MultipartBody.Part body = getMultiPartBody(object);
        Observable<Response<ResponseBody>> ob = this.restService
                .putFileAt(url, headerMap, body);
        return response(clazz,ob);
    }

    private <RESPONSE> Observable<Response<RESPONSE>> response(
            final Class<RESPONSE> clazz,
            Observable<Response<ResponseBody>> ob) {
        return ob.map(new Func1<Response<ResponseBody>, Response<RESPONSE>>() {
            @Override
            public Response<RESPONSE> call(Response<ResponseBody> responseBodyResponse) {
                return getResponseFromResponseBody(clazz,
                        responseBodyResponse);
            }
        });
    }

    private <RESPONSE> Response<RESPONSE> getResponseFromResponseBody (
            Class<RESPONSE> clazz,
            Response<ResponseBody> responseBody) {
        int status = responseBody.code();
        if (status >= HttpURLConnection.HTTP_OK && status <= HttpURLConnection.HTTP_MULT_CHOICE) {
            GsonResponseBodyConverter<RESPONSE> factory
                    = createResponseBodyConverter(clazz);
            try {
                RESPONSE genericResponse = factory.convert(responseBody.body());
                return success(genericResponse, responseBody.raw());
            } catch (IOException e) {
                e.printStackTrace();
                String message = e.getMessage();
                if (message != null && message.length() > 0) {
                    message = "error: " + message;
                } else message = "";
                throw new RuntimeException("error occurred while deserializing " +
                        "response object : " + clazz.getName() + message);
            }
        } else {
            return error(responseBody.errorBody(), responseBody.raw());
        }
    }

    @SuppressWarnings("unchecked")
    private <REQUEST> RequestBody getRequestBodyFromRequest(REQUEST body) {
        Class<REQUEST> clazz = (Class<REQUEST>) body.getClass();
        GsonRequestBodyConverter<REQUEST> converter
                = createRequestBodyConverter(clazz);
        try {
            return converter.convert(body);
        } catch (IOException e) {
            String message = e.getMessage();
            if (message != null && message.length() > 0) {
                message = "error: " + message;
            } else message = "";
            throw new RuntimeException("error occurred while serializing " +
                    "request object : " + body.getClass().getName() + message);
        }
    }

    private <RESPONSE> GsonResponseBodyConverter<RESPONSE> createResponseBodyConverter(
            Class<RESPONSE> clazz) {
        TypeAdapter<RESPONSE> typeAdapter = gson.getAdapter(clazz);
        return new GsonResponseBodyConverter<>(gson,typeAdapter);
    }

    private <REQUEST> GsonRequestBodyConverter<REQUEST> createRequestBodyConverter (
            Class<REQUEST> clazz) {
        TypeAdapter<REQUEST> typeAdapter = gson.getAdapter(clazz);
        return new GsonRequestBodyConverter<>(gson,typeAdapter);
    }

    private MultipartBody.Part getMultiPartBody(MultiPartObject object){
        String key = object.getKey();
        File file = object.getFile();

        RequestBody requestBody;
        try {
            requestBody = getMultiPartRequestBody(object);
            return MultipartBody.Part.createFormData(key,file.getName(),requestBody);
        } catch (IOException e) {
            e.printStackTrace();
            String message = e.getMessage();
            if (message != null && message.length() > 0) {
                message = "error: " + message;
            } else message = "";
            throw new RuntimeException("error occurred while serializing " +
                    "request object : " + object.getClass().getName() + message);
        }
    }

    private RequestBody getMultiPartRequestBody(MultiPartObject object) throws IOException {
        String type = getMimeType(object.getFile());
        MultiPartRequestBodyConverter converter = new MultiPartRequestBodyConverter(type);
        return converter.convert(object);
    }

    private String getMimeType(File file) {
        String mimeType;
        Uri uri = Uri.fromFile(file);
        if (uri.getScheme().equals(ContentResolver.SCHEME_CONTENT)) {
            mimeType = this.resolver.getType(uri);
        } else {
            String fileExtension = MimeTypeMap.getFileExtensionFromUrl(uri
                    .toString());
            mimeType = MimeTypeMap.getSingleton().getMimeTypeFromExtension(
                    fileExtension.toLowerCase());
        }
        return mimeType;
    }
}
