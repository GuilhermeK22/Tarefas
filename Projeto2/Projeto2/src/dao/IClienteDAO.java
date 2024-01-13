package dao;

import dao.generics.GenericDAO;
import dao.generics.IGenericDAO;
import domain.Cliente;
import domain.NotaFiscalCab;
import domain.Produto;

public interface IClienteDAO extends IGenericDAO<Cliente> {
//    Boolean salvar(Cliente cliente);
//
//	Cliente buscarPorCpf(Long cpf);
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente);

    interface IProdutoDAO extends IGenericDAO<Produto>{
    }

    class NotaFiscalCabDAO extends GenericDAO<NotaFiscalCab> implements INotaFiscalCabDAO {
        public NotaFiscalCabDAO() {
            super();
        }
        @Override
        public Class<NotaFiscalCab> getTipoClasse() {
            return NotaFiscalCab.class;
        }

        @Override
        public void atualizarDados(NotaFiscalCab entity, NotaFiscalCab entityCadastrado) {
                    // TODO Auto-generated method stub
        }
    }
}
