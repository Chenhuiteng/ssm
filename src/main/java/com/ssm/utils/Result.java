package com.ssm.utils;
/**
 * 返回工具类，封装参数返回给前端
 * @author tick
 *
 */
public class Result {
	public int code;

	public String msg;

	public Object data;

	public Result() {

	}

	public Result(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public static Result ok() {
		return new Result(1, "Success");
	}

	public static Result err(String err) {
		return new Result(-1, err);
	}

	public static Result data(Object data) {
		if (data == null) {
			return new Result(-1, "没有数据");
		}
		Result r = new Result(1, null);
		r.data = data;
		return r;
	}
}


