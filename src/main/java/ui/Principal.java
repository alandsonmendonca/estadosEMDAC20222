package ui;

import dao.ContaDao;
import entidade.Conta;

public class Principal {
	public static void main(String[] args) {
//		Conta c1 = new Conta();
//		c1.setNumero("1234-5");
		
		Conta c1 = ContaDao.acharPorId(28);
		
		ContaDao.remover(c1);
		
		System.out.println(ContaDao.listar());
	}
}
