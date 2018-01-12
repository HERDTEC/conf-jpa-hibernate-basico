package com.empresa.proyecto.listeners;

import javax.persistence.PostPersist;
import javax.persistence.PrePersist;

public class MonitoreoListener {
	@PrePersist
	public void prePersist(Object obj) {
		System.out.println("Luego de llamar al metodo persist");
		System.out.println("Antes de insertar en la tabla");
	}
	@PostPersist
	public void postPersist(Object obj) {
		System.out.println("Luego de insertar en la tabla");
	}

}
