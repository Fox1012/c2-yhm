package com.yhm.service;

import com.yhm.dao.AccountDao;
import com.yhm.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountService {
    private InputStream inputStream;
    private SqlSession sqlSession;
    private AccountDao accountDao;
    public AccountService() throws IOException{
        inputStream= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = factory.openSession();
        accountDao = sqlSession.getMapper(AccountDao.class);//获得到哪个接口，再通过哪个接口来是实现对sql的操作。因为接口在相应的xml文件实现了接口的方法。就是相当于调用接口就可以直接操作sql。
    }
    private void destroy() {
        try {
            sqlSession.commit();
            sqlSession.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 1查询所有记录
    public List<Account> findAll() {
        //TODO
        List<Account> list=this.accountDao.findAll();
        this.destroy();
        return list;
    }
        // 2通过id删除记录
    public void deleteByPrimaryKey(String id) {
        //TODO
        this.accountDao.deleteByPrimaryKey(id);
        this.destroy();
    }
    // 3插入记录
    public void insert(Account record) {
        //TODO
        this.accountDao.insert(record);
        this.destroy();
    }
    // 4通过id查找对象
    public Account selectByPrimaryKey(String id) {
        //TODO
        Account account=this.accountDao.selectByPrimaryKey(id);
        this.destroy();
        return account;
    }
    // 5更新Account
    public void updateByPrimaryKey(Account record) {
        //TODO
        this.accountDao.updateByPrimaryKey(record);
        this.destroy();
    }
    // 6转账功能 输入转出人id，转入人id，转账金额 实现转账
    public void transfer(String remitterId,String remitteeId,int money) {
        //TODO
        Account one=accountDao.selectByPrimaryKey(remitterId);
        Account tow=accountDao.selectByPrimaryKey(remitteeId);
        one.setMoney(one.getMoney()-money);
        tow.setMoney(tow.getMoney()+money);
        accountDao.updateByPrimaryKey(one);
        accountDao.updateByPrimaryKey(tow);
        this.destroy();
    }
}
