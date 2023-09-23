import indi.midreamsheep.schatapp.backend.protocol.chat.request.ChatMessage;
import indi.midreamsheep.schatapp.backend.chat.system.PrivateKey;
import indi.midreamsheep.schatapp.backend.util.json.JsonUtil;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.Scanner;

public class test {

    public void run() throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();
        try {
            Bootstrap bootstrap = new Bootstrap()
                    .group(group)
                    .channel(NioSocketChannel.class)
                    .handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {

                            //得到pipeline
                            ChannelPipeline pipeline = ch.pipeline();
                            //加入相关handler
                            pipeline.addLast("decoder", new StringDecoder());
                            pipeline.addLast("encoder", new StringEncoder());
                            //加入自定义的handler
                            pipeline.addLast(new SimpleChannelInboundHandler<String>() {
                                @Override
                                protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
                                    System.out.println(msg.trim());
                                }
                            });
                        }
                    });

            ChannelFuture channelFuture = bootstrap.connect("localhost", 7524).sync();
            //得到channel
            Channel channel = channelFuture.channel();
            System.out.println("-------" + channel.localAddress()+ "--------");
            //客户端需要输入信息，创建一个扫描器
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String msg = scanner.nextLine();
                //通过channel 发送到服务器端
                System.out.println(msg);
                channel.writeAndFlush(msg);
            }
        }finally {
            group.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        ChatMessage jsonToBean = JsonUtil.getJsonToBean("{\"id\":454,\"type\":1,\"mapping\":\"LOGIN\",\"data\":{\"privateKey\":123456}}", ChatMessage.class);
        System.out.println(jsonToBean);
        PrivateKey javaObject = jsonToBean.getData().toJavaObject(PrivateKey.class);
        System.out.println(javaObject.getPrivateKey());
        // new test().run();
    }
    /*
    * {"id":454,"type":1,"mapping":"LOGIN","data":{"privateKey":123456}}
    * {"id":546,"type":2,"mapping":"SEND","data":{"messageTo":1,"messageType":5,"message": {}}}
    * */
}
