package dao;

import dao.generics.GenericDAO;
import domain.NotaFiscalDet;

public class NotaFiscalDetDAO extends GenericDAO<NotaFiscalDet> implements INotaFiscalDetDAO {

    public NotaFiscalDetDAO() {
        super();
    }
    @Override
    public Class<NotaFiscalDet> getTipoClasse() {
        return NotaFiscalDet.class;
    }

    @Override
    public void atualizarDados(NotaFiscalDet entity, NotaFiscalDet entityCadastrado) {

    }
}
