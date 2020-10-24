package herbert.company.jdbc_Jdev;

import java.awt.List;
import java.util.ArrayList;

import org.junit.Test;

import conexaojdbc.SingleConection;
import dao.nomeTabelaDAO;
import model.nomeTabela;

public class testeBancoJdbc {

	@Test
	public void initBanco() {
		//SingleConection.getConnection();
/*
		nomeTabelaDAO nomeTabelaDAO = new nomeTabelaDAO();
		nomeTabela nomeTabela = new nomeTabela();
		
		nomeTabela.setId(5L);
		nomeTabela.setNome("matheus teste");
		nomeTabela.setEmail("matheus@gmail.com");
		
		nomeTabelaDAO.salvar(nomeTabela);
		*/
	}
	
	@Test
	public void initListar() {
		nomeTabelaDAO dao = new nomeTabelaDAO();
		try {
			ArrayList<nomeTabela> list = dao.listar();
			for (nomeTabela nomeTabela : list) {
				System.out.println(nomeTabela);
				System.out.println("--------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		try {
			nomeTabelaDAO dao = new nomeTabelaDAO();
			nomeTabela nomeTabela =  dao.buscar(5L);
				System.out.println(nomeTabela);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
