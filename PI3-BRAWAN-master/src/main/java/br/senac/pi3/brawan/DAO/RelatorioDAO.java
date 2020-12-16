package br.senac.pi3.brawan.DAO;

import br.senac.pi3.brawan.model.Relatorio;
import br.senac.pi3.brawan.utils.ConnectionUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class RelatorioDAO {
    
    Connection connection = ConnectionUtils.getConnection();
    
    public ArrayList<Relatorio> relatorios(String inicio, String fim, String empresa) {
        
        
        String SQL; 
        
        SQL = "SELECT PK_ID,CLIENTE.NOME, FUNCIONARIO.NOME, "
                + "EMPRESA.EMPRESA, QUANTIDADE, DT_VENDA, VL_TOTAL FROM FI_VENDA "
                + "INNER JOIN CLIENTE ON CLIENTE.ID = FI_VENDA.FK_CLIENTE "
                + "INNER JOIN FUNCIONARIO ON FUNCIONARIO.ID = FI_VENDA.FK_CAIXA "
                + "INNER JOIN EMPRESA ON EMPRESA.ID = FI_VENDA.FK_EMPRESA "
                + "WHERE  FI_VENDA.DT_VENDA >= '"+inicio+"' AND FI_VENDA.DT_VENDA <= '"+fim+"' "
                + "AND EMPRESA.EMPRESA='"+empresa+"';";
                
        
        ArrayList<Relatorio> dados = new ArrayList<>();
        
        
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SQL);

            while (rs.next()) {
                
                Relatorio relat = new Relatorio();
                
                relat.setCodigo(rs.getInt("PK_ID"));
                relat.setCliente(rs.getString("CLIENTE.NOME"));
                DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                relat.setDataCompra(formatter.format(rs.getDate("DT_VENDA")));
                relat.setQtdComprado(rs.getInt("QUANTIDADE"));
                relat.setTotFaturado(rs.getFloat("VL_TOTAL"));
                relat.setEmpresa(rs.getString("EMPRESA.EMPRESA"));
                relat.setCaixa(rs.getString("FUNCIONARIO.NOME"));
                dados.add(relat);

            }

            st.close();
            connection.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return dados;

    }

    

    
    
}
