//package com.website.nit.config;
//
//import com.website.nit.model.Users;
//import com.website.nit.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.NoSuchElementException;
//import java.util.stream.Collectors;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    @Lazy
//    BCryptPasswordEncoder pe;
//
//    @Autowired
//    UserService userService;
//
//    // Cung cấp nguồn dữ liệu đăng nhập
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(username -> {
//            try {
//                Users user = userService.findByUsername(username);
//
//                String password = pe.encode(user.getPassword());
//                String[] roles = user.getAuthorities().stream()
//                        .map(er -> er.getRole().getId())
//                        .collect(Collectors.toList())
//                        .toArray(new String[0]);
//                System.out.println(user.getFullName());
//                return User.withUsername(username).password(password).roles(roles).build();
//            } catch (NoSuchElementException e) {
//                throw new UsernameNotFoundException(username + " not found!");
//            }
//        });
//    }
//
//    // Phân quyền sử dụng
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
//
//        http.authorizeRequests()
//                .antMatchers("/admin/end-point").hasRole("Admin")
//                .antMatchers("/like/**", "/comment/**").authenticated()
//                .anyRequest().permitAll();
//
//
//    }
//
//    // Cơ chế mã hóa mật khẩu
//    @Bean
//    public BCryptPasswordEncoder getPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    // Cho phép truy xuất REST API từ domain khác
////    @Override
////    public void configure(WebSecurity web) throws Exception {
////        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
////    }
//}
