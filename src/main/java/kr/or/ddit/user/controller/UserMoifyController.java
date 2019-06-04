package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;
import kr.or.ddit.util.PartUtil;

/**
 * Servlet implementation class UserMoifyController
 */
@WebServlet("/userModify")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
public class UserMoifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserMoifyController.class);
	
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userMo");
		logger.debug("userMo : {}", userId);
		UserVo userVo = userService.getUser(userId); 
		
		request.setAttribute("userVo", userVo); 
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		logger.debug("userId : {}", userId);
		
		String name = request.getParameter("name");
		String alias = request.getParameter("alias");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcd = request.getParameter("zipcd");
		String birth = request.getParameter("birth");

		// 사용자 보낸 평문 비밀번호 데이터
		String pass = request.getParameter("pass");
		pass = KISA_SHA256.encrypt(pass);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = null;
		try {
			userVo = new UserVo(name, userId ,alias, pass, addr1, addr2, zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Part profile = request.getPart("profile");
		
		if(profile.getSize() > 0){
			String contentDisposition = profile.getHeader("content-disposition");
			String filename = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(filename);
			
			String uploadPath = PartUtil.getUploadPath();
			
			File uploadFolder = new File(uploadPath);
			if(uploadFolder.exists()){
				
				String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
				
				logger.debug("filePath : {}",filePath);
				logger.debug("filename : {}",filename);
				
				userVo.setPath(filePath);
				userVo.setFilename(filename);
				
				profile.write(filename);
				profile.delete();
				
			}
			
		}
		
		int updateCnt = userService.updateDataUser(userVo);
		
		response.sendRedirect(request.getContextPath()+"/user?userId=" + userId);
		
	}

}
