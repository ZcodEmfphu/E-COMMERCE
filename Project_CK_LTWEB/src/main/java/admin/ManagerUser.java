package admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import contanst.Status;
import dao.UserDAO;
import model.User;

@WebServlet("/manager_user")
public class ManagerUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ManagerUser() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");

        UserDAO userDAO = new UserDAO();
        String action = request.getParameter("action");
        String update = request.getParameter("updateUser");
        String access = request.getParameter("access");

        if (access != null) {
            request.setAttribute("access", access);
        }

        if (action != null) {
            if (action.equals("edit")) {
                String eUserId = request.getParameter("eUserId");
                User user = userDAO.getUser(Integer.parseInt(eUserId));
                request.setAttribute("eUser", user);
                request.getRequestDispatcher("/admin/userEdit.jsp").forward(request, response);
            } else if (action.equals("detail")) {
                String eUserId = request.getParameter("eUserId");
                User user = userDAO.getUser(Integer.parseInt(eUserId));
                request.setAttribute("eUser", user);
                request.getRequestDispatcher("/admin/detailUser.jsp").forward(request, response);
            }
        } else if (update != null) {
            String userId = request.getParameter("userId");
            String userFullname = request.getParameter("userFullname");
            String userPhone = request.getParameter("userPhone");
            String userAddress = request.getParameter("userAddress");
            String userName = request.getParameter("userName");
            String userPassword = request.getParameter("userPassword");
            String userRole = request.getParameter("userRole");

            User userUpdate = new User(Integer.parseInt(userId), userFullname, userPhone, userAddress, userName,
                    userPassword, Integer.parseInt(userRole));
            userDAO.updateUser(userUpdate);

            response.sendRedirect(request.getContextPath() + "/manager_user?access=yes");
        } else {
            List<User> listUser = userDAO.getUserByRolId(2, Status.ACTIVE);
            request.setAttribute("listUser", listUser);
            request.getSession().setAttribute("langeName", "vi_VN");
            request.getRequestDispatcher("/admin/manager_user.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		doGet(request, response);
	}
}
