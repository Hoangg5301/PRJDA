package com.Bluewind.util;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageUtil {
	public Map<String, String> getMessage(String typeMessage){
		Map<String, String> message = new HashMap<>();
		if(typeMessage.equals("add_success")) {
			message.put("message", "them thanh cong");
			message.put("alert", "them thanh cong");
		}else if(typeMessage.equals("update_success")) {
			message.put("message", "cap nhat thanh cong");
			message.put("alert", "cap nhat thanh cong");
		}else if (typeMessage.equals("error_system")){
			message.put("message", "loi he thong");
			message.put("alert", "loi he thong");
		}
		else if(typeMessage.equals("delete_success")) {
			message.put("message", "xoa thanh cong");
			message.put("alert", "xoa thanh cong");
		}else if(typeMessage.equals("register_success")) {
			message.put("message", "dang ky thanh cong");
			message.put("alert", "dang ky thanh cong");
		}
		else if(typeMessage.equals("register_error")) {
			message.put("message", "dang ky that bai");
			message.put("alert", "dang ky that bai");
		}
		else if(typeMessage.equals("login_error")) {
			message.put("message", "sai thong tin tai khoan hoac mat khau");
			message.put("alert", "sai thong tin tai khoan hoac mat khau");
		}
		return message;
	}
}
