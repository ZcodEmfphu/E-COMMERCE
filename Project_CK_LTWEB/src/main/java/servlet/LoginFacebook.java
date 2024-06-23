package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.http.client.ClientProtocolException;

import dao.UserDAO;
import model.FacebookAccount;
import model.User;

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
            String code = request.getParameter("code");
            String error = request.getParameter("error");
            if (error != null) {
                request.setAttribute("error", "login by facebook failure");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            } else {
                UserDAO userDAO = new UserDAO();
                FacebookLogin FB = new FacebookLogin();
                String accessToken = FB.getToken(code);
                System.out.println(accessToken);
                FacebookAccount acc = FB.getUserInfo(accessToken);
                String passwordRandom = "123456";
               
                User user = userDAO.getUserByEmail(acc.getEmail());
                HttpSession session = request.getSession(true);
                if (user == null) {
                    System.out.print("---------------------->");
                    user  = new User(acc.getName(), acc.getName(), passwordRandom, 1, acc.getEmail(), 0);
                    int id = userDAO.insertUser(user);
                    user.setId(id);
                    
                }
                session.setAttribute("user", user);
                response.sendRedirect(request.getContextPath()+"/HomeController");
            }
        
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public static void main(String[] args) {
		UserDAO userDAO = new UserDAO();
		 User newUser = new User("abcerr", "abcerr", "12345", 1,"cu20663@gmail.com", 0);
    	 int id = userDAO.insertUser(newUser);
    	 newUser.setId(id);
    	 System.out.print("-======>");
    	 System.out.print(newUser);
    	 
	}

}
