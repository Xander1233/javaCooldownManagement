import java.sql.Timestamp;

public class Cooldown {
    private long time;
    private int length;
    private String identifier;

    Cooldown(String identifier, int length) {
        this.time = new Timestamp(System.currentTimeMillis()).getTime();
        this.length = length;
        this.identifier = identifier;
    }

    public long getTime() {
        return this.time;
    }

    public int getLength() {
        return this.length;
    }

    public String getIdentifier() {
        return this.identifier;
    }
}
