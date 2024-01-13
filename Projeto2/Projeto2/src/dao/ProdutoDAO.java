package dao;

import dao.generics.GenericDAO;
import domain.Produto;

public class ProdutoDAO extends GenericDAO<Produto> implements IClienteDAO.IProdutoDAO {

    public ProdutoDAO() {
        super();
    }
    @Override
    public Class<Produto> getTipoClasse() {
        return Produto.class;
    }

    @Override
    public void atualizarDados(Produto entity, Produto entityCadastrado) {

    }
}
