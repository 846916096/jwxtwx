package cn.Test.MINA;

import java.nio.charset.Charset;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

public class MyProtocalEncoder extends ProtocolEncoderAdapter {
    private final Charset charset;

    public MyProtocalEncoder(Charset charset) {
        this.charset = charset;
    }

    // 在此处实现包的编码工作，并把它写入输出流中
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {
        String value = (String) message;
        IoBuffer buf = IoBuffer.allocate(value.getBytes().length);
        buf.setAutoExpand(true);
        if (value != null)
            buf.put(value.trim().getBytes());
        buf.flip();
        out.write(buf);
    }


}