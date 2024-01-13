package dao;

import dao.generics.GenericDAO;
import domain.Cliente;
import domain.Persistente;

public class ClienteDAO extends GenericDAO<Cliente> implements IClienteDAO {
    public ClienteDAO() {
        super();
    }
    @Override
    public Class<Cliente> getTipoClasse() {
        return Cliente.class;
    }

    @Override
    public void atualizarDados(Cliente entity, Cliente entityCadastrado) {

    }

}
