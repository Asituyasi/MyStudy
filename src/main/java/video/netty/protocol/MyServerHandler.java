package video.netty.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

/**
 * Created by tiantian on 2019/1/14
 */
public class MyServerHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    
    private int count;
    
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        int length = msg.getLength();
        byte[] content = msg.getContent();

        System.out.printf("服务端接受到的数据：");
        System.out.printf("长度：" + length);
        System.out.printf("内容：" + content);

        System.out.println("服务端接受到的数据数量：" +(++this.count));
        
        String respMsg = UUID.randomUUID().toString();
        int respLength = respMsg.getBytes("utf-8").length;
        byte[] respContent = respMsg.getBytes("utf-8");
        
        PersonProtocol personProtocol = new PersonProtocol();
        personProtocol.setLength(respLength);
        personProtocol.setContent(respContent);
        
        ctx.channel().writeAndFlush(personProtocol);
    }
}
