package service;

import dao.IProdutoDAO;
import domain.Produto;
import exception.TipoChaveNaoEncontradaException;

public class ProdutoService implements IProdutoService{
    private IProdutoDAO produtoDAO;
    public ProdutoService(IProdutoDAO produtoDAO) {
        this.produtoDAO = produtoDAO;
    }

    @Override
    public Boolean salvar(Produto produto) throws TipoChaveNaoEncontradaException {
        return produtoDAO.cadastrar(produto);
    }

    @Override
    public Produto buscarPorCodigo(Long codigo) {
        return produtoDAO.consultar(codigo);
    }

    @Override
    public Boolean excluir(Long codigo) {
        return produtoDAO.excluir(codigo);
    }

    @Override
    public void alterar(Produto produto) throws TipoChaveNaoEncontradaException {
        produtoDAO.alterar(produto);
    }
}
