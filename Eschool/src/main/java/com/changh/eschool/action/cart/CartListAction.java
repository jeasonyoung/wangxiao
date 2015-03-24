package com.changh.eschool.action.cart;

import java.util.List;
import javax.servlet.http.Cookie;
import com.changh.eschool.action.BaseAction;
import com.changh.eschool.entity.CartItem;
import com.changh.eschool.service.CartService;
import com.changh.eschool.until.Constant;

public class CartListAction extends BaseAction{
	private List<CartItem> list;
	private double totalRMoney;	
	private double totalOMoney;	
	private String gradeIds;
	private String packageIds;
	
	public String getGradeIds() {
		return gradeIds;
	}

	public String getPackageIds() {
		return packageIds;
	}

	public List<CartItem> getList() {
		return list;
	}
	
	public double getTotalRMoney() {
		return totalRMoney;
	}
	public double getTotalOMoney() {
		return totalOMoney;
	}

	private CartService cartService;
	public void setCartService(CartService cartService) {
		this.cartService = cartService;
	}
	public String execute()throws Exception
	{
		Cookie[] cookies = httpRequest.getCookies();
		Cookie gradeCookie = null;
		Cookie packageCookie = null;
		if(cookies!=null)
		{
		for(Cookie c : cookies)
		{
			if("grade".equals(c.getName()))
			{
				gradeCookie = c;
			}
			if("package".equals(c.getName()))
			{
				packageCookie = c;
			}
		}
		list = cartService.getProFromCookie(packageCookie,gradeCookie);
		totalRMoney = cartService.getTotalRMoney();
		totalOMoney = cartService.getTotalOMoney();
		packageIds = cartService.getProIds(Constant.CLASS_PACKAGE);
		gradeIds = cartService.getProIds(Constant.SINGER_GRADE);
		}
		//System.out.println(packageIds+gradeIds);
		return "success";
	}
}
