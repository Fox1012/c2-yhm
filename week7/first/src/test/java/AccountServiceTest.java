import com.yhm.domain.Account;
import com.yhm.service.AccountService;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import org.junit.Test;

public class AccountServiceTest {
    private AccountService accountService;
    public void init() throws IOException{
        accountService=new AccountService();
    }
    @Test
    public void testfindAll()throws IOException{
        init();
        List<Account> list=accountService.findAll();
        for(Account acc : list)
        {
            System.out.println(acc);
        }
    }
    @Test
    public  void testDeleteByPrimaryKey() throws IOException {
    init();
    accountService.deleteByPrimaryKey("2");
    }
    @Test
    public void testInsert() throws IOException{
    init();
    Date date=new Date(2021,12,17);
    accountService.insert(new Account("2","pyq",100,date ,new Date(2021,12,17)));
    }
    @Test
    public void testSelectByPrimaryKey() throws IOException {
        init();
        System.out.println(accountService.selectByPrimaryKey("2"));
    }
    @Test
    public void updateByPrimaryKey() throws IOException{
    init();
    Account account= new Account("1","yhm",10000,new Date(2021,12,17),new Date(2021,12,17));
    accountService.updateByPrimaryKey(account);
    }
    @Test
    public void transfer() throws IOException {
    init();
    accountService.transfer("1","2",500);
    testfindAll();
    }
}
