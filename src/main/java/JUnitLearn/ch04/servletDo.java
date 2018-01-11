package JUnitLearn.ch04;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lyk on 2018-1-11.
 * Package name: JUnitLearn.ch04
 * Porject name: untitled1
 */


public class servletDo extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost( request,  response);

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("username:"+name);
        System.out.println("password:"+password);
    }


    public void init() throws ServletException {
        // Put your code here
    }

}