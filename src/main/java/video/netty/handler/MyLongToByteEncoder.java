package video.netty.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by tiantian on 2019/1/9
 */
public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {
    
    @Override
    protected void encode(ChannelHandlerContext ctx, Long msg, ByteBuf out) throws Exception {
        System.out.println("encode invoked, remote address is " + ctx.channel().remoteAddress());
        System.out.println();
        out.writeLong(msg);
    }
}
