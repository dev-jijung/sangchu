package xyz.itwill.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

//�α��� ���� ���� ó���� ���� Interceptor Ŭ����
// => ��û ó�� �޼ҵ��� ����� ����Ǳ� ���� ��α��� ����ڰ� �����α׷��� ��û�� ��� ������������ ���� ó��
public class LoginAuthIntercetor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		if(session.getAttribute("loginMember")==null) {
			throw new Exception();
		}
		return true;
	}
}
