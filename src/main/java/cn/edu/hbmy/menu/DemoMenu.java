package cn.edu.hbmy.menu;

import java.util.ArrayList;
import java.util.List;

import cn.edu.hbmy.utils.ConfigStatic;

import com.soecode.wxtools.api.IService;
import com.soecode.wxtools.api.WxConsts;
import com.soecode.wxtools.api.WxService;
import com.soecode.wxtools.bean.WxMenu;
import com.soecode.wxtools.bean.WxMenu.WxMenuButton;
import com.soecode.wxtools.bean.result.WxMenuResult;
import com.soecode.wxtools.exception.WxErrorException;

public class DemoMenu {
	static IService iService = new WxService();
	public static void main(String[] args) {
		DemoMenu.ceateMenu();
		getMenu();
	}

	public static void ceateMenu() {
		
		WxMenu menu = new WxMenu();
		List<WxMenuButton> btnList = new ArrayList<WxMenuButton>();

		// 设置Click类型的菜单
		/*WxMenuButton menuButton1 = new WxMenuButton();
		menuButton1.setType(WxConsts.BUTTON_CLICK);
		menuButton1.setKey("Shortcutentrance");
		menuButton1.setName("快捷入口");*/


		// 设置含有子按钮的按钮3
		List<WxMenuButton> Shortcut_entrance = new ArrayList<WxMenuButton>();

		WxMenuButton menuButton1_1 = new WxMenuButton();
		menuButton1_1.setType(WxConsts.BUTTON_CLICK);
		menuButton1_1.setKey("watch_grade");
		menuButton1_1.setName("查看成绩");

		WxMenuButton menuButton1_2 = new WxMenuButton();
		menuButton1_2.setType(WxConsts.BUTTON_CLICK);
		menuButton1_2.setKey("watch_attention");
		menuButton1_2.setName("查看通知");

		WxMenuButton menuButton1_3 = new WxMenuButton();
		menuButton1_3.setType(WxConsts.BUTTON_CLICK);
		menuButton1_3.setKey("Innovation_credits");
		menuButton1_3.setName("创新学分");

		/**@TODO 圈存服务URL*/
		WxMenuButton menuButton1_4 = new WxMenuButton();
		menuButton1_4.setType(WxConsts.BUTTON_VIEW);
		menuButton1_4.setUrl(ConfigStatic.ADMIN_HOME);
		menuButton1_4.setName("圈存服务");

		Shortcut_entrance.add(menuButton1_1);
		Shortcut_entrance.add(menuButton1_2);
		Shortcut_entrance.add(menuButton1_3);
		Shortcut_entrance.add(menuButton1_4);

		// 把子按钮列表设置进按钮
		WxMenuButton Shortcut_entranceBtn = new WxMenuButton();
		Shortcut_entranceBtn.setName("快捷入口");
		Shortcut_entranceBtn.setSub_button(Shortcut_entrance);


		// 设置含有子按钮的按钮3
		List<WxMenuButton> subList = new ArrayList<WxMenuButton>();

		WxMenuButton menuButton2_1 = new WxMenuButton();
		menuButton2_1.setType(WxConsts.BUTTON_VIEW);
		menuButton2_1.setUrl(ConfigStatic.STUDENT_HOME);
		menuButton2_1.setName("学生登录");

		WxMenuButton menuButton2_2 = new WxMenuButton();
		menuButton2_2.setType(WxConsts.BUTTON_VIEW);
		menuButton2_2.setUrl(ConfigStatic.TEACHER_HOME);
		menuButton2_2.setName("教师登录");

		WxMenuButton menuButton2_3 = new WxMenuButton();
		menuButton2_3.setType(WxConsts.BUTTON_VIEW);
		menuButton2_3.setUrl(ConfigStatic.ADMIN_HOME);
		menuButton2_3.setName("管理员登录");

		subList.add(menuButton2_1);
		subList.add(menuButton2_2);
		subList.add(menuButton2_3);

		// 把子按钮列表设置进按钮3
		WxMenuButton Login_entranceBtn= new WxMenuButton();
		Login_entranceBtn.setName("登录入口");
		Login_entranceBtn.setSub_button(subList);

		// 将三个按钮设置进btnList
		btnList.add(Shortcut_entranceBtn);
		//btnList.add(menuButton2);
		btnList.add(Login_entranceBtn);

		// 设置进菜单类
		menu.setButton(btnList);
		try {
			// 参数1--menu ，参数2--是否是个性化定制。如果是个性化菜单栏，需要设置MenuRule
			iService.createMenu(menu, false);
			System.out.println("AccessToken  "+iService.getAccessToken());
			System.out.println("菜单设置成功");
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
	}

	public static void getMenu() {
		try {
			WxMenuResult result = iService.getMenu();
			System.out.println(result.toString());
		} catch (WxErrorException e) {
			e.printStackTrace();
		}
	}
}
