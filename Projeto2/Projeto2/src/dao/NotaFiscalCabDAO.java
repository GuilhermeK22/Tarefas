package dao;

import dao.generics.GenericDAO;
import domain.NotaFiscalCab;

public class NotaFiscalCabDAO extends GenericDAO<NotaFiscalCab> implements INotaFiscalCabDAO {
    public NotaFiscalCabDAO() {
        super();
    }
    @Override
    public Class<NotaFiscalCab> getTipoClasse() {
        return NotaFiscalCab.class;
    }

    @Override
    public void atualizarDados(NotaFiscalCab entity, NotaFiscalCab entityCadastrado) {

    }
}
