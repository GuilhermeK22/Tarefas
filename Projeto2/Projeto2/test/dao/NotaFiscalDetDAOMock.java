package dao;

import domain.NotaFiscalDet;
import exception.TipoChaveNaoEncontradaException;

import java.util.Collection;

public class NotaFiscalDetDAOMock implements INotaFiscalDetDAO{
    @Override
    public Boolean cadastrar(NotaFiscalDet entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public Boolean excluir(Long valor) {
        return true;
    }

    @Override
    public void alterar(NotaFiscalDet entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public NotaFiscalDet consultar(Long valor) {
        NotaFiscalDet notaFiscalDet = new NotaFiscalDet();
        notaFiscalDet.setNumeroNF(valor);
        return notaFiscalDet;
    }

    @Override
    public Collection<NotaFiscalDet> buscarTodos() {
        return null;
    }
}
