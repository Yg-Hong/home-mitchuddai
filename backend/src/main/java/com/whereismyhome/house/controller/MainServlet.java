//package com.whereismyhome.house.controller;
//
//import com.whereismyhome.house.house.PageInfo;
//import com.whereismyhome.house.house.dto.HouseDto;
//import com.whereismyhome.house.house.service.HouseServiceImpl;
//import com.whereismyhome.house.member.dto.MemberDto;
//import com.whereismyhome.house.member.service.MemberService;
//import com.whereismyhome.house.member.service.MemberServiceImpl;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//
//import java.io.IOException;
//import java.sql.SQLException;
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Map;
//
//
//@WebServlet(loadOnStartup=1, urlPatterns="*.do")
//public class MainServlet extends HttpServlet {
//
//	private static final long serialVersionUID = 1L;
//	private HouseServiceImpl houseService = new HouseServiceImpl();
//	private MemberService memberService = MemberServiceImpl.getInstance();
//
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		process(req, resp);
//	}
//
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		req.setCharacterEncoding("utf-8");
//		process(req, resp);
//	}
//
//
//	protected void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		String path = req.getServletPath();
//
//		try {
//			Object info = null;
//			if ("/index.do".equals(path)) { // register
//				info = viewIndex(req, resp);
//			} else if ("/house/detail.do".equals(path)) { // get products list
//				info = houseDetail(req, resp);
//			}
////			else if ("/getProduct.do".equals(path)) { // get product detail
////				info = getProduct(req, resp);
////			} else if ("/update.do".equals(path)) { // update product
////				System.out.println("update.do called");
////				info = updateProduct(req, resp);
////			} else if ("/success.do".equals(path)) { // 성공 페이지
////				System.out.println("success.do called");
////				info = successPage(req, resp);
////			}
//			else if("/member/login.do".equals(path) && req.getMethod().equals("GET")) {
//				info = viewLoginForm(req, resp);
//			} else if("/member/login.do".equals(path) && req.getMethod().equals("POST")) {
//				info = memberLogin(req, resp);
//			} else if("/member/logout.do".equals(path)) {
//				info = memberLogout(req, resp);
//			} else if("/member/register.do".equals(path) && req.getMethod().equals("GET")) {
//				info = memberRegisterForm(req, resp);
//			} else if("/member/register.do".equals(path) && req.getMethod().equals("POST")) {
//				info = registerMember(req, resp);
//			} else if("/member/detail.do".equals(path)) {
//				info = detailMember(req, resp);
//			}
//
//			if (info instanceof PageInfo) {
//				PageInfo pInfo = (PageInfo)info;
//				if (pInfo.isForward()) {
//					req.getRequestDispatcher(pInfo.getPath()).forward(req, resp); // forward path code
//					return;
//				} else {
//					resp.sendRedirect(req.getContextPath()+pInfo.getPath()); // redirect path code
//					return;
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//			// 에러 페이지로 이동
//			req.setAttribute("errorMsg", e.getMessage());
//			req.getRequestDispatcher("/WebContent/error/error.jsp").forward(req, resp);
//			return;
//		}
//	}
//
//	protected PageInfo viewIndex(HttpServletRequest request, HttpServletResponse response)
//            throws Exception {
//        return new PageInfo("/index.jsp");
//    }
//
//
////	private PageInfo successPage(HttpServletRequest req, HttpServletResponse resp) {
////
////		String message = req.getParameter("message");
////		if (message.equals("1")) {
////			message = "등록";
////		} else if (message.equals("2")) {
////			message = "수정";
////		} else if (message.equals("3")) {
////			message = "삭제";
////		}
////		req.setAttribute("message", message);
////
////		return new PageInfo("/success.jsp");
////	}
////
//	private PageInfo houseDetail(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
//
//		String dong = req.getParameter("dong");
//		System.out.println("year: " + req.getParameter("year"));
//		int year = Integer.parseInt(req.getParameter("year"));
//		int month = Integer.parseInt(req.getParameter("month"));
//
//		System.out.println(dong +" " + year +" " + month);
//
//		Map<String, String> location = houseService.searchLocationByDongCode(dong);
//		System.out.println("loc:" + location);
//		List<HouseDto> house = houseService.searchByDongCode(dong, year, month);
//		req.setAttribute("houses", house);
//		req.setAttribute("location", location);
//		req.setAttribute("year", year);
//		req.setAttribute("month", month);
//
//
//		return new PageInfo("/house/detail.jsp");
//	}
//
//
//	protected PageInfo viewLoginForm(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		return new PageInfo("/member/login.jsp");
//	}
//
//	protected PageInfo memberLogin(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		String userId = request.getParameter("userId");
//		String userPassword = request.getParameter("password");
//		MemberDto member = memberService.loginMember(userId, userPassword);
//		if(member != null) {
//			HttpSession session = request.getSession();
//			session.setAttribute("userInfo", member);
//			return new PageInfo(false, "/index.do");
//		}
//		else {
//			return new PageInfo(false, "/member/login.do");
//		}
//	}
//
//	protected PageInfo memberLogout(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//
//		HttpSession session = request.getSession();
//		session.invalidate();
//		return new PageInfo(false, "/index.do");
//	}
//
//	protected PageInfo memberRegisterForm(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		return new PageInfo("/member/register.jsp");
//	}
//
//	protected PageInfo registerMember(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		System.out.println("registerMember method called!");
//		String userName = request.getParameter("userName");
//		String userId = request.getParameter("userId");
//		String userPassword = request.getParameter("userPassword");
//		String emailId = request.getParameter("emailId");
//		String emailDomain = request.getParameter("emailDomain");
//		String joinDate = LocalDateTime.now().toString();
//
//		MemberDto member = new MemberDto();
//		member.setUserId(userId);
//		member.setUserName(userName);
//		member.setUserPassword(userPassword);
//		member.setEmailId(emailId);
//		member.setEmailDomain(emailDomain);
//		member.setJoinDate(joinDate);
//
//		memberService.registerMember(member);
//
//		return new PageInfo(false, "/index.do");
//	}
//
//	protected PageInfo detailMember(HttpServletRequest request, HttpServletResponse response)
//			throws Exception {
//		String userId = request.getParameter("userId");
//
//		MemberDto member = memberService.getMember(userId);
//		request.setAttribute("member", member);
//
//		return new PageInfo("/member/detail.jsp");
//	}
//
////	private PageInfo updateProduct(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
////
////		Product product = new Product(req.getParameter("code"), req.getParameter("model"), Integer.parseInt(req.getParameter("price")));
////		try {
////			productService.updateProduct(product);
////		} catch (Exception e) {
////			e.printStackTrace();
////		}
////
////		return new PageInfo("/product/product_list.jsp");
////	}
////
////	private PageInfo getProducts(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
////		List<Product> products = productService.getProducts();
////		for (Product item: products) {
////			System.out.println(item);
////		}
////
////		req.setAttribute("products", products);
////		return new PageInfo("/product/product_list.jsp");
////
////	}
////
////	private PageInfo registerProduct(HttpServletRequest req, HttpServletResponse resp) {
////		System.out.println("register method called");
////		return new PageInfo("/product/regist.jsp");
////	}
//
//
//
//
//
//
//
//
//
//}
