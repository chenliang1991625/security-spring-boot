package com.example.security.securityspringboot.controller;
import com.example.security.pojo.User;
import com.example.security.securityspringboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/**
 * @Author: 陈亮
 * @Description:
 * @Time: 2019/9/18 星期三 17:46
 **/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    /*
     *根据uid条件获取记录数
     */
    @PostMapping("/uid/count")
    public Long getCountByUid(@RequestBody User user) {
        return userService.getCountByUid(user);
    }
    /*
     *根据password条件获取记录数
     */
    @PostMapping("/password/count")
    public Long getCountByPassword(@RequestBody User user) {
        return userService.getCountByPassword(user);
    }
    /*
     *根据mobile条件获取记录数
     */
    @PostMapping("/mobile/count")
    public Long getCountByMobile(@RequestBody User user) {
        return userService.getCountByMobile(user);
    }
    /*
     *根据username条件获取记录数
     */
    @PostMapping("/username/count")
    public Long getCountByUsername(@RequestBody User user) {
        return userService.getCountByUsername(user);
    }
    /*
     *根据uid删除
     */
    @DeleteMapping("/delete/{uid}")
    public int deleteByUid(@PathVariable Integer uid) {
        return userService.deleteByUid(uid);
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
     *根据主键uid删除
     */
    @DeleteMapping("/deleteByKey/{uid}")
    public int deleteByKey(@PathVariable Integer uid) {
        return userService.deleteByKey(uid);
    }
    /*
     *保存用户
     */
    @PostMapping("/insert")
    public int insert(@RequestBody User user) {
        return userService.insert(user);
    }
    /*
     *保存用户:精确保存想的字段
     */
    @PostMapping("/insertAll")
    public int insertAllColumn(@RequestBody User user) {
        return userService.insertAllColumn(user);
    }
    /*
     * 根据条件(实体类uid字段属性值)查询
     */
    @PostMapping("/uid/findList")
    public List<User> selectListByUid(@RequestBody User user) {
        return userService.selectListByUid(user);
    }
    /*
     * 根据条件(实体类password字段属性值)查询
     */
    @PostMapping("/password/findList")
    public List<User> selectListByPassword(@RequestBody User user) {
        return userService.selectListByPassword(user);
    }
    /*
     * 根据条件(实体类mobile字段属性值)查询
     */
    @PostMapping("/mobile/findList")
    public List<User> selectListByMobile(@RequestBody User user) {
        return userService.selectListByMobile(user);
    }
    /*
     * 根据条件(实体类username字段属性值)查询
     */
    @PostMapping("/username/findList")
    public List<User> selectListByUsername(@RequestBody User user) {
        return userService.selectListByUsername(user);
    }

    /*
     * 根据主键uid查询
     */
    @GetMapping("/uid/{uid}")
    public User get(@PathVariable Integer uid) {
        return userService.findByUid(uid);
    }
    /*
     * 查询所有
     */
    @GetMapping("/list")
    public List<User> geUser() {
        return userService.list();
    }
       /*
       *根据(实体类字段uid属性值)精确更新想更新的字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/update/{uid}")
      public int updateByUid(@RequestBody User user, @PathVariable Integer uid) {
          return userService.updateByUid(user, uid);
      }
       /*
       *根据(实体类字段password属性值)精确更新想更新的字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/update/{password}")
      public int updateByPassword(@RequestBody User user, @PathVariable String password) {
          return userService.updateByPassword(user, password);
      }
       /*
       *根据(实体类字段mobile属性值)精确更新想更新的字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/update/{mobile}")
      public int updateByMobile(@RequestBody User user, @PathVariable String mobile) {
          return userService.updateByMobile(user, mobile);
      }
       /*
       *根据(实体类字段username属性值)精确更新想更新的字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/update/{username}")
      public int updateByUsername(@RequestBody User user, @PathVariable String username) {
          return userService.updateByUsername(user, username);
      }
       /*
       *根据(实体类字段uid属性值)更新全部字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/updateAll/{uid}")
      public int updateAllColumnByUid(@RequestBody User user, @PathVariable Integer uid) {
          return userService.updateByUid(user, uid);
      }
       /*
       *根据(实体类字段password属性值)更新全部字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/updateAll/{password}")
      public int updateAllColumnByPassword(@RequestBody User user, @PathVariable String password) {
          return userService.updateByPassword(user, password);
      }
       /*
       *根据(实体类字段mobile属性值)更新全部字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/updateAll/{mobile}")
      public int updateAllColumnByMobile(@RequestBody User user, @PathVariable String mobile) {
          return userService.updateByMobile(user, mobile);
      }
       /*
       *根据(实体类字段username属性值)更新全部字段
       * updateByExample()更新所有的字段，包括字段为null的也更新，建议使用 updateByExampleSelective()更新想更新的字段
       */
      @PutMapping("/updateAll/{username}")
      public int updateAllColumnByUsername(@RequestBody User user, @PathVariable String username) {
          return userService.updateByUsername(user, username);
      }
    /*
     * 根据主键uid更新部分想要的字段
     */
    @PutMapping("/update/key")
    public int updateByKey(@RequestBody User user) {
        return userService.updateByKey(user);
    }
    /*
     * 根据主键uid更新全部字段
     */
    @PutMapping("/updateAll/key")
    public int updateAllColumnByKey(@RequestBody User user) {
        return userService.updateAllColumnByKey(user);
    }
}
