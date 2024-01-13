import dao.INotaFiscalCabDAO;
import dao.NotaFiscalCabDAOMock;
import domain.NotaFiscalCab;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.INotaFiscalCabService;
import service.NotaFiscalCabService;

import java.util.Date;

public class NotaFiscalCabServiceTest {
    private INotaFiscalCabService notaFiscalCabService;
    private NotaFiscalCab notaFiscalCab;
    public NotaFiscalCabServiceTest() {
        INotaFiscalCabDAO dao = new NotaFiscalCabDAOMock();
        notaFiscalCabService = new NotaFiscalCabService(dao);
    }
    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        notaFiscalCab = new NotaFiscalCab();
        notaFiscalCab.setClienteNF("Cliente da nota fiscal");
        notaFiscalCab.setDescricaoNF("Descrição da nota fiscal");
        notaFiscalCab.setNumeroNF(111L);
        notaFiscalCab.setValorNF(123.45);
        notaFiscalCab.setDataNF(new Date());
        notaFiscalCabService.salvar(notaFiscalCab);
    }

    @Test
    public void pesquisarNotaFiscal() {
        NotaFiscalCab notaFiscalCabPesquisado = notaFiscalCabService.buscarPorCodigo(notaFiscalCab.getNumeroNF());
        Assert.assertNotNull(notaFiscalCabPesquisado);
    }

    @Test
    public void salvaNotaFiscal() throws TipoChaveNaoEncontradaException {
        Boolean retorno = notaFiscalCabService.salvar(notaFiscalCab);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirNotaFiscal() {
        Boolean retorno = notaFiscalCabService.excluir(notaFiscalCab.getNumeroNF());
        Assert.assertTrue(retorno);
    }

    @Test
    public void alterarNotaFiscal() throws TipoChaveNaoEncontradaException {
        notaFiscalCab.setClienteNF("Segundo cliente da nota fiscal");
        notaFiscalCabService.alterar(notaFiscalCab);
        Assert.assertEquals("Segundo cliente da nota fiscal", notaFiscalCab.getClienteNF());
    }
}
