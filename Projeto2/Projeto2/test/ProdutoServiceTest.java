import dao.IProdutoDAO;
import dao.ProdutoDAOMock;
import domain.Produto;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.IProdutoService;
import service.ProdutoService;

public class ProdutoServiceTest {
    private IProdutoService produtoService;
    private Produto produto;
    public ProdutoServiceTest() {
        IProdutoDAO dao = new ProdutoDAOMock();
        produtoService = new ProdutoService(dao);
    }
    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        produto = new Produto();
        produto.setCodigo(123L);
        produto.setDescricao("Produto teste");
        produto.setUnidadeMedida("Unidade");
        produto.setValorUnitario(12.35);
        produtoService.salvar(produto);
    }

    @Test
    public void pesquisarProduto() {
        Produto produtoConsultado = produtoService.buscarPorCodigo(produto.getCodigo());
        Assert.assertNotNull(produtoConsultado);
    }

    @Test
    public void salvarProduto() throws TipoChaveNaoEncontradaException {
        Boolean retorno = produtoService.salvar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirProduto() {
        Boolean retorno = produtoService.excluir(produto.getCodigo());
        Assert.assertTrue(retorno);
    }

    @Test
    public void alterarProduto() throws TipoChaveNaoEncontradaException {
        produto.setDescricao("Produto teste versão 2");
        produtoService.alterar(produto);
        Assert.assertEquals("Produto teste versão 2", produto.getDescricao());
    }
}
