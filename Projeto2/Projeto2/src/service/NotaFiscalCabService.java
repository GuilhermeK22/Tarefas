package service;

import dao.INotaFiscalCabDAO;
import domain.NotaFiscalCab;
import exception.TipoChaveNaoEncontradaException;

public class NotaFiscalCabService implements INotaFiscalCabService{

    private INotaFiscalCabDAO notaFiscalCabDAO;

    public NotaFiscalCabService(INotaFiscalCabDAO notaFiscalCabDAO) {
        this.notaFiscalCabDAO = notaFiscalCabDAO;
    }

    @Override
    public Boolean salvar(NotaFiscalCab notaFiscalCab) throws TipoChaveNaoEncontradaException {
        return notaFiscalCabDAO.cadastrar(notaFiscalCab);
    }

    @Override
    public NotaFiscalCab buscarPorCodigo(Long numeroNF) {
        return notaFiscalCabDAO.consultar(numeroNF);
    }

    @Override
    public Boolean excluir(Long numeroNF) {
        return notaFiscalCabDAO.excluir(numeroNF);
    }

    @Override
    public void alterar(NotaFiscalCab notaFiscalCab) throws TipoChaveNaoEncontradaException {
        notaFiscalCabDAO.alterar(notaFiscalCab);
    }
}
