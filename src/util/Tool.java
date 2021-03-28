package util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Tool {
	/**
	 * 获取根目录地址
	 * @param request
	 * @param response
	 * @return
	 */
	public static String Basepath(HttpServletRequest request, HttpServletResponse response){
		String path = request.getContextPath();
		String basePath = request.getScheme() + "://"
				+ request.getServerName() + ":" + request.getServerPort()
				+ path + "/";
		return basePath;
	}
}
