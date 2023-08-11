package br.com.shoeshappy;

import dao.ClienteDAO;
import infra.ConnectionFactory;
import model.Cliente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

@WebServlet("/criar")
public class CriarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String matricula = request.getParameter("matricula");
        String endereco = request.getParameter("endereco");
        Integer tipoPessoa = Integer.parseInt(request.getParameter("tipoPessoa"));

        Cliente cliente = new Cliente(nome, matricula,endereco, tipoPessoa);

        Connection connection = ConnectionFactory.getConnection();

        ClienteDAO dao = new ClienteDAO(connection);

        dao.salvar(cliente);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<script type=\"text/javascript\">");
        out.println("alert('Cliente criado com sucesso!!!');");
        out.println("location='index.jsp';");
        out.println("</script>");
    }
}
