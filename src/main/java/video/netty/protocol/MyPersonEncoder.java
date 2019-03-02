package video.netty.protocol;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by tiantian on 2019/1/14
 */
public class MyPersonEncoder extends MessageToByteEncoder<PersonProtocol> {
    
    @Override
    protected void encode(ChannelHandlerContext ctx, PersonProtocol msg, ByteBuf out) throws Exception {

        System.out.println("MyPersonEncoder encode invoked");
        out.writeInt(msg.getLength());
        out.writeBytes(msg.getContent());
    }
}
