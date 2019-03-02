package video.netty.protobuf;

import com.tian.MyDataInfo;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;


public class TestClientHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {
    
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {
        System.out.println("客户端收到消息：" + msg);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        int rand = new Random().nextInt(3);
        MyDataInfo.MyMessage message = null;
        switch (rand) {
            case 1: {
                message = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.PersonType).
                        setPerson(MyDataInfo.Person.newBuilder().
                                setName("Tian").
                                setAddress("深圳").build()).
                        build();
                break;
            }
            
            case 2: {
                message = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.CatType).
                        setCat(MyDataInfo.Cat.newBuilder().
                                setName("catA").
                                setCity("北京").build()).
                        build();
                break;
            }
            
            case 3: {
                message = MyDataInfo.MyMessage.newBuilder().setDataType(MyDataInfo.MyMessage.DataType.DogType).
                        setDog(MyDataInfo.Dog.newBuilder().
                                setName("dogB").
                                setAge(12).build()).
                        build();
            }
        }
        
        ctx.channel().writeAndFlush(message);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }
}
