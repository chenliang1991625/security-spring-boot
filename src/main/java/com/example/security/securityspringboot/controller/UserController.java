package com.example.security.securityspringboot.controller;
import com.example.security.pojo.T_user;
import com.example.security.pojo.resultPojo.PageResult;
import com.example.security.securityspringboot.service.UserService;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
/**
 * @Author: 陈亮
 * @Description:
 * @Time: 2019/9/18 星期三 17:46
 * 注意:T_user类对应的用户表不能查询,是不是真的无法查询,如果能查询怎么实现?
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /*
     *根据id条件获取记录数
     */
    @PostMapping("/id/count")
    public Long getCountByUid(@RequestBody T_user user) {
        return userService.getCountByUid(user);
    }
    /*
     *根据password条件获取记录数
     */
    @PostMapping("/password/count")
    public Long getCountByPassword(@RequestBody T_user user) {
        return userService.getCountByPassword(user);
    }
    /*
     *根据mobile条件获取记录数
     */
    @PostMapping("/mobile/count")
    public Long getCountByMobile(@RequestBody T_user user) {
        return userService.getCountByMobile(user);
    }
    /*
     *根据username条件获取记录数
     */
    @PostMapping("/username/count")
    public Long getCountByT_username(@RequestBody T_user user) {
        return userService.getCountByUsername(user);
    }
    /*
     *根据id删除
     */
//    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('p4')")//拥有p4权限才可以访问(才能删除)
    @DeleteMapping("/delete/{id}")
    public int deleteByUid(@PathVariable Integer id) {
        return userService.deleteByUid(id);
    }
    /*
     *根据password删除
     */
    @DeleteMapping("/delete/{password}")
    public int deleteByPassword(@PathVariable String password) {
        return userService.deleteByPassword(password);
    }
    /*
     *根据mobile删除
     */
    @DeleteMapping("/delete/{mobile}")
    public int deleteByMobile(@PathVariable String mobile) {
        return userService.deleteByMobile(mobile);
    }
    /*
     *根据username删除
     */
    @DeleteMapping("/delete/{username}")
    public int deleteByUsername(@PathVariable String username) {
        return userService.deleteByUsername(username);
    }

    /*
     *根据主键id删除
     */
    @DeleteMapping("/deleteByKey/{id}")
    public int deleteByKey(@PathVariable Integer id) {
        return userService.deleteByKey(id);
    }
    /*
     *保存用户
     */
    @PostMapping("/insert")
    public int insert(@RequestBody T_user user) {
        return userService.insert(user);
    }
    /*
     *保存用户:精确保存想的字段
     */
    @PostMapping("/insertAll")
    public int insertAllColumn(@RequestBody T_user user) {
        return userService.insertAllColumn(user);
    }
    /*
     * 根据条件(实体类id字段属性值)查询
     */
    @PostMapping("/id/findList")
    public List<T_user> selectListByUid(@RequestBody T_user user) {
        return userService.selectListByUid(user);
    }
    /*
     * 根据条件(实体类password字段属性值)查询
     */
    @PostMapping("/password/findList")
    public List<T_user> selectListByPassword(@RequestBody T_user user) {
        return userService.selectListByPassword(user);
    }
    /*
     * 根据条件(实体类mobile字段属性值)查询
     */
    @PostMapping("/mobile/findList")
    public List<T_user> selectListByMobile(@RequestBody T_user user) {
        return userService.selectListByMobile(user);
    }
    /*
     * 根据条件(实体类username字段属性值)查询
     */
    @PostMapping("/username/findList")
    public List<T_user> selectListByT_username(@RequestBody T_user user) {
        return userService.selectListByUsername(user);
    }
    /*
     * 根据条件(实体类username字段属性值)查询2
     */
    @GetMapping("/username/findList/{username}")
    public List<T_user> selectListByT_username(@PathVariable String username) {
        return userService.selectListByUsername(username);
    }
    /*
     * 根据主键id查询:根据id主键不能查询用户信息,除非每列值都一样(那也没意义,没有这样无效无聊的用户)
     */
    @GetMapping("/id/{id}")
    public T_user get(@PathVariable Integer id) {
        return userService.findByUid(id);
    }
    /*
     * 查询所有
     */
    @PreAuthorize("hasAuthority('p3')")//拥有p3权限才可以访问
    @GetMapping("/list")
    public List<T_user> geUser() {
        return userService.list();
    }
       /*
       *根据(实体类字段id属性值)精确更新想更新的字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/update/{id}")
      public int updateByUid(@RequestBody T_user user, @PathVariable Integer id) {
          return userService.updateByUid(user, id);
      }
       /*
       *根据(实体类字段password属性值)精确更新想更新的字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/update/{password}")
      public int updateByPassword(@RequestBody T_user user, @PathVariable String password) {
          return userService.updateByPassword(user, password);
      }
       /*
       *根据(实体类字段mobile属性值)精确更新想更新的字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/update/{mobile}")
      public int updateByMobile(@RequestBody T_user user, @PathVariable String mobile) {
          return userService.updateByMobile(user, mobile);
      }
       /*
       *根据(实体类字段username属性值)精确更新想更新的字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/update/{username}")
      public int updateByT_username(@RequestBody T_user user, @PathVariable String username) {
          return userService.updateByUsername(user, username);
      }
       /*
       *根据(实体类字段id属性值)更新全部字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/updateAll/{id}")
      public int updateAllColumnByUid(@RequestBody T_user user, @PathVariable Integer id) {
          return userService.updateByUid(user, id);
      }
       /*
       *根据(实体类字段password属性值)更新全部字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/updateAll/{password}")
      public int updateAllColumnByPassword(@RequestBody T_user user, @PathVariable String password) {
          return userService.updateByPassword(user, password);
      }
       /*
       *根据(实体类字段mobile属性值)更新全部字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/updateAll/{mobile}")
      public int updateAllColumnByMobile(@RequestBody T_user user, @PathVariable String mobile) {
          return userService.updateByMobile(user, mobile);
      }
       /*
       *根据(实体类字段username属性值)更新全部字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/updateAll/{username}")
      public int updateAllColumnByT_username(@RequestBody T_user user, @PathVariable String username) {
          return userService.updateByUsername(user, username);
      }
    /*
     * 根据主键id更新部分想要的字段
     */
    @PutMapping("/update/key")
    public int updateByKey(@RequestBody T_user user) {
        return userService.updateByKey(user);
    }
    /*
     * 根据主键id更新全部字段
     */
    @PutMapping("/updateAll/key")
    public int updateAllColumnByKey(@RequestBody T_user user) {
        return userService.updateAllColumnByKey(user);
    }
    //分页查询
    @GetMapping(value = "/search/{page}/{size}" )
    public PageResult findPage(@PathVariable  int page, @PathVariable  int size){
        Page<T_user> pageList = userService.findPage(page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return pageResult;
    }
    //分页+条件查询
    @PostMapping(value = "/search/{page}/{size}" )
    public PageResult findPage(@RequestBody Map searchMap, @PathVariable  int page, @PathVariable  int size){
        Page<T_user> pageList = userService.findPage(searchMap, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());
        return pageResult;
    }
}
