package com.vily.demo3.netty;

import com.alibaba.fastjson.JSON;
import com.vily.demo3.util.StringUtils;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.net.InetAddress;


/**
 *  * description : serverHandler配置这里是实现业务逻辑的地方
 *  * Author : Vily
 *  * Date : 2018-12-19
 *  
 **/

@Component
@Qualifier("serverHandler")
@ChannelHandler.Sharable
public class ServerHandler extends SimpleChannelInboundHandler<Object> {
    private static final Logger log = LoggerFactory.getLogger(ServerHandler.class);


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        super.channelRead(ctx, msg);


        byte[] data = StringUtils.toByteArray(msg);
//
        log.info("-------sssss" + data.length + "-----" + StringUtils.byteToHex(data));

    }

    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
        channelHandlerContext.channel().writeAndFlush("Yoru msg is:" + o);
    }


    //    @Override
//    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
//
//
//        log.info("client msg:"+msg);
//
//        String clientIdToLong= ctx.channel().id().asLongText();
//
//        String clientIdToShort= ctx.channel().id().asShortText();
//        log.info("-----client short id:"+clientIdToShort+"-------client long id:"+clientIdToLong);
//
//        if(msg.contains("hhh")){
//            ctx.channel().close();
//        }else{
//            ctx.channel().writeAndFlush("Yoru msg is:"+msg);
//        }
//
//    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        log.info("RamoteAddress : " + ctx.channel().remoteAddress() + " active !");

        ctx.channel().writeAndFlush("你说啥 " + InetAddress.getLocalHost().getHostName() + " service!\n");

        super.channelActive(ctx);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        log.info("---------------Channel is disconnected");
        super.channelInactive(ctx);
    }


}
