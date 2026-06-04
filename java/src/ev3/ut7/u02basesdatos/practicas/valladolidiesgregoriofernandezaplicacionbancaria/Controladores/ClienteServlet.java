package ev3.ut7.u02basesdatos.practicas.valladolidiesgregoriofernandezaplicacionbancaria.controladores;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import ev3.ut7.u02basesdatos.practicas.valladolidiesgregoriofernandezaplicacionbancaria.modelos.Cliente;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		// Verificacion de parametros antes de usarlos
		if (usuario == null || password == null || usuario.isBlank() || password.isBlank()) {
			request.setAttribute("error", "(*) Debe introducir nombre y contrasena");
			RequestDispatcher dispatcher = request.getRequestDispatcher("Registro.jsp");
			dispatcher.forward(request, response);
			return; // Termina la ejecucion para evitar continuar con el codigo
		}

		// Si ya hay un usuario autenticado en la sesion, redirige a Cuentas.jsp
		if (session.getAttribute("usuario") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("Cuentas.jsp");
			dispatcher.forward(request, response);
			return;
		}

		// Creacion del cliente y almacenamiento en sesion
		Cliente cliente = new Cliente(usuario, password);
		session.setAttribute("usuario", cliente.getUsuario());
		session.setAttribute("password", cliente.getPassword());

		// Redirigir a Cuentas.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("Cuentas.jsp");
		dispatcher.forward(request, response);
	}
}
