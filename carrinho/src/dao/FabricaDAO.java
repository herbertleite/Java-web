package dao;

/**
 *
 * @author ngoncalves
 */
public class FabricaDAO {
    
    public enum DAO {
        PRODUTO_DAO,
        ESPECIFICACAO_DAO
    }
    
    private FabricaDAO() {
    }
    
    public static EntityDAO getDAO(DAO dao) {
        if (dao == DAO.PRODUTO_DAO) 
            return ProdutoDAODummy.getInstance();
        else if (dao == DAO.ESPECIFICACAO_DAO)
            return new EspecificacaoDAO();
        
        return null;
    } 
}
