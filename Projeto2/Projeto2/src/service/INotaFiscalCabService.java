package service;

import domain.NotaFiscalCab;
import exception.TipoChaveNaoEncontradaException;

public interface INotaFiscalCabService {
    Boolean salvar(NotaFiscalCab notaFiscalCab) throws TipoChaveNaoEncontradaException;

    NotaFiscalCab buscarPorCodigo(Long numeroNF);

    Boolean excluir(Long numeroNF);

    void alterar(NotaFiscalCab notaFiscalCab) throws TipoChaveNaoEncontradaException;
}
