package com.francisco.app.rest.servicios;

import java.math.BigDecimal;
import java.util.TreeMap;

import com.francisco.app.rest.Entidades.Cuenta;
import com.francisco.app.rest.Entidades.Movimiento;
import com.francisco.app.rest.Entidades.Propietario;
import com.francisco.app.rest.accesodatos.AccesoDatosException;
import com.francisco.app.rest.accesodatos.FabricaDAO;

public class BancoServiciosImpl implements BancoServicios {
	private static BancoServiciosImpl instancia = null;
	private FabricaDAO fabrica;

	public static BancoServiciosImpl crearInstancia(String configuracion) {
		if (instancia == null) {
			return instancia = new BancoServiciosImpl(configuracion);
		} else {
			return instancia;
		}
	}

	public BancoServiciosImpl(String configuracion) {
		try {
			this.fabrica = FabricaDAO.getInstancia(configuracion);
		}catch(AccesoDatosException e) {
			throw new ServiciosException("Error al crear el DAO",e);
		}
	}

	@Override
	public Propietario getPropietarioById(Long id) {

		throw new UnsupportedOperationException("Operacion sin implementar");
	}

	@Override
	public Propietario getPropietarioByName(String nombre) {

		throw new UnsupportedOperationException("Operacion sin implementar");
	}

	@Override
	public Propietario getPropietarioByCuenta(String iban) {

		throw new UnsupportedOperationException("Operacion sin implementar");
	}

	@Override
	public Cuenta getCuentaByIban(String iban) {

		throw new UnsupportedOperationException("Operacion sin implementar");
	}

	@Override
	public TreeMap<Long, Cuenta> getCuentasPropietario(String idpropietario) {

		throw new UnsupportedOperationException("Operacion sin implementar");
	}

	@Override
	public Iterable<Movimiento> getMovimientos(Long id) {

		throw new UnsupportedOperationException("Operacion sin implementar");
	}

	@Override
	public boolean transferencia(Long idCuentaOrigen, Long idCuentaDestino, String concepto, BigDecimal cantidad,
			String divisa) {

		throw new UnsupportedOperationException("Operacion sin implementar");
	}

	@Override
	public Propietario Login(String username, String password) {

		throw new UnsupportedOperationException("Operacion sin implementar");
	}
	public Propietario autenticar(String username,String password) {
		System.out.println("SI2");
		return fabrica.getDAOPropietarioOperaciones().getByUsername(username,password);
		
	}
}
