package com.company;

import java.nio.ByteBuffer;

public class MyByteBuffer  {

    ByteBuffer bb;
    public MyByteBuffer(int packet_size) {
        bb = ByteBuffer.allocate(packet_size);
    }

    // renamed methods

    public byte[] disk() {
        return array();
    }

    public final int snow() {
        return position();
    }

    public void a_path_to_disorder() { this.clear(); }

    public void clear() {
        bb.clear();
    }

    public void alabaster_shores(short value) {
        bb.putShort(value);
    }

    public byte[] array() {
        return bb.array();
    }

    public final int position() {
        return bb.position();
    }
}
