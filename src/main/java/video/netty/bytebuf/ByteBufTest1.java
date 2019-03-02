package video.netty.bytebuf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * Created by tiantian on 2019/1/5
 */
public class ByteBufTest1 {

    public static void main(String[] args) {
        ByteBuf buffer = Unpooled.copiedBuffer("田hello world!?1", Charset.forName("utf-8"));

        if (buffer.hasArray()) {
            byte[] array = buffer.array();
            String content = new String(array, Charset.forName("utf-8"));
            System.out.println(content);
            System.out.println(buffer);

            for (int i = 0; i < buffer.capacity(); i++) {
                System.out.println((char) buffer.getByte(i));
            }

            System.out.println(buffer.getCharSequence(0, 4, Charset.forName("utf-8")));

        }
    }
}
