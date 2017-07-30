package mavliwala.nazmuddin.domain;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public interface Converter<FROM,TO> {

    TO convert(FROM data);
}
