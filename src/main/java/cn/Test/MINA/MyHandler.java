package cn.Test.MINA;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class MyHandler extends IoHandlerAdapter {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyHandler.class);

    @Override
    public void sessionOpened(IoSession session) throws Exception {
        LOGGER.info(" session is Opened..." + session.getId());
    }

    @Override
    public void exceptionCaught(IoSession session, Throwable cause) throws Exception {
        // log.warn(" cause.getMessage()..." + cause.printStackTrace());
        session.close(true);
    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String pack = (String) message;

        // 接收报文，进行业务处理

        // 返回报文给客户端
        session.write(pack);
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        LOGGER.info("IDLE " + session.getIdleCount(status));
    }
}
