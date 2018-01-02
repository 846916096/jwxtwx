package cn.edu.hbmy.servlet;

import cn.edu.hbmy.menu.DemoMenu;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

/**
 * 自动加载菜单
 *
 * @author MiaoQ
 * @create 2018-01-02-14:44
 */
public class AutoRunServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        DemoMenu.ceateMenu();
        super.init();
        System.out.println("初始化菜单完成......");
    }
}
