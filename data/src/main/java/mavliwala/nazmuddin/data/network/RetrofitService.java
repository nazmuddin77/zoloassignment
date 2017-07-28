package mavliwala.nazmuddin.data.network;

import android.support.annotation.NonNull;

import java.util.Map;

import retrofit2.Response;
import rx.Observable;

/**
 * Created by nazmuddinmavliwala on 13/01/17.
 */
public interface RetrofitService {

    <RESPONSE> Observable<Response<RESPONSE>> get(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path
    );

    <RESPONSE> Observable<Response<RESPONSE>> get(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap
    );

    <RESPONSE> Observable<Response<RESPONSE>> getWithQueries(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> queryMap
    );

    <RESPONSE> Observable<Response<RESPONSE>> getWithQueries(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> queryMap,
            @NonNull Map<String, String> headerMap
    );

    <RESPONSE> Observable<Response<RESPONSE>> getFrom(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url
    );

    <RESPONSE> Observable<Response<RESPONSE>> getFrom(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> post(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> post(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> postAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> postAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> postAt(
            Class<RESPONSE> clazz,
            String url,
            Map<String, String> headerMap,
            Map<String, String> params,
            REQUEST body);

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> put(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> put(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> putAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> putAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> patch(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> patch(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> patchAt(
            @NonNull Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull REQUEST body
    );

    <REQUEST,RESPONSE> Observable<Response<RESPONSE>> patchAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull REQUEST body
    );

    Observable<Response<Void>> delete(@NonNull String path);

    Observable<Response<Void>> deleteAt(@NonNull String url);

    <RESPONSE> Observable<Response<RESPONSE>> postFile(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull MultiPartObject object
    );

    <RESPONSE> Observable<Response<RESPONSE>> postFile(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull MultiPartObject object
    );

    <RESPONSE> Observable<Response<RESPONSE>> postFileAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull MultiPartObject object
    );

    <RESPONSE> Observable<Response<RESPONSE>> postFileAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull MultiPartObject object
    );

    <RESPONSE> Observable<Response<RESPONSE>> putFile(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull MultiPartObject object
    );

    <RESPONSE> Observable<Response<RESPONSE>> putFile(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String path,
            @NonNull Map<String, String> headerMap,
            @NonNull MultiPartObject object
    );

    <RESPONSE> Observable<Response<RESPONSE>> putFileAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull MultiPartObject object
    );

    <RESPONSE> Observable<Response<RESPONSE>> putFileAt(
            @NonNull final Class<RESPONSE> clazz,
            @NonNull String url,
            @NonNull Map<String, String> headerMap,
            @NonNull MultiPartObject object
    );
}
