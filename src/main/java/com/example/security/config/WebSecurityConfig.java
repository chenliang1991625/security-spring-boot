package com.example.security.config;
import com.example.security.securityspringboot.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
//@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)//允许在具体方法上设置访问该方法的权限
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    //配置用户信息服务
    /*@Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
        return manager;
    }*/
    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }*/
    @Autowired
    private static UserDao userDao;
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    //安全拦截机制（最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
//                .antMatchers("/r/r1").hasAuthority("p2")
//                .antMatchers("/r/r2").hasAuthority("p2")//想办法从springSecurity登录页面数据查询用户权限填在这里,这种想法不对，
//                因为运行空指针异常(到登录页面前先要经过这里拦截)；登录认证后spring security会自动从数据库查询权限进行授权
//                .antMatchers(getUrl()).hasAnyAuthority(getCodes())
                .antMatchers("/r/**").authenticated()//所有/r/**的请求必须认证通过才能访问
                .anyRequest().permitAll()//除了/r/**，其它的请求可以访问
                .and()
                .formLogin()//允许表单登录
                .loginPage("/login")//设置springSecurity的登录页面路径
                .loginProcessingUrl("/login-success")//自定义登录成功的controller处理地址(即登录成功进入哪个controller的哪个方法处理)
                .successForwardUrl("/login-success")//自定义登录成功的controller跳转到的处理地址(即登录成功进入哪个controller的哪个方法处理)
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .logout()
                .logoutUrl("/logout")//设置springSecurity退出的地址
                .logoutSuccessUrl("/login-view?logout");//设置springSecurity退出后进入的页面地址(退出后来到到登录页面)
    }
//然后在实现了WebSecurityConfigurerAdapter类的WebSecurityConfig中的configure方法（具体方法名可能因人而异）中加入“.passwordEncoder(new BCryptPasswordEncoder())”，相当于是将前端传过来的密码进行加密处理，再与数据库中加密过的密码进行比对。
   /* protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);                                                                          
        auth.userDetailsService(springDataUserDetailsService).passwordEncoder(passwordEncoder()) ;
    }*/
    //   获取登录用户资源(权限标记)
  /*public static String[] getCodes(*//*HttpServletRequest request*//*) {
//      T_user t_user = (T_user) request.getAttribute("t_user");
//      T_user user = userDao.getUserByUsername(t_user.getUsername());
      List<T_permission> t_permissions = getT_permission();
      ArrayList<String> codes = new ArrayList<>();

      for (T_permission permission : t_permissions) {
          codes.add(permission.getCode());
      }
      String[] codesArry = (String[]) codes.toArray();
      return codesArry;
  }*/
//  获取用户访问权限：url
   /* public static String[] getUrl() {
        List<T_permission> t_permissions = getT_permission();
        ArrayList<String> urls = new ArrayList<>();

        for (T_permission permission : t_permissions) {
            urls.add(permission.getUr());
        }
        String[] urlsArry = (String[]) urls.toArray();
        return urlsArry;
    }*/
//获取用户权限
    /*public static List<T_permission> getT_permission(){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        String username = userDetails.getUsername();
        T_user user = userDao.getUserByUsername(username);

        List<T_permission> permissions = userDao.findPermissionsByUserId(user.getId());
        return permissions;
    }
*/
      //当前认证通过的用户身份
     /* Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      //用户身份
      Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
      List<T_permission>  permissionLists = (List<T_permission>) authorities;
      codeList = new ArrayList<>();
     urlList = new ArrayList<>();
      for (T_permission permissionList : permissionLists) {
          String ur = permissionList.getUr();
          urlList.add(ur);
          String code = permissionList.getCode();
          codeList.add(code);
      }*/
}
