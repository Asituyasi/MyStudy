package video.netty.protocol;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * Created by tiantian on 2019/1/14
 */
public class MyClientHandler extends SimpleChannelInboundHandler<PersonProtocol> {
    private int count;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 10; i++) {
            String msgToBeSend = "send from client";
            byte[] content = msgToBeSend.getBytes(Charset.forName("utf-8"));
            int length = msgToBeSend.getBytes(Charset.forName("utf-8")).length;
            
            PersonProtocol personProtocol = new PersonProtocol();
            personProtocol.setLength(length);
            personProtocol.setContent(content);
            
            ctx.channel().writeAndFlush(personProtocol);
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, PersonProtocol msg) throws Exception {
        int length = msg.getLength();
        byte[] content = msg.getContent();

        System.out.printf("客户端接受到的消息：");
        System.out.println("长度：" + length);
        System.out.println("内容：" + content);

        System.out.println("客户端接受到的数据数量：" +(++this.count));

    }
}
