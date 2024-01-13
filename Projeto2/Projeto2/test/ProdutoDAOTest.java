import dao.IProdutoDAO;
import dao.ProdutoDAOMock;
import domain.Produto;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProdutoDAOTest {
    private IProdutoDAO produtoDAO;
    private Produto produto;
    public ProdutoDAOTest() {
        produtoDAO = new ProdutoDAOMock();
    }
    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        produto = new Produto();
        produto.setCodigo(123L);
        produto.setDescricao("Produto teste");
        produto.setUnidadeMedida("Unidade");
        produto.setValorUnitario(12.35);
        produtoDAO.cadastrar(produto);
    }

    @Test
    public void pesquisarProduto() {
        Produto produtoConsultado = produtoDAO.consultar(produto.getCodigo());
        Assert.assertNotNull(produtoConsultado);
    }

    @Test
    public void salvarProduto() throws TipoChaveNaoEncontradaException {
        Boolean retorno = produtoDAO.cadastrar(produto);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirProduto() {
        Boolean retorno = produtoDAO.excluir(produto.getCodigo());
        Assert.assertTrue(retorno);
    }

    @Test
    public void alterarProduto() throws TipoChaveNaoEncontradaException {
        produto.setDescricao("Produto teste versão 3");
        produtoDAO.alterar(produto);
        Assert.assertEquals("Produto teste versão 3",produto.getDescricao());
    }
}
