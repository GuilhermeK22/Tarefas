import dao.ClienteDAOMock;
import dao.IClienteDAO;
import domain.Cliente;
import exception.TipoChaveNaoEncontradaException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.ClienteService;
import service.IClienteService;

/**
 * @author guilh
 * Sistema para simular uma venda : Nota Fiscal , Cliente , Produto.
 * Camada de banco : padrão FACADE : IClienteService
 *
 */

public class ClienteServiceTest {
    private IClienteService clienteService;
    private Cliente cliente;
    public ClienteServiceTest() {
        IClienteDAO dao = new ClienteDAOMock();
        clienteService = new ClienteService(dao);
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
        clienteService.salvar(cliente);
    }
    @Test
    public void pesquisarCliente() {

        Cliente clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());

        Assert.assertNotNull(clienteConsultado);
    }
    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }
    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }
    @Test
    public void alterarCliente() throws TipoChaveNaoEncontradaException {
        cliente.setNome("Guilherme");
        clienteService.alterar(cliente);
        Assert.assertEquals("Guilherme", cliente.getNome());
    }
}