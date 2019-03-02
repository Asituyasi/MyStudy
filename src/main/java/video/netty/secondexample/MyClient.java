package video.netty.secondexample;


import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MyClient {

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup group = new NioEventLoopGroup();

        try {
            Bootstrap bootstrap =  new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class).
                    handler(new MyClientInitialiazer());
            ChannelFuture channelFuture = bootstrap.connect("localhost", 8899).sync();
            channelFuture.channel().writeAndFlush("from client mian()");
            channelFuture.channel().closeFuture().sync();
        } finally {
            group.shutdownGracefully();
        }
        
    }
}
