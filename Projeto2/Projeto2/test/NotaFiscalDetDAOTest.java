import dao.INotaFiscalDetDAO;
import dao.NotaFiscalDetDAOMock;
import domain.NotaFiscalDet;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NotaFiscalDetDAOTest {
    private INotaFiscalDetDAO notaFiscalDetDAO;
    private NotaFiscalDet notaFiscalDet;
    public NotaFiscalDetDAOTest() {
        notaFiscalDetDAO = new NotaFiscalDetDAOMock();
    }
    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        notaFiscalDet = new NotaFiscalDet();
        notaFiscalDet.setCodigoProdutoINF(987);
        notaFiscalDet.setNumeroNF(111L);
        notaFiscalDet.setQuantidadeINF(12);
        notaFiscalDet.setSequencialINF(1L);
        notaFiscalDet.setValorINF(2.5);
        notaFiscalDetDAO.cadastrar(notaFiscalDet);
    }
    @Test
    public void pesquisarNotaFiscal() {
        NotaFiscalDet notaFiscalDetPesquisado = notaFiscalDetDAO.consultar(notaFiscalDet.getNumeroNF());
        Assert.assertNotNull(notaFiscalDetPesquisado);
    }

    @Test
    public void salvaNotaFiscal() throws TipoChaveNaoEncontradaException {
        Boolean retorno = notaFiscalDetDAO.cadastrar(notaFiscalDet);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirNotaFiscal() {
        Boolean retorno = notaFiscalDetDAO.excluir(notaFiscalDet.getNumeroNF());
        Assert.assertTrue(retorno);
    }

    @Test
    public void alterarNotaFiscal() throws TipoChaveNaoEncontradaException {
        notaFiscalDet.setSequencialINF(2L);
        notaFiscalDetDAO.alterar(notaFiscalDet);
        Assert.assertEquals( (Long) 2L, notaFiscalDet.getSequencialINF());
    }
}
