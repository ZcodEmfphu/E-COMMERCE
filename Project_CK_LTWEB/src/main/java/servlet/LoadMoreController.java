package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import model.Product;

@WebServlet("/loadMore")
public class LoadMoreController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoadMoreController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String amount = request.getParameter("exits");
		int iamount = Integer.parseInt(amount); 
		ProductDAO productDAO = new ProductDAO();

		List<Product> list = productDAO.getNext4Product(iamount);

		PrintWriter out = response.getWriter();
		for (Product o : list) {
			out.println("<div class=\"product row\">\r\n"
					+ "						<form method=\"POST\" action=\"CartController\">\r\n"
					+ "							<div class=\"col-md-4 col-sm-2 product\">\r\n"
					+ "								<div class=\"card  is-table-row\" style=\"width: 14.5rem;\">\r\n"
					+ "									<a href=\"product?proId="+o.getId()+"\"><input type=\"hidden\"\r\n"
					+ "										name=\"proId\" value=\""+o.getId()+"\"><input\r\n"
					+ "										type=\"hidden\" name=\"inputQuantity\" value=\"1\"> <img\r\n"
					+ "										src=\""+o.getImage()+"\" class=\"card-img-top\" alt=\"...\"></a>\r\n"
					+ "									<div class=\"card-body\">\r\n"
					+ "										<a href=\"product?proId="+o.getId()+"\"><h5\r\n"
					+ "												class=\"card-title show_txt\">\r\n"
					+ "												<b>"+o.getName()+"</b>\r\n"
					+ "											</h5></a>\r\n"
					+ "										<p class=\"card-text show_txt\">"+o.getDescreption()+"</p>\r\n"
					+ "										<b>Giá: "+o.getPrice()+" VNĐ.</b>\r\n"
					+ "										<button style=\"margin-top: 4px;\" type=\"submit\"\r\n"
					+ "											class=\"btn btn-outline-success\">\r\n"
					+ "											<i class=\"ti-shopping-cart icon-black\"></i> Thêm vào giỏ\r\n"
					+ "										</button>\r\n"
					+ "									</div>\r\n"
					+ "								</div>\r\n"
					+ "							</div>\r\n"
					+ "						</form>\r\n"
					+ "					</div>");
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
