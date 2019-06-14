package kr.or.ddit.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.encrypt.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDaoImpl;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class LoginController
 */
/**
* LoginController.java
* 로그인 컨트롤러
* @author PC04
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC04 최초 생성
*
* </pre>
*/

// web.xml servlet, servlet-mapping --> java annotation
@WebServlet("/login")
public class LoginController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);
	
	private static final long serialVersionUID = 1L;
	
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}
	
	// 사용자 로그인 화면 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("LoginController doGet()");
		logger.debug("parameter UNT_CD : {}", request.getParameter("UNT_CD"));
		
		if(request.getCookies() != null){
			for(Cookie cookie : request.getCookies()){
				logger.debug("cookie : {}, {}", cookie.getName(), cookie.getValue());
			}
		}
		
		// login 화면을 처리해줄 누군가??에게 위임
		// 단순 login화면을 html로 응답을 생성해주는 작업이 필요
		// /login/login.jsp 위임 --> 서버상에 별도의 상태 변경을 가하는 요청이 아니기 때문에
		// 							dispatch방식으로 위임
		
//		request.getRequestDispatcher("login/login.jsp").forward(request, response);
		
		if(request.getSession().getAttribute("USER_INFO")==null){
			// session에 사용자 정보가 없을 경우 --> 기존 로직
			RequestDispatcher rd = request.getRequestDispatcher("login/login.jsp");
			rd.forward(request, response);
		}else{
			// session에 사용자 정보가 있을 경우 --> main 화면으로 이동
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		}
		
	}
	
	// 로그인 요청을 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("parameter UNT_CD : {}", request.getParameter("UNT_CD"));
		logger.debug("parameter rememberme : {}", request.getParameter("rememberme"));

		logger.debug("parameter userId : {} ", request.getParameter("userId"));
		logger.debug("parameter password : {} ", request.getParameter("password"));
		
		// 사용자 파라미터 userId, password
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String encryptPassword = KISA_SHA256.encrypt(password);
		
		// db에서 해당 사용자의 정보조회(service. dao)
		
		// 해당 사용자 정보를 이용하여 사용자가 보낸 userId, password가 일치하는지 검사
		// --> userId : brown이고 password : brown1234라는 값일 때 통괴, 그 이외 값을 불일치
		
		// 일치하면(로그인 성공) : main화면으로 이동
		
		UserVo userVo = userService.getUser(userId);
		if(userVo != null && encryptPassword.equals(userVo.getPass())){
			
			// remember 파라미터가 존재할 경우 userId, rememberme cookie 설정해준다.
			// remember 파라미터가 존재하지 않을 경우 userId, rememberme cookie 삭제한다.
			
			int cookieMaxAge = 0;
			
			if(request.getParameter("rememberme") !=null)
				cookieMaxAge = 60*60*24*30;
			
				Cookie userIdCookie = new Cookie("userId", userId);
				userIdCookie.setMaxAge(cookieMaxAge);
				
				Cookie rememberMeCookie = new Cookie("rememberme", "true");
				userIdCookie.setMaxAge(cookieMaxAge);
				
				response.addCookie(userIdCookie);
				response.addCookie(rememberMeCookie);
				
			// session에 사용자 정보를 넣어준다(사용자 빈도가 높기 때문에)
			HttpSession session = request.getSession();
			session.setAttribute("USER_INFO", userVo);
			
			RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);
			
		}else{// 불일치하면(아이디 혹은 비밀번호 잘못 입력) : 로그인 화면으로 이동
			// 로그인 화면으로 이동 : localhost/jsp/login
			// 현상황에서 /jsp/login url로 dispatch 방식으로 위임이 불가
			// request.getMethod(); // GET, POST

			request.getRequestDispatcher("/login/login.jsp").forward(request, response);
//			response.sendRedirect(request.getContextPath() + "/login");
			
		}
	
	}

}
