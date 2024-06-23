package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDAO;

/**
 * Servlet implementation class CharServlet
 */
@WebServlet("/CharServlet")
public class CharServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CharServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		OrderDAO dao = new OrderDAO();
		double  year18=  dao.getMoneyEveryYear(2018);
		double  year19=  dao.getMoneyEveryYear(2019);
		double  year20=  dao.getMoneyEveryYear(2020);
		double  year21=  dao.getMoneyEveryYear(2021);
		double  year22=  dao.getMoneyEveryYear(2022);
		double  year23=  dao.getMoneyEveryYear(2023);
		request.setAttribute("year18", year18);
		request.setAttribute("year19", year19);
		request.setAttribute("year20", year20);
		request.setAttribute("year21", year21);
		request.setAttribute("year22", year22);
		request.setAttribute("year23", year23);
		request.getRequestDispatcher("Chart.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
