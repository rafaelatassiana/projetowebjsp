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
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

@WebServlet("/deletarCliente")
public class DeletarClienteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Connection connection = ConnectionFactory.getConnection();

        ClienteDAO dao = new ClienteDAO(connection);

        dao.deletar(id);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<script type=\"text/javascript\">");
        out.println("alert('Cliente deletado com sucesso!!!');");
        out.println("location='index.jsp';");
        out.println("</script>");
    }
}
