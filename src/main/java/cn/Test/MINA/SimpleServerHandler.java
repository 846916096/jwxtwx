package cn.Test.MINA;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author MiaoQ
 * @create 2018-01-15-14:35
 */
public class SimpleServerHandler extends IoHandlerAdapter {
    private final static Logger log = LoggerFactory.getLogger(SimpleServerHandler.class);
    private  static final CharsetEncoder charsetEncoder= Charset.forName("UTF-8").newEncoder();
    private static final CharsetDecoder charsetDecoder= Charset.forName("UTF-8").newDecoder();

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String msg = (String) message;
        log.info("=========The message received from Client is:" + msg);
        //收到客户端发送的关闭会话命令
        /*if(msg.equals("quit")){
            session.closeNow();
        }*/
        IoBuffer buffer = IoBuffer.allocate(1024);
        buffer.putString("Hello Client...\r\nI'm Server...\r\nserver test...", charsetEncoder);
        buffer.flip();
        session.write(buffer);
    }
        public void sessionClosed(IoSession session) throws Exception {
            log.debug("=========Session Closed...");
        }
        public void sessionCreated(IoSession session) throws Exception {
            log.debug("=========Session Created...");
        }
        public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
            log.debug(session + "=========Session Idle...");
        }
        public void sessionOpened(IoSession session) throws Exception {
            log.debug("=========Session Opened...");
        }
        public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
            log.error(cause.getMessage());
            cause.printStackTrace();
            session.close();
        }
        public void messageSent(IoSession session, Object message) throws Exception {
            log.debug("=========messageSent...");
        }
    }