package br.com.shoeshappy;

import dao.ClienteDAO;
import infra.ConnectionFactory;
import model.Cliente;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

@WebServlet("/listaClientes")
public class ListaClienteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = ConnectionFactory.getConnection();

        ClienteDAO dao = new ClienteDAO(connection);

        List<Cliente>clientes = dao.listarTodos();

        request.setAttribute("clientes", clientes);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/lista-clientes.jsp");
        dispatcher.forward(request, response);
    }
}
