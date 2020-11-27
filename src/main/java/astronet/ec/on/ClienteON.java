package astronet.ec.on;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.ClienteDAO;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.Servicio;

@Stateless
public class ClienteON {

	@Inject
	private ClienteDAO clidao;
	@Inject
	private Registro registro;
	
	

	public void guardar(Cliente cli) {

		clidao.save(cli);
	}
	
	public void guardarCliente(Cliente cli) {
		clidao.create(cli);
	}
	
	public void actualizar (Cliente cli) {
		clidao.update(cli);
	}
	
	
	public List<Cliente> getListadoCliente() {
		return clidao.getCliente();
	}

	public Cliente getCliente(int cedula) {
		Cliente aux = clidao.read3(cedula);
		System.out.println("Prueba: " + " " + clidao.read3(cedula));
		return aux;
	}

	public Cliente getClienteCedula(String cedula) {
		Cliente aux = clidao.buscarCedula(cedula);
		registro.setIdClienteTemp(aux.getId());
		System.out.println(aux.getCedula());
		System.out.println(aux.getNombre());
		for (int j = 0; j < aux.getServicio().size(); j++) {

			System.out.println(aux.getServicio().get(j).getIp());
			System.out.println(aux.getServicio().get(j).getPassword());
			System.out.println(aux.getServicio().get(j).getPlan());
		}

		return aux;
	}

	public Cliente getClienteNombre(String nombre) {
		Cliente aux = clidao.buscarNombre(nombre);
		System.out.println(aux.getCedula());
		System.out.println(aux.getNombre());
		for (int j = 0; j < aux.getServicio().size(); j++) {
			System.out.println(aux.getServicio().get(j).getIp());
			System.out.println(aux.getServicio().get(j).getPassword());
			System.out.println(aux.getServicio().get(j).getPlan());
		}

		return aux;
	}
	
	public void dato() {
		
		System.out.println("hola datos");
	}

}
