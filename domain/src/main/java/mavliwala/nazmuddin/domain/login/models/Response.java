package mavliwala.nazmuddin.domain.login.models;

/**
 * Created by nazmuddinmavliwala on 28/07/17.
 */

public interface Response<T> {

    T getResponseBody();

    boolean isSuccessFull();

    class Success<T> implements Response<T> {

        private final T data;

        public Success(T data) {
            this.data = data;
        }

        @Override
        public T getResponseBody() {
            return this.data;
        }

        @Override
        public boolean isSuccessFull() {
            return true;
        }
    }

    class Error<T> implements Response<T> {

        @Override
        public T getResponseBody() {
            throw new RuntimeException("cannot retrieve data from error");
        }

        @Override
        public boolean isSuccessFull() {
            return false;
        }
    }
}
