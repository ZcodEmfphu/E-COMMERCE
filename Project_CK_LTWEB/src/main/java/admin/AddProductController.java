package admin;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dao.CategoryDAO;
import dao.ProductDAO;
import model.Category;
import support.Endcoding;


@MultipartConfig(maxFileSize = 1024*1200)
@WebServlet("/add_product")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public AddProductController() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		CategoryDAO cateDAO = new CategoryDAO();

		List<Category> listCate = cateDAO.getAllCategory();
		request.setAttribute("listCate", listCate);
		request.getRequestDispatcher("/admin/addProduct1.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		CategoryDAO cateDAO = new CategoryDAO();
		ProductDAO productDAO = new ProductDAO();

		List<Category> listCate = cateDAO.getAllCategory();

		String proName = request.getParameter("productName");
		String proImage = request.getParameter("productImage");
		String proDes = request.getParameter("productDes");
		String proPrice = request.getParameter("productPrice");
		String proKind = request.getParameter("productKind");
		String proHeight = request.getParameter("height");
		String proLength = request.getParameter("length");
		String proWidth = request.getParameter("width");
		String proWeigth = request.getParameter("weigth");

		String upLoadFolder = request.getServletContext().getRealPath("/Image");																								// lay duong
																											
		Path upLoadPath = Paths.get(upLoadFolder);
		Part image = request.getPart("uploadImage");
		System.out.println(image.getSize());
		

		String imageFileName = Path.of(image.getSubmittedFileName()).getFileName().toString();

		if (imageFileName != null && !imageFileName.equals("")) {
			
			//Doi ten file theo ten san pham k dau 
			String productName = Endcoding.convertUTF_8(proName) +".png";
			File file = new File(upLoadFolder + File.separator + productName);
			if (!file.exists()) {
				proImage = "Image/" + productName;

				image.write(Paths.get(upLoadPath.toString(), productName).toString());
				productDAO.insert(proName, proDes, Integer.parseInt(proPrice), proImage, Integer.parseInt(proKind),Integer.parseInt(proHeight),Integer.parseInt(proLength),Integer.parseInt(proWidth),Integer.parseInt(proWeigth));
				response.sendRedirect(request.getContextPath()+"/manager_product?access=yes&action=main");

			}else {
				request.setAttribute("listCate", listCate);
				request.setAttribute("imageError", "File đã tồn tại");
				request.getRequestDispatcher("/admin/addProduct1.jsp").forward(request, response);
			}
		}

	}
}
