package chatprivado.models;

public class Usuario {
	private Long id;
	private String username,password;
	private boolean error;
	private String errorUsuario,errorPassword,errorId;
	public Usuario(Long id, String username, String password) {
		setId(id);
		setUsername(username);
		setPassword(password);	
	}
	public Usuario(String username, String password) {
		setUsername(username);
		setPassword(password);	
	}
	
	public Usuario(String username) {
		setUsername(username);
	}
	public Usuario(Long id) {
		setId(id);
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		if(id == null || id <= 0) {
			setError(true);
			setErrorId("El usuario debe ser un numero positivo");
		}
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		if(username==null || username.length()<7) {
			setError(true);
			setErrorPassword("El usuario debe contener minimo 7 caracteres");
		}
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		if(password==null || password.length()<7) {
			setError(true);
			setErrorPassword("El password debe contener minimo 7 caracteres");
		}
		this.password = password;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getErrorUsuario() {
		return errorUsuario;
	}
	public void setErrorUsuario(String errorUsuario) {
		this.errorUsuario = errorUsuario;
	}
	public String getErrorPassword() {
		return errorPassword;
	}
	public void setErrorPassword(String errorPassword) {
		this.errorPassword = errorPassword;
	}
	public String getErrorId() {
		return errorId;
	}
	public void setErrorId(String errorId) {
		this.errorId = errorId;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Usuario other = (Usuario) obj;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + username + ", password=" + password + "]";
	}
	
}
