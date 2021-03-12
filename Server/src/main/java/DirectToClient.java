import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class DirectToClient extends ChannelOutboundHandlerAdapter {
    public  void  write(ChannelHandlerContext ctx, Object command, ChannelPromise promise) {
        Command commandFromServer=(Command) command;
        ctx.writeAndFlush(commandFromServer);
    }
}
