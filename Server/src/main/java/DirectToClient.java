import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPromise;

public class DirectToClient extends ChannelInboundHandlerAdapter {
    public  void  write(ChannelHandlerContext ctx, Object command, ChannelPromise promise) {
        Command commandFromServer=(Command) command;
        ctx.writeAndFlush(commandFromServer);
    }
}
