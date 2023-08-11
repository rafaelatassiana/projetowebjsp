package dao;

import model.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteDAO {
    Cliente salvar(Cliente cliente);

    List<Cliente> listarTodos();

    void deletar(Long id);

    Optional<Cliente> listarPorId(Long id);

    Cliente update(Cliente cliente);
}
