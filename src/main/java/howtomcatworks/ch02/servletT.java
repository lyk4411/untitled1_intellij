package howtomcatworks.ch02;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by lyk on 2019-3-11.
 * Package name: howtomcatworks.ch02
 * Porject name: untitled1
 */

public class servletT implements Servlet {

    public servletT(){
        super();
    }


    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("from hello world.");
        PrintWriter out = response.getWriter();
        out.println("Hello. Roses are red.");
        out.print("Violets are blue.");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}