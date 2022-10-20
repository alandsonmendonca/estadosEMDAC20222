package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import entidade.Conta;
import util.JPAUtil;

public class ContaDao {
	public static void salvar(Conta c) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void editar(Conta c) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		Conta c2 = em.merge(c);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void remover(Conta c) {
		EntityManager em = JPAUtil.criarEntityManager();
		em.getTransaction().begin();
		c = em.find(Conta.class, c.getId());
		em.remove(c);
		System.out.println(em.getProperties());
//		em.getTransaction().commit();
		em.close();
	}
	
	public static Conta acharPorId(Integer id) {
		EntityManager em = JPAUtil.criarEntityManager();
		Conta c = em.find(Conta.class, id);
		em.close();
		return c;
	}
	
	public static List<Conta> listar(){
		EntityManager em = JPAUtil.criarEntityManager();
		Query q = em.createQuery("select c from Conta c");
		List<Conta> lista = q.getResultList();
		em.close();
		return lista;
	}
}
