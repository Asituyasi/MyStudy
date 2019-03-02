package video.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * Created by tiantian on 2019/1/10
 */
public class MyByteToLongDecoder2 extends ReplayingDecoder<Long> {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyByteToLongDecoder2.decode invoked");
        out.add(in.readLong());
    }
}
