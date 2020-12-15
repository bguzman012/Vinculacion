package astronet.ec.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import astronet.ec.modelo.Agendamiento;
import astronet.ec.modelo.Cliente;
import astronet.ec.modelo.Registro;
import astronet.ec.modelo.Servicio;

@Stateless
public class RegistroDAO {
	
	@Inject
	private EntityManager em;
	
	public void save(Registro reg) {
		if (this.read(reg.getId())!=null) {
			this.update(reg);
		}else 
			this.create(reg);
	}
	
	public void create(Registro reg) {
		em.persist(reg);
		
	}
	
	public void update(Registro reg) {
		em.merge(reg);
		
	}
	
	public Registro read(int id) {
		return em.find(Registro.class, id);
		
	}
	
	public Registro read3(int id) {
		String jpql = "SELECT reg FROM Registro reg   WHERE reg.id = :a";
		Query q = em.createQuery(jpql, Registro.class);
		q.setParameter("a", id);
		Registro reg = (Registro) q.getSingleResult();
		
		for (int i = 0; i < reg.getCliente().getServicio().size(); i++) {
			reg.getCliente().getServicio().get(i).getIp();
			reg.getCliente().getServicio().get(i).getPlan();
			reg.getCliente().getServicio().get(i).getPassword();
		}
				
		return reg;

	}
	
	public List<Registro> listarRegistrosVT() {
		
		String estado="VISITA TECNICA";
		String jpql = "SELECT reg FROM Registro reg  WHERE reg.accion = :a";
		Query q = em.createQuery(jpql, Registro.class);
		q.setParameter("a", estado);
		List<Registro> registros = q.getResultList();
		for (Registro registro : registros) {
			registro.getCliente().getAntena().getId();
			//registro.getAgendamiento().get(0).getFecha();
			//registro.getAgendamiento().size();
			registro.getCliente().getCedula();
			registro.getEmpleado().getCelular();
			registro.getCliente().getServicio().get(0).getIp();
			//registro.getCliente().getServicio().size();
		}
		return registros;
	}
	
	public Registro getBusquedaClienteId(int filBusqueda){
		String jpql="SELECT r FROM Registro r   "
				    +" WHERE r.id = :filtro ";
		Query q=em.createQuery(jpql, Registro.class);
		q.setParameter("filtro", filBusqueda);
			
		Registro clientes=(Registro) q.getSingleResult();

		System.out.println(clientes);
		return clientes;
	}
	
		
	public List<Registro> listarRegistros() {
		String jpql = "SELECT reg FROM Registro reg ";
		Query q = em.createQuery(jpql, Registro.class);
		List<Registro> registros = q.getResultList();
		for (Registro registro : registros) {
			registro.getCliente().getNombre();
			registro.getCliente().getDireccionPrincipal();
			registro.getCliente().getApellidos();
			registro.getCliente().getLatitud();
			registro.getCliente().getLongitud();
			registro.getEmpleado().getNombre();
			for (int i = 0; i < registro.getAgendamiento().size(); i++) {
				registro.getAgendamiento().get(i).getTecnicoResponsable();
			}
		}
		return registros;
	}
	
}
