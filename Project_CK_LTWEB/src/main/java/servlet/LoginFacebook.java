package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;

import model.FacebookAccount;

/**
 * Servlet implementation class LoginFacebook
 */
@WebServlet("/LoginFacebook")
public class LoginFacebook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFacebook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String code = request.getParameter("code");
        System.out.println(code);
        FacebookLogin FB = new FacebookLogin();
        String accessToken = FB.getToken(code);
        System.out.println(accessToken);
        FacebookAccount acc = FB.getUserInfo(accessToken);
        System.out.println(acc);
	}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
public static void main(String[] args) throws ClientProtocolException, IOException {
	 FacebookLogin FB = new FacebookLogin();
     String accessToken = FB.getToken("AQCyVAgUUOepvGdmpwNwk19CWdmUkDCnanq0uIOO1NxfxQ-Bg-IGi3bnv_sQuVpzoRVxsUPuXFDdgHs5TvdBW57nWBnpZxfMVIcN1Xo1PM6KTWpeo2QaGNUxnjSXuQsocYQmOai9-_Qu5S_X9bMMxwLlSYFEqL0-Ux6dmpV3wH6M1xFntbjgHTErDpp24yUWJSz1579vnISlXVVVwxr2sOki9J_CVbDzB3X2eRlQu3-0G0mjLj_H35PA0VCbyoORni2K6JmYcW41bk60HUEY1mnAmVQTw-CnmOfEwUIwngxBN-8CV-wHyuUGgINcXZ_pOZYqLVGYwQxkjAI0RiZU37wIOEMkecSix1FWI1pLiKg8TJ4gaMCK5eeHFlJ2iYDA6gny2J9Y3X3wAhkOvvT8mtFc8NoOHTxX-zsJ2jVSdNINKg\r\n"
     		+ "");
     System.out.println(accessToken);
}
}
