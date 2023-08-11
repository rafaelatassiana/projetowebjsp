package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Cliente;

public class ClienteDAO implements IClienteDAO {
    private final Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        try {
            String[] returnId = { "BATCHID" };

            String sql = "INSERT INTO Cliente (nome, matricula, endereco, tipoPessoa) VALUES (?, ?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql, returnId);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getMatricula());
            preparedStatement.setString(3, cliente.getEndereco());
            preparedStatement.setInt(4, cliente.getTipoPessoa());

            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();

            preparedStatement.close();
            resultSet.close();
        }
        catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return cliente;
    }

    @Override
    public List<Cliente> listarTodos() {
        String sql = "SELECT id, nome, matricula, endereco, tipopessoa FROM Cliente";

        List<Cliente> clientes = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long id = rs.getLong("id");
                String nome = rs.getString("nome");
                String matricula = rs.getString("matricula");
                String endereco = rs.getString("endereco");
                Integer tipopessoa = rs.getInt("tipopessoa");

                Cliente cliente = new Cliente(id, nome, matricula, endereco, tipopessoa);
                clientes.add(cliente);
            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return clientes;
    }

    @Override
    public void deletar(Long id) {
        try {
            String sql = "DELETE FROM Cliente WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Optional<Cliente> listarPorId(Long id) {
        String sql = "SELECT id, nome, matricula, endereco, tipopessoa FROM cliente WHERE id = ?";

        Cliente cliente = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Long pKey = rs.getLong("id");
                String nome = rs.getString("nome");
                String matricula = rs.getString("matricula");
                String endereco = rs.getString("endereco");
                Integer tipopessoa = Integer.parseInt(rs.getString("tipopessoa"));

                cliente = new Cliente(pKey, nome, matricula, endereco, tipopessoa);
            }

            preparedStatement.close();
            rs.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return Optional.ofNullable(cliente);
    }

    @Override
    public Cliente update(Cliente cliente) {
        try {
            String sql = "UPDATE Cliente SET nome = ?, matricula = ?, endereco = ?, tipopessoa = ? WHERE id = ?;";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getMatricula());
            preparedStatement.setString(3, cliente.getEndereco());
            preparedStatement.setInt(4, cliente.getTipoPessoa());
            preparedStatement.setLong(5, cliente.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return cliente;
    }    
}
