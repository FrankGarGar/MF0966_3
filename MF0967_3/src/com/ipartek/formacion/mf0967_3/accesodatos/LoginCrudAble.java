package com.ipartek.formacion.mf0967_3.accesodatos;

import com.ipartek.formacion.mf0967_3.modelo.Login;

public interface LoginCrudAble extends CrudAble<Login> {
	Login getByEmail(String email);
}
