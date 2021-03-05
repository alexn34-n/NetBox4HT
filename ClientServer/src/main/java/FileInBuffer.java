import java.io.Serializable;

public class FileInBuffer implements Serializable {
    private byte [] buffer;
    private int ptr;

    public FileInBuffer(byte[] buffer, int ptr) {
        this.buffer = buffer;
        this.ptr=ptr;
    }

    public byte[] getBuffer() {
        return buffer;
    }

    public int getPtr() {
        return ptr;
    }
}
