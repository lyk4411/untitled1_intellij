package JUnitLearn.ch04;

/**
 * Created by lyk on 2018-1-11.
 * Package name: JUnitLearn.ch04
 * Porject name: untitled1
 */

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloWorld extends HttpServlet{

    public void saveToSession(HttpServletRequest request) {

        request.getSession().setAttribute("testAttribute",request.getParameter("testparam"));

    }

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{

        String username=request.getParameter("username");

        response.getWriter().write(username+":Hello World!");

    }

    public boolean authenticate(){

        return true;

    }

}
