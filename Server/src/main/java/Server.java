import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.util.concurrent.ConcurrentHashMap;

public class Server {

    private ConcurrentHashMap<ChannelHandlerContext,String> clients;
    private BaseAuthService authService;

    public Server() {
        clients = new ConcurrentHashMap();
        EventLoopGroup auth=new NioEventLoopGroup(1);
        EventLoopGroup worker=new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(auth, worker)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(

                                    new ObjectEncoder(),
                                    new ObjectDecoder(ClassResolvers.cacheDisabled(null)),
                                    new DirectToClient(),
                                    new AuthHandler(Server.this)

                        );
                    }
                    });
            ChannelFuture future=bootstrap.bind(8189).sync();
            System.out.println("Server has started");
            authService = new BaseAuthService();
            future.channel().closeFuture().sync();

        } catch (InterruptedException e) {
            System.out.println("Server has broken");

        } finally {
            authService.disconnect();
            auth.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public ConcurrentHashMap<ChannelHandlerContext, String> getClients() {
        return clients;
    }
    public BaseAuthService getAuthService() {
        return authService;
    }

    public static void main(String[] args) { new Server();

    }
}
