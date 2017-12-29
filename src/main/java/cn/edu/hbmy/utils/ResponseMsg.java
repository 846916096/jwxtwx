package cn.edu.hbmy.utils;

import java.io.Serializable;


public class ResponseMsg implements Serializable{
	private static final long serialVersionUID = 1L;
	public Boolean success = true;
	public String message;
	public Object data;
	
	public ResponseMsg() {
		super();
	}
	public ResponseMsg(Boolean success) {
		super();
		this.success = success;
	}
	
	public ResponseMsg(Object data) {
		super();
		this.data = data;
	}
	public ResponseMsg(Boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public ResponseMsg(Boolean success, String message, Object data) {
		super();
		this.success = success;
		this.message = message;
		this.data = data;
	}
	public Boolean getSuccess() {
		return success;
	}
	public void setSuccess(Boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseMsg [success=" + success + ", message=" + message + ", data=" + data + "]";
	}
}
  
