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

		nomeTabelaDAO nomeTabelaDAO = new nomeTabelaDAO();
		nomeTabela nomeTabela = new nomeTabela();
		
		//nomeTabela.setId(5L);aqui ja ja colocou o sequence nao precisa mais setar o id reajustei em salvar
		nomeTabela.setNome("matheus teste");
		nomeTabela.setEmail("matheus@gmail.com");
		
		nomeTabelaDAO.salvar(nomeTabela);
		
	}
	
	@Test
	public static void initListar() {
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
	
	@Test
	public void initAtualizar() {
		try {
			nomeTabelaDAO dao = new nomeTabelaDAO();
			nomeTabela objetoBanco =  dao.buscar(5L);
			objetoBanco.setNome("Atualizado");
			dao.atualizar(objetoBanco);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDeletar() {
		try {
			nomeTabelaDAO dao = new nomeTabelaDAO();
			dao.deletar(7L);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String args[]) {
		initListar();
	}
	
	
}
