package com.changh.sccms.action.system;

import java.util.Date;
import java.util.StringTokenizer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.changh.sccms.action.BaseAction;
import com.changh.sccms.entity.Administrator;
import com.changh.sccms.entity.Log;
import com.changh.sccms.service.AdministratorService;
import com.changh.sccms.until.BrowserUtils;
import com.changh.sccms.until.LogUtil;

public class LoginAction extends BaseAction{
	//input
	private String username;
	private String password;
	private Log log = new Log();
	//output
	private boolean result=false;
	public boolean isResult() {
		return result;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	//injection
	private AdministratorService administratorService;
	
	public void setAdministratorService(AdministratorService administratorService) {
		this.administratorService = administratorService;
	}
	public String execute() throws Exception
	{
		
		Administrator admin = administratorService.getAdministrator(username);
		String Agent = httpRequest.getHeader("User-Agent");
		StringTokenizer st = new StringTokenizer(Agent,";");
		st.nextToken();
		//寰楀埌鐢ㄦ埛鐨勬祻瑙堝櫒鍚�
		log.setBroswer(BrowserUtils.checkBrowse(httpRequest));
		log.setIp(getIpAddr(httpRequest));
		log.setOperatetime(new Date());
		//楠岃瘉鐧诲綍
		//鐢ㄦ埛鍚嶅拰瀵嗙爜姝ｇ‘骞朵笖甯愬彿娌℃湁琚鐢�
		if(admin!=null&&admin.getAdmUsername().equals(username)&&admin.getAdmPassword().equals(password)&&admin.getAdmStatus()==1)
		{
			//鐧诲綍鎴愬姛
			result = true;
			log.setAdmUsername(username);
			log.setLogconten(username+"鐧诲綍鎴愬姛");
			log.setAdmId(admin.getAdmId());
			log.setOperatetype(1);	
			//鏇存柊  鐧诲綍ip锛岀櫥褰曟鏁帮紝鐧诲綍鏃堕棿
			session.put("lastLoginTime", admin.getAdmLastLoginTime());//璁板綍涓婁竴娆＄櫥闄嗘椂闂�
			admin.setAdmLastLoginTime(new Date());
			admin.setAdmLastLoginIp(httpRequest.getRemoteAddr());//鏇存柊ip
			//鏇存柊娆℃暟
			Integer num=admin.getAdmLoginNumbers();
			if(num==null)
				admin.setAdmLoginNumbers(1);
			else
				admin.setAdmLoginNumbers(admin.getAdmLoginNumbers()+1);
			//鏇存柊鍒版暟鎹簱
			administratorService.update(admin);
			//缁戝畾鍒皊ession
			LogUtil.logger.warn(admin.getAdmUsername()+"鐧婚檰浜嗭紒");
			session.put("admin", admin);
			//鍔燾ookie
			Cookie cookie = new Cookie("sccms_user", username);
			//璁剧疆cookie鐢熷瓨鏃堕棿
			cookie.setMaxAge(60*60*24*30); //鍗曚綅鏄锛屾椂闂翠负涓�釜鏈�
			//璁剧疆璺緞
			cookie.setPath("/");
			ServletActionContext.getResponse().addCookie(cookie);
		}else{
			log.setAdmUsername("<span style='color:red'>"+username+"</span>");
			log.setOperatetype(0);	
			log.setLogconten(username+"鐧诲綍澶辫触");
			log.setAdmPassword(password);
		}
		administratorService.saveLog(log);
		return "success";
	}

	public String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}
}
