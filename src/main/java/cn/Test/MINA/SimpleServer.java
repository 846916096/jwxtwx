package cn.Test.MINA;


import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.SocketSessionConfig;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * 服务端
 *
 * @author MiaoQ
 * @create 2018-01-15-14:28
 */
public class SimpleServer {
    private static final Logger log = LoggerFactory.getLogger(SimpleServer.class);
    private static final String ip = "127.0.0.1";
    private static final int port = 9122;
    private static final int readBufferSize = 2048;
    private static final int idleTime = 10;
    private static final Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) throws IOException {
        IoAcceptor acceptor = new NioSocketAcceptor();

        //配置socket会话
        SocketSessionConfig socketSessionConfig = (SocketSessionConfig) acceptor.getSessionConfig();
        socketSessionConfig.setReadBufferSize(readBufferSize);
        socketSessionConfig.setIdleTime(IdleStatus.BOTH_IDLE, idleTime);

        //配置过滤器
        DefaultIoFilterChainBuilder defaultIoFilterChainBuilder = acceptor.getFilterChain();

        LoggingFilter loggingFilter = new LoggingFilter();

        defaultIoFilterChainBuilder.addLast("loggingFilter", loggingFilter);

        TextLineCodecFactory textLineCodecFactory = new TextLineCodecFactory(charset,
                LineDelimiter.WINDOWS.getValue(),
                LineDelimiter.WINDOWS.getValue());

        ProtocolCodecFilter protocolCodecFilter = new ProtocolCodecFilter(textLineCodecFactory);

        defaultIoFilterChainBuilder.addLast("protocolCodecFilter",protocolCodecFilter);

        //配置NioSocketAcceptor处理器
        SimpleServerHandler simpleServerHandler = new SimpleServerHandler();
        acceptor.setHandler(simpleServerHandler);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(ip,port);
        acceptor.bind(inetSocketAddress);
        log.info("=========SimpleServer is start============");
    }
}
