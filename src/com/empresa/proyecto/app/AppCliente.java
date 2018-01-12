package com.empresa.proyecto.app;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.empresa.proyecto.entity.Cliente;

public class AppCliente {
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("test1jp");
		// registrar();
		// listar();
		// buscar(7);
		// eliminar(5);  listar();
		 actualizar(7, "Andrea", "Zapata"); listar();
		System.out.println("Fin");
	}

	private static void registrar() {
		Cliente cliente = new Cliente();
		// cliente.setCodigo(3);
		cliente.setApellido("Cuichan2");
		cliente.setNombre("Paul2");
		cliente.setFecha(new Date(Calendar.getInstance().getTime().getTime()));
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
		em.close();

	}

	private static void listar() {
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("from Cliente");
		List<Cliente> clientes = q.getResultList();
		for (Cliente c : clientes) {
			System.out.println("Id: "+c.getCodigo()+"\n"+"Nombre: " + c.getNombre() + "\nApellido: " + c.getApellido() + "\n ");
		}
	}

	private static void actualizar(Integer id, String nombre, String apellido) {

		// Obtener
		EntityManager em = emf.createEntityManager();
		Cliente c = em.find(Cliente.class, id);

		// Modificar
		c.setNombre(nombre);
		c.setApellido(apellido);

		// Actualizar
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
		em.close();

	}

	private static void eliminar(Integer id) {

		// Obtener
		EntityManager em = emf.createEntityManager();
		Cliente c = em.find(Cliente.class, id);

		em.getTransaction().begin();
		em.remove(c);
		em.getTransaction().commit();
		em.close();

	}

	private static void buscar(Integer id) {

		EntityManager em = emf.createEntityManager();
		Cliente c = em.find(Cliente.class, id);
		em.close();

		System.out.println("Nombre: " + c.getNombre());
		System.out.println("Apellido: " + c.getApellido());

	}

}
