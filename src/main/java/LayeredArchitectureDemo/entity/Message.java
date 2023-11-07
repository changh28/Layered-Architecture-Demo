package LayeredArchitectureDemo.entity;

import java.util.List;
import java.util.Objects;

/**
 * The message data processed within the application
 */
public class Message {

    protected long id;

    protected List<Object> data;

    protected String info;

    public Message() {}

    public Message(long id, List<Object> data, String info) {
        this.id = id;
        this.data = data;
        this.info = info;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message1 = (Message) o;
        return id == message1.id && Objects.equals(data, message1.data) && Objects.equals(info, message1.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, info);
    }

    @Override
    public String toString() {
        return "Message{" +
                "\n\tid=" + id +
                "\n\tdata=" + data +
                "\n\tmessage='" + info +
                "\n}";
    }
}
