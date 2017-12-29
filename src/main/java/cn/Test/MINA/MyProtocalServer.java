package cn.Test.MINA;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import java.util.concurrent.Executors;

import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.executor.ExecutorFilter;
import org.apache.mina.filter.logging.LogLevel;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

/**
 * mina编解码流程：request->MyDecoder->MyHandler->MyEncode->response
 *
 * @author
 *
 */
public class MyProtocalServer {
    private static final int PORT = 8080;

    // static Logger logger = Logger.getLogger(MyProtocalServer.class);

    public static void main(String[] args) throws IOException {
        // PropertyConfigurator.configure("conf\\log4j.properties");
        IoAcceptor acceptor = new NioSocketAcceptor();
        // Log4jFilter lf = new Log4jFilter(logger);

        // 定义SLF4J 日志级别 Look: http://riddickbryant.iteye.com/blog/564330
        LoggingFilter loggingFilter = new LoggingFilter();
        loggingFilter.setSessionCreatedLogLevel(LogLevel.NONE);// 一个新的session被创建时触发
        loggingFilter.setSessionOpenedLogLevel(LogLevel.NONE);// 一个新的session打开时触发
        loggingFilter.setSessionClosedLogLevel(LogLevel.NONE);// 一个session被关闭时触发
        loggingFilter.setMessageReceivedLogLevel(LogLevel.NONE);// 接收到数据时触发
        loggingFilter.setMessageSentLogLevel(LogLevel.NONE);// 数据被发送后触发
        loggingFilter.setSessionIdleLogLevel(LogLevel.INFO);// 一个session空闲了一定时间后触发
        loggingFilter.setExceptionCaughtLogLevel(LogLevel.INFO);// 当有异常抛出时触发

        acceptor.getFilterChain().addLast("logger", loggingFilter);
        // 过滤器（自定义协议）
        acceptor.getFilterChain().addLast("codec",
                new ProtocolCodecFilter(new MyProtocalCodecFactory(Charset.forName("UTF-8"))));
        // 设置数据将被读取的缓冲区大小
        acceptor.getSessionConfig().setReadBufferSize(3000);
        // 10秒内没有读写就设置为空闲通道
        acceptor.getSessionConfig().setIdleTime(IdleStatus.BOTH_IDLE, 10);

        // 连接池设置
        // get a reference to the filter chain from the acceptor
        DefaultIoFilterChainBuilder filterChainBuilder = acceptor.getFilterChain();
        filterChainBuilder.addLast("threadPool", new ExecutorFilter(Executors.newCachedThreadPool()));

        acceptor.setHandler(new MyHandler());
        acceptor.bind(new InetSocketAddress(PORT));
        System.out.println("Start server is listenig at port " + PORT);
    }
}