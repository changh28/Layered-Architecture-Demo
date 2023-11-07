package LayeredArchitectureDemo.exception;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.time.Instant;

/**
 * Unified return format for REST api errors
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorMessage {
    private Instant timestamp;
    private String error;
    private String path;
    private Object details;

    public ErrorMessage() {}

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public static class builder {
        private Instant timestamp;
        private String error;
        private String path;
        private Object details;

        public builder() {}

        public builder(Instant timestamp, String error, String path, Object details) {
            this.timestamp = timestamp;
            this.error = error;
            this.path = path;
            this.details = details;
        }

        public builder timestamp(Instant timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public builder error(String error) {
            this.error = error;
            return this;
        }

        public builder path(String path) {
            this.path = path;
            return this;
        }

        public builder details(Object details) {
            this.details = details;
            return this;
        }

        public ErrorMessage build() {
            return new ErrorMessage(timestamp, error, path, details);
        }
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "timestamp=" + timestamp +
                ", error='" + error + '\'' +
                ", path='" + path + '\'' +
                ", details=" + details +
                '}';
    }
}