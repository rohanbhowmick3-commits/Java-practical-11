import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getCookie")
public class GetCookieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Cookie[] cookies = request.getCookies();

        out.println("<html><body>");

        if (cookies != null) {

            for (Cookie cookie : cookies) {

                if (cookie.getName().equals("username")) {
                    out.println("<h2>User Name: "
                            + cookie.getValue()
                            + "</h2>");
                }
            }

        } else {
            out.println("<h2>No Cookie Found</h2>");
        }

        out.println("</body></html>");
    }
}
