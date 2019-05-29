package kr.or.ddit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	
	public static String cookieString; // 분석할 쿠키 문자열
	
	private static final Logger logger = LoggerFactory
			.getLogger(CookieUtil.class);
	
	/**
	 * 
	* Method : setCookieString
	* 작성자 : PC04
	* 변경이력 :
	* @param cookString
	* Method 설명 : 분석할 쿠키 문자열을 받는다.
	 */
	public static void setCookieString(String cookieString) {
		CookieUtil.cookieString = cookieString;
	}
	
	/**
	 * 
	* Method : getCookie
	* 작성자 : PC04
	* 변경이력 :
	* @param string
	* @return
	* Method 설명 : 쿠키 문자열에서 특정 쿠키 값을 가져온다.
	 */
	/*
	public static String getCookie(String cookie) {
		//"userId=brown; rememberme=true; test=testValue"
		// cookie = "userId"
		
//		String[] cook = "userId=brown; rememberme=true; test=testValue".split(";");
		String[] cook = cookieString.split("; ");
		
//		for (int i = 0; i < cook.length; i++) {
//			logger.debug(cook[i]);
//		}
		
		String result = "";
		for (int i = 0; i < cook.length; i++) {
			if(cook[i].contains(cookie)){
			result = cook[i].substring(cook[i].indexOf("=")+1);
			}
		}
		return result;
	}
	*/
	/*
	public static String getCookie(String cookie) {
		String[] cookieArray = CookieUtil.cookieString.split("; ");
		// cookieName = cookieValue
		// cookieArray[0] = "userId=brown"
		// cookieArray[1] = "rememberme=true"
		// cookieArray[2] = "test=testValue"
		String cookieValue = "";
		for (String str : cookieArray) {
			logger.debug("str : {} ",str);
			if(str.startsWith(cookie)){
				String[] cookieStr = str.split("=");
				// cookieStr[0] = "userId"
				// cookieStr[1] = "true"
				// cookieStr[2] = "testValue"
				cookieValue = cookieStr[1];
				break;
			}
		}
		return cookieValue;
	}
	*/
	
	public static String getCookie(String cookie) {
		String[] cookieArray = CookieUtil.cookieString.split("; ");
		// cookieName = cookieValue
		// cookieArray[0] = "userId=brown"
		// cookieArray[1] = "rememberme=true"
		// cookieArray[2] = "test=testValue"
		String cookieValue4 = "";
		for (String str : cookieArray) {
			logger.debug("str : {} ",str);
			// userId = brown
			// userI = "", "brown"
			// "userId = brown".startWith("userI=");
			if(str.startsWith(cookie+"=")){
				String[] cookieStr = str.split("=");
				// cookieStr[0] = "userId"
				// cookieStr[1] = "true"
				// cookieStr[2] = "testValue"
				cookieValue4 = cookieStr[1];
				break;
			}
		}
		return cookieValue4;
	} // end
	
}
