package com.ipartek.formacion.mf0967_3.modelo;

import java.math.BigDecimal;

public class Libro {
	private Long id;
	private String imagen, descripcion, autor;
	private BigDecimal precio, descuento;
	
	private String errorId, errorDescripcion, errorPrecio, errorDescuento;
	private boolean error = false;
	
	public Libro(String id, String imagen, String descripcion, String autor, String precio, String descuento) {
		try {
			Long l = Long.parseLong(id);
			setId(l);
		} catch (NumberFormatException e) {
			setErrorId("El id DEBE ser un número");
		}
		
		setImagen(imagen);
		setDescripcion(descripcion);
		setAutor(autor);
		
		try {
			BigDecimal p = new BigDecimal(precio);
			setPrecio(p);
		} catch (Exception e) {
			setErrorPrecio("El precio debe ser un número");
		}

		try {
			BigDecimal d = new BigDecimal(descuento).divide(new BigDecimal(100));
			setDescuento(d);
		} catch (Exception e) {
			setErrorDescuento("El descuento debe ser un número");
		}
	}
	
	public Libro(Long id, String imagen, String descripcion, String autor, BigDecimal precio, BigDecimal descuento) {
		setId(id);
		setImagen(imagen);
		setDescripcion(descripcion);
		setAutor(autor);
		setPrecio(precio);
		setDescuento(descuento);
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id != null && id < 0) {
			setErrorId("El Id debe ser positivo");
		}
		
		this.id = id;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		if(descripcion == null || descripcion.trim().length() == 0) {
			setErrorDescripcion("No se admiten descripciones vacías");
		}
		this.descripcion = descripcion;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		if(precio == null || precio.doubleValue() < 0) {
			setErrorPrecio("El precio debe ser positivo");
		}
		this.precio = precio;
	}
	public BigDecimal getDescuento() {
		return descuento;
	}
	public void setDescuento(BigDecimal descuento) {
		if(descuento == null || descuento.compareTo(new BigDecimal(0)) < 0 || descuento.compareTo(new BigDecimal(1)) > 0) {
			setErrorDescuento("Sólo se admiten descuentos positivos o 0 hasta el 100%");
		}
		this.descuento = descuento;
	}
	
	public BigDecimal getPrecioConDescuento() {
		return precio.multiply(new BigDecimal(1).subtract(descuento));
	}
	
	public boolean isError() {
		return error;
	}

	private void setError(boolean error) {
		this.error = error;
	}

	public String getErrorId() {
		return errorId;
	}

	public void setErrorId(String errorId) {
		setError(true);
		this.errorId = errorId;
	}

	public String getErrorDescripcion() {
		return errorDescripcion;
	}

	public void setErrorDescripcion(String errorDescripcion) {
		setError(true);
		this.errorDescripcion = errorDescripcion;
	}

	public String getErrorPrecio() {
		return errorPrecio;
	}

	public void setErrorPrecio(String errorPrecio) {
		setError(true);
		this.errorPrecio = errorPrecio;
	}

	public String getErrorDescuento() {
		return errorDescuento;
	}

	public void setErrorDescuento(String errorDescuento) {
		setError(true);
		this.errorDescuento = errorDescuento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((autor == null) ? 0 : autor.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((descuento == null) ? 0 : descuento.hashCode());
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		if (autor == null) {
			if (other.autor != null)
				return false;
		} else if (!autor.equals(other.autor))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (descuento == null) {
			if (other.descuento != null)
				return false;
		} else if (!descuento.equals(other.descuento))
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Libro [imagen=" + imagen + ", descripcion=" + descripcion + ", autor=" + autor + ", precio=" + precio
				+ ", descuento=" + descuento + "]";
	}
	
	
}
