package cn.edu.hbmy.utils;

import cn.edu.hbmy.pojo.wx.*;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.*;


public class MessageUtil {

    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public static final String MESSAGE_CLICK = "CLICK";
    public static final String MESSAGE_VIEW = "VIEW";
    public static final String MESSAGE_News = "news";
    public static final String MESSAGE_MUSIC = "music";
    public static final String MESSAGE_SCANCODE = "scancode_push";


    /**
     * 消息格式转化 XML转化为Map
     *
     * @author MiaoQ
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws Exception {
        Map<String, String> map = new HashMap<String, String>();
        SAXReader reader = new SAXReader();

        InputStream ins = request.getInputStream();
        Document doc = reader.read(ins);

        Element root = doc.getRootElement();

        List<Element> list = root.elements();

        for (Element element : list) {
            map.put(element.getName(), element.getText());
        }
        ins.close();
        return map;
    }

    /**
     * 将文本消息对象类型转化为Xml
     */
    public static String textMessageToXml(TextMessage textMessage) {
        XStream xStream = new XStream();
        //将xml的根节点替换成xml
        xStream.alias("xml", textMessage.getClass());
        return xStream.toXML(textMessage);
    }

    /**
     * 将图文消息转化为XML
     */
    public static String newsMessageToXml(NewsMessage newsMessage) {
        XStream xStream = new XStream();
        //将xml的根节点替换成xml
        xStream.alias("xml", newsMessage.getClass());
        xStream.alias("item", new News().getClass());
        return xStream.toXML(newsMessage);
    }

    /**
     * 将图片消息转化为Xml
     */
    public static String imageMessageToXml(ImageMessage imageMessage) {
        XStream xStream = new XStream();
        //将xml的根节点替换成xml
        xStream.alias("xml", imageMessage.getClass());
        return xStream.toXML(imageMessage);
    }

    /**
     * 将音乐消息转化为Xml
     */
    public static String musicMessageToXml(MusicMessage musicMessage) {
        XStream xStream = new XStream();
        //将xml的根节点替换成xml
        xStream.alias("xml", musicMessage.getClass());
        return xStream.toXML(musicMessage);
    }

    //拼接文本消息
    public static String initText(String ToUserName, String fromUserName, String Content) {
        TextMessage text = new TextMessage();
        text.setFromUserName(ToUserName);
        text.setToUserName(fromUserName);
        text.setMsgType(MessageUtil.MESSAGE_TEXT);
        text.setCreateTime(new Date().getTime());
        text.setContent(Content);
        return textMessageToXml(text);
    }

    /**
     * 拼接图文消息
     *
     * @param ToUserName
     * @param fromUserName
     * @return
     */
    public static String initNewsMessage(String ToUserName, String fromUserName) {
        String message = null;
        List<News> newList = new ArrayList<News>();
        NewsMessage newsMessage = new NewsMessage();

        News news = new News();
        news.setTitle("此公众号正在测试阶段");
        news.setDescription("此公众号属于个人毕业设计，正在测试阶段~~~");
        news.setPicUrl(ConfigStatic.ADMIN_HOME);
        news.setUrl("www.baidu.com");
        newList.add(news);

        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(ToUserName);
        newsMessage.setCreateTime(new Date().getTime());
        newsMessage.setMsgType(MESSAGE_News);
        newsMessage.setArticles(newList);
        newsMessage.setArticleCount(newList.size());
        message = newsMessageToXml(newsMessage);
        return message;
    }

    /**
     * 组装图片消息
     *
     * @param ToUserName
     * @param fromUserName
     * @return
     */
    public static String initImageMessage(String ToUserName, String fromUserName) {
        String message = null;
        Image image = new Image();
        image.setMediaId("JXA42t-kF7TLBLgts9lpu3dkTBKWkRRywS75_nWlZtlddb6rS_4w9gosoIjCWwR1");

        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setToUserName(fromUserName);
        imageMessage.setFromUserName(ToUserName);
        imageMessage.setCreateTime(new Date().getTime());
        imageMessage.setMsgType(MESSAGE_IMAGE);
        imageMessage.setImage(image);
        message = imageMessageToXml(imageMessage);
        return message;
    }

    /**
     * 拼接音乐消息
     */
    public static String initMusicMessage(String ToUserName, String fromUserName) {
        String message = null;
        Music music = new Music();
        music.setThumbMediaId("utSirBKfv9SxHZgPiqhGuY9xfV1-JGF6gnZFfwGhwFSPFwoLrDAyKTFYaJ3HJ_V7");
        music.setTitle("see you again");
        music.setDescription("速7片尾曲");
        music.setMusicUrl("http://hbmywx.ngrok.cc/jwxt/music/Boyce Avenue,Bea Miller - See You Again.mp3");
        music.setHQMusicUrl("http://hbmywx.ngrok.cc/jwxt/music/Boyce Avenue,Bea Miller - See You Again.mp3");

        MusicMessage musicMessage = new MusicMessage();
        musicMessage.setToUserName(fromUserName);
        musicMessage.setFromUserName(ToUserName);
        musicMessage.setCreateTime(new Date().getTime());
        musicMessage.setMsgType(MESSAGE_MUSIC);
        musicMessage.setMusic(music);
        message = musicMessageToXml(musicMessage);
        return message;
    }

    /**
     * 主菜单
     */
    public static String menuText() {
        StringBuffer sb = new StringBuffer();
        sb.append("此公众号属于个人毕业设计，正在开发阶段~~~");
        return sb.toString();
    }

    public static String firstMenu() {
        StringBuffer sb = new StringBuffer();
        sb.append("点击绑定");
        return sb.toString();
    }

    public static String secondMenu() {
        StringBuffer sb = new StringBuffer();
        sb.append("点击查看");
        return sb.toString();
    }
}
