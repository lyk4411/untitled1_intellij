package JUnitLearn.ch04;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.easymock.EasyMock.*;
/**
 * Created by lyk on 2018-1-11.
 * Package name: JUnitLearn.ch04
 * Porject name: untitled1
 */

public class servletDoTest extends TestCase {

    private servletDo servlet;
    private HttpServletRequest mockRequest;
    private HttpServletResponse mockResponse;

    @Before
    public void setUp(){
        servlet = new servletDo();

        mockRequest = createMock(HttpServletRequest.class);                          //加载
        mockResponse = createMock(HttpServletResponse.class);
    }

    @After
    public void tearDown(){
        verify(mockRequest);                //验证
        verify(mockResponse);
    }



    @Test
    public void testDoPostHttpServletRequestHttpServletResponse() {

        mockRequest.getParameter("username");
        expectLastCall().andReturn("allen");//传入参数

        mockRequest.getParameter("password");
        expectLastCall().andReturn("12345");//传入参数


        replay(mockRequest);                                           //回放
        replay(mockResponse);



        try {
            servlet.doPost(mockRequest, mockResponse);
        } catch (ServletException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //调用
        assertTrue(true);

    }

}