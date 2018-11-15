package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 帐户web
 */
@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService  accountService;

    @RequestMapping("findAll")
    public String findAll(Model model){
        List<Account> list = accountService.findAll();
       model.addAttribute("list",list);
        System.out.println("表现层：查询所有账户...");
        // 调用service的方法
        return "list";
    }

    /**
     * 保存
     * @return
     */
    @RequestMapping("save")
  /*  public void save(Account account,HttpServletRequest request,HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);

        response.sendRedirect(request.getContextPath()+"/account/findAll");*/
    public String save(Account account) throws IOException{
        System.out.println("表现层：保存账户...");
        accountService.saveAccount(account);
        return "redirect:findAll";
    }

    }




