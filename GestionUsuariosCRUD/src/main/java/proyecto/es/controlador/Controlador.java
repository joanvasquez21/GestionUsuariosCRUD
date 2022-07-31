package proyecto.es.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import proyecto.es.controlador.entidades.Cliente;
import proyecto.es.dao.ClienteDAO;
import proyecto.es.dao.ClienteDAOImpl;

@Controller
@RequestMapping("/cliente")
public class Controlador {
	
	@Autowired
	private ClienteDAO clienteDAO;
	
	
	
	@RequestMapping("/lista")
	public String viewCliente(Model elModelo) {
	//Lista clientes: obtener los clientes desde el DAO
		List<Cliente> losClientes =  clienteDAO.getClientes();
	//Agregar los clientes al modelo(items)
		elModelo.addAttribute("clientes", losClientes);
	
		return "listaclientes";
	}
	
	//Crearemos el mapeo a nuestro formulario para ingresar los registros
	
	@RequestMapping("/formularioCliente")
	public String muestraFormularioAgregar(Model elModelo) {
		//que nos devuelva el formulario cliente
		//Bin de datos Clientes
		Cliente elCliente = new Cliente();
		elModelo.addAttribute(elCliente);
		
		return "formularioCliente";
		
	}
	
	@PostMapping("/insertarCliente")
	public String insertarCliente(@ModelAttribute("cliente") Cliente elCliente) {
		//Este metodo se encargara de insertar registros en la base de datos
		
		clienteDAO.insertarCliente(elCliente);
		
		return "redirect:/cliente/lista";
	}
	
	//Get obtenemos el ID por la URL
	@GetMapping("/formularioActualizar")
	public String formularioActualizar(@RequestParam("idCliente") int id, Model elModelo) {
	
		// Obtener el cliente cuyo ID lo estamos pasando por el parametro (URL)
		Cliente elCliente = clienteDAO.getCliente(id);
		// Establecemos el cliente como atributo del modelo
		elModelo.addAttribute("cliente", elCliente);
				
		return "formularioCliente";
	}
	
	//Get para eliminar  
	@GetMapping("/eliminar")
	public String eliminarCliente(@RequestParam("idCliente") int id, Model elModelo) {
	
		// Eliminar el cliente
		clienteDAO.eliminarCliente(id);
		
		// Redireccionar a la lista de cliente
				
		return "redirect:/cliente/lista";
	}
	
	
}
