package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.ConversorCF;


@WebServlet(name="ServletConversor", urlPatterns = {"/ServletConversor"})
public class ServletConversor extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        //Obtener datos del formulario
        request.setCharacterEncoding("utf-8");
        String msg = "";
        ConversorCF temperatura = new ConversorCF(0, 'c');
        if (request.getParameter("celfah") != null) {
        	if (request.getParameter("cel") == "" ) {
        		msg = "ERROR: Debes indicar los celsius";
        	} else {
        		temperatura = new ConversorCF(Float.parseFloat(request.getParameter("cel")), 'c');
        	}
        } else {
        	if (request.getParameter("fah") == "") {
        		msg = "ERROR: Debes indicar los fahrenheit";
        	} else {
        		temperatura = new ConversorCF(Float.parseFloat(request.getParameter("fah")), 'f');
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
                out.println("<p><strong>Valor en celsius:</strong> " + temperatura.getCelsius() + " </p>");
                out.println("<p><strong>Valor en fahrenheit:</strong> " + temperatura.getFahrenheit() + " </p>");
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
