package herbert.company.jdbc_Jdev;

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
		
		nomeTabela.setId(5L);
		nomeTabela.setNome("matheus teste");
		nomeTabela.setEmail("matheus@gmail.com");
		
		nomeTabelaDAO.salvar(nomeTabela);

	}
}
