import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author guilh
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ClienteDAOTest.class, ClienteServiceTest.class, NotaFiscalCabDAOTest.class, NotaFiscalCabServiceTest.class,
        NotaFiscalDetDAOTest.class, NotaFiscalDetServiceTest.class,
        ProdutoDAOTest.class, ProdutoServiceTest.class})
public class AllTest {
}
