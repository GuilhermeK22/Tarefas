import dao.ClienteDAOMock;
import dao.IClienteDAO;
import domain.Cliente;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ClienteDAOTest {
    private IClienteDAO clienteDAO;
    private Cliente cliente;
    public ClienteDAOTest() {
        clienteDAO = new ClienteDAOMock();
    }
    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        //antes de todos os testes, executa este método
        cliente = new Cliente();
        cliente.setCpf(12123123123L);
        cliente.setNome("Zé");
        cliente.setCidade("LV");
        cliente.setEnd("End");
        cliente.setEstado("RS");
        cliente.setNumeroEnd(10);
        cliente.setTel(12121312L);
        clienteDAO.cadastrar(cliente);
    }
    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = clienteDAO.consultar(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }
    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException{
        Boolean retorno = clienteDAO.cadastrar(cliente);
        Assert.assertTrue(retorno);
    }
    @Test
    public void excluirCliente() {
        clienteDAO.excluir(cliente.getCpf());
    }
    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Guilherme");
        clienteDAO.alterar(cliente);

        Assert.assertEquals("Guilherme", cliente.getNome());
    }
}
