package org.alumno.carlos.carlos_primer_app_spring_mvc.model.interfaces;

import java.util.Date;

public interface Modificable<AnyType> {
	public Date getTs();

	public void setTs(Date ts);

	public String getUser();

	public void setUser(String user);

	public boolean sePuedeModificarUtilizando(AnyType itemModificado);

	public String noSePuedeModificar();

}