package servlet;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * 1、编译：由于使用了tomcat里lib下的servlet-api.jar，所以编译时需要这样：javac -cp D:\apache-tomcat-7.0.93\lib\servlet-api.jar MyServlet.java
 * 2、修改web.xml:增加以下内容
 *      <servlet>
 *       <servlet-name>MyServlet</servlet-name>
 *       <servlet-class>MyServlet</servlet-class>
 *     </servlet>
 *     <servlet-mapping>
 *         <servlet-name>MyServlet</servlet-name>
 *         <url-pattern>/MyServlet</url-pattern>
 *     </servlet-mapping>
 * 3、启动tomcat：由于tomcat默认访问webapps下的ROOT下的WEB-INF，所以直接在WEB-INF下新建classes文件，将MyServlet.class放入，然后startup.bat启动tomcat
 * 4、访问：localhost:8080/MyServlet 显示Hello World，成功
 */
public class MyServlet extends HttpServlet {

    private String message;

    public void init() throws ServletException {
        message = "Hello World";
    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.println("<h1>" + message + "</h1>");
    }

    public void destroy() {
    }

}
