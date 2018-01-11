package JUnitLearn.ch05;

/**
 * Created by lyk on 2018-1-11.
 * Package name: JUnitLearn.ch05
 * Porject name: untitled1
 */


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // check username &amp; password:
        if("admin".equals(username) && "123456".equals(password)) {
            ServletContext context = getServletContext();
            RequestDispatcher dispatcher = context.getNamedDispatcher("dispatcher");
            dispatcher.forward(request, response);
        }
        else {
            throw new RuntimeException("Login failed.");
        }
    }
}