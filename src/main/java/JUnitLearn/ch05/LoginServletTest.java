package JUnitLearn.ch05;

/**
 * Created by lyk on 2018-1-11.
 * Package name: JUnitLearn.ch05
 * Porject name: untitled1
 */


//import junit.framework.TestCase;
public class LoginServletTest {
//public class LoginServletTest extends TestCase {
//    public void testLoginFailed() throws Exception {
//        MockControl mc = MockControl.createControl(HttpServletRequest.class);
//        HttpServletRequest request = (HttpServletRequest)mc.getMock();
//        // set Mock Object behavior:
//        request.getParameter("username");
//        mc.setReturnValue("admin", 1);
//        request.getParameter("password");
//        mc.setReturnValue("1234", 1);
//        // ok, all behaviors are set!
//        mc.replay();
//        // now start test:
//        LoginServlet servlet = new LoginServlet();
//        try {
//            servlet.doPost(request, null);
//            fail("Not caught exception!");
//        }
//        catch(RuntimeException re) {
//            assertEquals("Login failed.", re.getMessage());
//        }
//        // verify:
//        mc.verify();
//    }
//
//    public void testLoginOK() throws Exception {
//        // create mock:
//        MockControl requestCtrl = MockControl.createControl(HttpServletRequest.class);
//        HttpServletRequest requestObj = (HttpServletRequest)requestCtrl.getMock();
//        MockControl contextCtrl = MockControl.createControl(ServletContext.class);
//        final ServletContext contextObj = (ServletContext)contextCtrl.getMock();
//        MockControl dispatcherCtrl = MockControl.createControl(RequestDispatcher.class);
//        RequestDispatcher dispatcherObj = (RequestDispatcher)dispatcherCtrl.getMock();
//        // set behavior:
//        requestObj.getParameter("username");
//        requestCtrl.setReturnValue("admin", 1);
//        requestObj.getParameter("password");
//        requestCtrl.setReturnValue("123456", 1);
//        contextObj.getNamedDispatcher("dispatcher");
//        contextCtrl.setReturnValue(dispatcherObj, 1);
//        dispatcherObj.forward(requestObj, null);
//        dispatcherCtrl.setVoidCallable(1);
//        // done!
//        requestCtrl.replay();
//        contextCtrl.replay();
//        dispatcherCtrl.replay();
//        // test:
//        LoginServlet servlet = new LoginServlet() {
//            public ServletContext getServletContext() {
//                return contextObj;
//            }
//        };
//        servlet.doPost(requestObj, null);
//        // verify:
//        requestCtrl.verify();
//        contextCtrl.verify();
//        dispatcherCtrl.verify();
//    }
}