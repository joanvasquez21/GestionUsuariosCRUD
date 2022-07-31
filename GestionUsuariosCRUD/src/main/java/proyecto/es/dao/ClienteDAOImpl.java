package proyecto.es.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.*;
import proyecto.es.controlador.entidades.Cliente;

@Repository
public class ClienteDAOImpl implements ClienteDAO {

	@Override
	@Transactional
	public List<Cliente> getClientes() {
		// Obtenemos la session
		Session miSession = sessionFactory.getCurrentSession();
		// Creamos la query(consulta)
		Query<Cliente> miQuery = miSession.createQuery("from Cliente", Cliente.class);
		// Ejecutar la query y devover resultados
		List<Cliente> clientes = miQuery.getResultList();

		return clientes;
	}

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void insertarCliente(Cliente elCliente) {
		// Aqui se construira lo necesario para ingresar registros
		Session miSession = sessionFactory.getCurrentSession();

		miSession.save(elCliente);

	}

}
