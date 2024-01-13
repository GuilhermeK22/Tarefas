package dao;

import domain.NotaFiscalCab;
import exception.TipoChaveNaoEncontradaException;

import java.util.Collection;

public class NotaFiscalCabDAOMock implements INotaFiscalCabDAO{
    @Override
    public Boolean cadastrar(NotaFiscalCab entity) throws TipoChaveNaoEncontradaException {
        return true;
    }

    @Override
    public Boolean excluir(Long valor) {
        return true;
    }

    @Override
    public void alterar(NotaFiscalCab entity) throws TipoChaveNaoEncontradaException {

    }

    @Override
    public NotaFiscalCab consultar(Long valor) {
        NotaFiscalCab notaFiscalCab = new NotaFiscalCab();
        notaFiscalCab.setNumeroNF(valor);
        return notaFiscalCab;
    }

    @Override
    public Collection<NotaFiscalCab> buscarTodos() {
        return null;
    }
}
