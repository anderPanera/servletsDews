package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name="ServletConversor", urlPatterns = {"/ServletConversor"})
public class ServletConversor extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Obtener datos del formulario
        request.setCharacterEncoding("utf-8");
        String msg = "";
        float cel = 0;
        float fah = 0;
        if (request.getParameter("celfah") != null) {
        	if (request.getParameter("cel") == "" ) {
        		msg = "ERROR: Debes indicar los celsius";
        	} else {
        		cel = Float.parseFloat(request.getParameter("cel"));
            	fah = cel * 9/5 + 32;
        	}
        } else {
        	if (request.getParameter("fah") == "") {
        		msg = "ERROR: Debes indicar los fahrenheit";
        	} else {
	        	fah = Float.parseFloat(request.getParameter("fah"));
	        	cel = (fah - 32) * 5/9;
        	}
        }
        
        
        
        //Crear respuesta
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            out.println("<html>");
            out.println("<head><title>Resultado de la conversion</title></head>");
            out.println("<body>");
            if (msg == "") {
            	out.println("<h1><strong>Resultado de la conversion:</strong></h1>");
                out.println("<p><strong>Valor en celsius:</strong> " + cel + " </p>");
                out.println("<p><strong>Valor en fahrenheit:</strong> " + fah + " </p>");
            } else {
            	out.println("<p>" + msg + "</p>");
            }
            out.println("<a href='files/conversorCF.html'>Enlace para volver al formulario</a>");
            out.println("</body>");
            out.println("</html>");
        } finally {
        }
    }
	
}
