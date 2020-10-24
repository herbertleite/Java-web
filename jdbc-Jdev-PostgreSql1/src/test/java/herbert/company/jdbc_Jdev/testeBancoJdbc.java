package herbert.company.jdbc_Jdev;

import org.junit.Test;

import conexaojdbc.SingleConection;

public class testeBancoJdbc {

	@Test
	public void initBanco() {
		SingleConection.getConnection();

	}
}
