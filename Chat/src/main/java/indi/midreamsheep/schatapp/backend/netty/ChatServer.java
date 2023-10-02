package indi.midreamsheep.schatapp.backend.netty;

import indi.midreamsheep.schatapp.backend.netty.prototcp.MessageDecoder;
import indi.midreamsheep.schatapp.backend.netty.prototcp.MessageEncoder;
import indi.midreamsheep.schatapp.backend.service.chat.ChannelManager;
import indi.midreamsheep.schatapp.backend.service.controller.user.UserStateService;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * netty服务启动类，用于启动netty服务
 * 加密方式：TODO
 * @see ChatServerHandler netty处理器
 * */
@Component
@Slf4j
public class ChatServer {

    @Resource
    private ChatServerHandler chatServerHandler;

    public void run(int port) throws InterruptedException {
        log.info("netty服务启动,端口号:{}", port);
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childHandler(new ChannelInitializer<SocketChannel>() { //初始化handler
                        @Override
                        protected void initChannel(SocketChannel socketChannel) {
                            ChannelPipeline pipeline = socketChannel.pipeline();
                            //向pipeline加入解码器
                            pipeline.addLast("decoder", new MessageDecoder());
                            //向pipeline加入编码器
                            pipeline.addLast("encoder", new MessageEncoder());
                            pipeline.addLast(chatServerHandler);
                        }
                    });
            //绑定端口，同步等待成功
            ChannelFuture f = bootstrap.bind(port).sync();
            //等待服务监听端口关闭
            f.channel().closeFuture().sync();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            //退出，释放线程资源
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

}
