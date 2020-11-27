package astronet.ec.on;

import javax.ejb.Stateless;
import javax.inject.Inject;

import astronet.ec.dao.ServicioDAO;
import astronet.ec.modelo.Servicio;

@Stateless
public class ServicioON {
	
	@Inject
	private ServicioDAO serdao;
	
	public void guardar(Servicio ser) {
		serdao.save(ser);
	}
	
	public void actualizar(Servicio ser) {
		serdao.update(ser);
	}

}
