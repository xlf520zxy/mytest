package cn.itcast.dao;

import cn.itcast.domain.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 帐户dao接口
 */
public interface AccountDao {

    // 查询所有账户
    @Select("select * from  account ")
    public List<Account> findAll();

    // 保存帐户信息
    @Insert("insert into account (id,name,money) values (#{id},#{name},#{money})")
    //keyProperty调用Account对象里面的setId方法
    //before = true在insert into account语句执行之前执行SELECT ACCOUNT_SEQ.nextval id from dual调用Account的setId方法
    @SelectKey(keyProperty = "id",before = true, statement = "SELECT ACCOUNT_SEQ.nextval id from dual", resultType = Integer.class)
    public void saveAccount(Account account);


}
