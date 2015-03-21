package com.changh.sccms.action.user.student;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Map;

import com.changh.sccms.action.BaseAction;
import com.changh.sccms.until.ImageUtil;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

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
		//锟斤拷取锟斤拷证锟斤拷图片锟斤拷映锟斤拷
		BufferedImage image = map.get(code);
		//压锟斤拷锟斤拷jpeg锟斤拷式锟斤拷outputStream
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		JPEGImageEncoder encoder =JPEGCodec.createJPEGEncoder(bos);
		encoder.encode(image);
		//锟斤拷图片锟斤拷锟街斤拷锟斤拷锟斤拷,锟斤拷锟斤拷inputStream锟斤拷
		byte[] bytes=bos.toByteArray();
		input = new ByteArrayInputStream(bytes);
		//锟斤拷code值锟斤拷session
		session.put("code", code);
		return "success";
	}
}
