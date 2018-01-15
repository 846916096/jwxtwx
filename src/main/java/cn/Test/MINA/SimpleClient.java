package cn.Test.MINA;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoConnector;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.LineDelimiter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.charset.Charset;

/**
 * 客户端
 *
 * @author MiaoQ
 * @create 2018-01-15-14:41
 */
public class SimpleClient {
    private static final Logger log = LoggerFactory.getLogger(SimpleClient.class);
    private static final  String ip = "127.0.0.1";
    private static final  int port = 9122;
    private static final  int connectTimeoutMillis = 30000;
    private static final Charset charset = Charset.forName("UTF-8");

    public static void main(String[] args) {
        IoConnector connector=new NioSocketConnector();
        connector.setConnectTimeoutMillis(connectTimeoutMillis);
        //配置过滤器
        DefaultIoFilterChainBuilder defaultIoFilterChainBuilder = connector.getFilterChain();
        LoggingFilter loggingFilter = new LoggingFilter();
        defaultIoFilterChainBuilder.addLast("loggingFilter", loggingFilter);
        TextLineCodecFactory textLineCodecFactory =
                new TextLineCodecFactory(charset, LineDelimiter.WINDOWS.getValue(),
                        LineDelimiter.WINDOWS.getValue());
        ProtocolCodecFilter protocolCodecFilter = new ProtocolCodecFilter(textLineCodecFactory);
        defaultIoFilterChainBuilder.addLast("protocolCodecFilter",protocolCodecFilter);
        //配置NioSocketConnector处理器
        SimpleClientHandler simpleClientHandler = new SimpleClientHandler();
        connector.setHandler(simpleClientHandler);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(ip,port);
        connector.connect(inetSocketAddress);
        log.info("=========SimpleClient is start============");
    }
}
