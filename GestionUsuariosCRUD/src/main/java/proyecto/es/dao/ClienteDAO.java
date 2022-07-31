package proyecto.es.dao;

import java.util.List;

import proyecto.es.controlador.entidades.Cliente;

public interface ClienteDAO {
	public List<Cliente> getClientes();

	public void insertarCliente(Cliente elCliente);

}
