package xyz.itwill.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import xyz.itwill.dto.Member;

//Interceptor Ŭ���� : Front Controller�� ���� ��û ó�� �޼ҵ��� ��� ���� ���Ŀ� ���ԵǾ� ���۵�
//����� �����ϴ� Ŭ����
// => Interceptor Ŭ������ HandlerInterceptor �������̽��� ��ӹ޾� �ۼ�
// => Bean Configuration File(servlet-context.xml)���� Spring Bean���� ���

//������ ���� ���� ó���� ���� Interceptor Ŭ����
// => ��û ó�� �޼ҵ��� ����� ����Ǳ� ���� ��α��� ������̰ų� �����ڰ� �ƴ� ����ڰ� 
//�����α׷��� ��û�� ��� ������������ ���� ó��
public class AdminAuthInterceptor implements HandlerInterceptor {
	//preHandle : ��û ó�� �޼ҵ��� ����� ����Ǳ� ���� ����� ����� �ۼ��ϴ� �޼ҵ�
	// => ���� ���� ����� �ۼ��Ͽ� �����ϱ� ���� ����ϴ� �޼ҵ�
	// => false ��ȯ : ��û ó�� �޼ҵ��� ��� �̽���, true ��ȯ  : ��û ó�� �޼ҵ��� ��� ����
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session=request.getSession();
		
		Member loginUserinfo=(Member)session.getAttribute("loginMember");
		
		if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
			request.getRequestDispatcher("user_error").forward(request, response);
			return false;
			
//			throw new Exception();
		}
		
		return true;
	}
	
//	//postHandle : ��û ó�� �޼ҵ��� ����� ���������� ����� �Ŀ� ����� ����� �ۼ��ϴ� �޼ҵ�
//	// => ��û ó�� �޼ҵ��� ��� ����� ���ܰ� �߻��� ��� postHandle �޼ҵ��� ��� �̽���
//	// => ��û ó�� �޼ҵ��� ��ȯ��(ModelAndView ��ü)�� ������ ��� ����ϴ� �޼ҵ�
//	@Override
//	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
//			ModelAndView modelAndView) throws Exception {
//		// TODO Auto-generated method stub
//		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//	}
//	
//	//afterCompletion : ��û ó�� �޼ҵ��� ��� ����� ���ܰ� �߻��� �Ŀ� ����� ����� �ۼ��ϴ� �޼ҵ�
//	// => ���� ó���� ������ ����ϴ� �޼ҵ�
//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
//			throws Exception {
//		// TODO Auto-generated method stub
//		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//	}
}




