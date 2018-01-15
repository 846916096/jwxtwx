package cn.Test.MINA;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

/**
 * @author MiaoQ
 * @create 2018-01-15-14:47
 */
public class SimpleClientHandler extends IoHandlerAdapter {
    private final static Logger log = LoggerFactory.getLogger(SimpleClientHandler.class);
    private  static final CharsetEncoder charsetEncoder= Charset.forName("UTF-8").newEncoder();
    private static final CharsetDecoder charsetDecoder= Charset.forName("UTF-8").newDecoder();
    public void messageReceived(IoSession session, Object message) throws Exception {
        String msg = (String) message;
        log.info("=========The message received from Server  is:" + msg);
    }
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        log.debug("=========Session Created...");
    }
    @Override
    public void sessionOpened(IoSession session) throws CharacterCodingException {
        IoBuffer buffer = IoBuffer.allocate(1024);
        buffer.putString("Hello Server...\r\nI'm Client...\r\nclient test...", charsetEncoder);
        buffer.flip();
        session.write(buffer);
    }
    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        log.debug(session + "=========Session Idle...");
    }
    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        log.error(cause.getMessage());
        cause.printStackTrace();
        session.close();
    }
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        log.debug("=========messageSent...");
    }
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        log.debug("=========Session Closed...");
    }
}
