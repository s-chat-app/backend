package indi.midreamsheep.schatapp.backend.netty;

import indi.midreamsheep.schatapp.backend.dao.mysql.mapper.UserMapMapper;
import indi.midreamsheep.schatapp.backend.service.user.UserStateManager;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Component;

/**
 * netty服务启动类，用于启动netty服务
 * 加密方式：TODO
 * @see ChatServerHandler netty处理器
 * */
@Component
public class ChatServer {

    @Resource
    private ChatServerHandler chatServerHandler;

    @Resource
    private UserStateManager userStateManager;

    public void run(int port) throws InterruptedException {
        userStateManager.addUser(123456,1);
        System.out.println("服务器启动");
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
                                          pipeline.addLast("decoder", new StringDecoder());
                                          //向pipeline加入编码器
                                          pipeline.addLast("encoder", new StringEncoder());
                                          pipeline.addLast(chatServerHandler);
                                      }
                                  });
            //绑定端口，同步等待成功
            ChannelFuture f = bootstrap.bind(port).sync();
            //等待服务监听端口关闭
            f.channel().closeFuture().sync();
        } finally {
            //退出，释放线程资源
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

}
