package service;

import dao.INotaFiscalCabDAO;
import dao.INotaFiscalDetDAO;
import domain.NotaFiscalDet;
import exception.TipoChaveNaoEncontradaException;

public class NotaFiscalDetService implements INotaFiscalDetService{
    private INotaFiscalDetDAO notaFiscalDetDAO;
    public NotaFiscalDetService(INotaFiscalDetDAO notaFiscalDetDAO) {
        this.notaFiscalDetDAO = notaFiscalDetDAO;
    }

    @Override
    public Boolean salvar(NotaFiscalDet notaFiscalDet) throws TipoChaveNaoEncontradaException {
        return notaFiscalDetDAO.cadastrar(notaFiscalDet);
    }

    @Override
    public NotaFiscalDet buscarPorCodigo(Long numeroNF) {
        return notaFiscalDetDAO.consultar(numeroNF);
    }

    @Override
    public Boolean excluir(Long numeroNF) {
        return notaFiscalDetDAO.excluir(numeroNF);
    }

    @Override
    public void alterar(NotaFiscalDet notaFiscalDet) throws TipoChaveNaoEncontradaException {
        notaFiscalDetDAO.alterar(notaFiscalDet);
    }
}
