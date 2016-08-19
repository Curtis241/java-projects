package ca.pragmaticdev.ws.data;

/**
 * Created by cpeterson on 13/02/16.
 */
public class TestImpl {

    private final long id;
    private final String content;

    public TestImpl(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
