package com.changh.sccms.action.user.student;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import javax.imageio.ImageIO;

import com.changh.sccms.action.BaseAction;
import com.changh.sccms.until.ImageUtil;

public class CreateCheckCodeAction extends BaseAction{
	private InputStream input;

	public InputStream getInput()
	{
		return input;
	}

	public void setInput(InputStream input)
	{
		this.input = input;
	}
	
	public String execute() throws Exception
	{
		Map<String,BufferedImage> map = ImageUtil.getImage();
		String code = map.keySet().iterator().next();
		BufferedImage image = map.get(code);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(image,"JPEG",bos);
		byte[] bytes=bos.toByteArray();
		input = new ByteArrayInputStream(bytes);
		session.put("code", code);
		return "success";
	}
}
