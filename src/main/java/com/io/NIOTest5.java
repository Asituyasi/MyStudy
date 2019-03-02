package com.io;

import java.nio.ByteBuffer;

/**
 * desc :
 * Created by tiantian on 2018/12/12
 */
public class NIOTest5 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte) i);
        }

        ByteBuffer readOnlyBuffer = buffer.asReadOnlyBuffer();
        readOnlyBuffer.put((byte)2);
    }
}
