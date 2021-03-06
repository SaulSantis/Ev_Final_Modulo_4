package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import implementacion.CapacitacionImpl;
import modelo.Capacitacion;

/**
 * Servlet implementation class listarCapServlet
 */
@WebServlet("/ListarCapServlet")
public class ListarCapServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarCapServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		HttpSession misesion = request.getSession();
				
		if (misesion == null) {
			response.sendRedirect("login");
		}
		else {
			CapacitacionImpl capacitacionimpl = new CapacitacionImpl();
			List<Capacitacion> listado = capacitacionimpl.obtenerCapacitacion();
			request.setAttribute("lcapacitacion", listado);
			request.getRequestDispatcher("listarCapacitacion.jsp").forward(request, response);
		}
	}	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
