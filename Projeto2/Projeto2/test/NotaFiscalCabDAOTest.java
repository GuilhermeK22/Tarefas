import dao.INotaFiscalCabDAO;
import dao.NotaFiscalCabDAOMock;
import domain.NotaFiscalCab;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class NotaFiscalCabDAOTest {

    private INotaFiscalCabDAO notaFiscalCabDAO;
    private NotaFiscalCab notaFiscalCab;

    public NotaFiscalCabDAOTest() {
        notaFiscalCabDAO = new NotaFiscalCabDAOMock();
    }
    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        notaFiscalCab = new NotaFiscalCab();
        notaFiscalCab.setClienteNF("Cliente da nota fiscal");
        notaFiscalCab.setDescricaoNF("Descrição da nota fiscal");
        notaFiscalCab.setNumeroNF(111L);
        notaFiscalCab.setValorNF(123.45);
        notaFiscalCab.setDataNF(new Date());
        notaFiscalCabDAO.cadastrar(notaFiscalCab);
    }

    @Test
    public void pesquisarNotaFiscal() {
        NotaFiscalCab notaFiscalCabPesquisado = notaFiscalCabDAO.consultar(notaFiscalCab.getNumeroNF());
        Assert.assertNotNull(notaFiscalCabPesquisado);
    }

    @Test
    public void salvaNotaFiscal() throws TipoChaveNaoEncontradaException {
        Boolean retorno = notaFiscalCabDAO.cadastrar(notaFiscalCab);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirNotaFiscal() {
        Boolean retorno = notaFiscalCabDAO.excluir(notaFiscalCab.getNumeroNF());
        Assert.assertTrue(retorno);
    }

    @Test
    public void alterarNotaFiscal() throws TipoChaveNaoEncontradaException {
        notaFiscalCab.setClienteNF("Terceiro cliente da nota fiscal");
        notaFiscalCabDAO.alterar(notaFiscalCab);
        Assert.assertEquals("Terceiro cliente da nota fiscal", notaFiscalCab.getClienteNF());
    }
}
