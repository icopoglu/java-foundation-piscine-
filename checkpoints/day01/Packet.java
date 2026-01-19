public class Packet{

    private byte header;
    private byte cmd;
    private int length;
    private String payload;

    public Packet(byte header, byte cmd, int lenght, String payload) {
        setHeader(header);
        setCmd(cmd);
        setLength(lenght);
        setPayload(payload);
    }

    public void setHeader(byte header) {
        this.header = header;
    }

    public void setCmd(byte cmd) {
        this.cmd = cmd;
    }

    public void setLength(int lenght) {
        if(lenght < 0){
            throw new IllegalArgumentException("Lenght cannot be negative");
        }
        this.length = lenght;
    }

    public void setPayload(String payload) {
        if(payload == null){
            throw new IllegalArgumentException("Payload cannot be null");
        }
        this.payload = payload;
    }

    public byte getHeader() {
        return header;
    }

    public byte getCmd() {
        return cmd;
    }

    public int getLength() {
        return length;
    }

    public String getPayload() {
        return payload;
    }

}