package com.dthealth.access.config;

import com.dthealth.dao.service.TokenService;
import com.dthealth.safe.config.AuthenticationResultHandle;
import com.dthealth.safe.config.UserInfoAuthentication;
import com.dthealth.safe.config.UserRoleAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity // 注解开启Spring Security的功能
@EnableGlobalMethodSecurity(prePostEnabled = true)
//只有加了@EnableGlobalMethodSecurity(prePostEnabled=true) 那么在controller中使用的 @PreAuthorize(“hasAuthority(‘admin’)”)才会生效
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 因为UserDetailsService的实现类实在太多啦，这里设置一下我们要注入的实现类
    @Autowired
    @Qualifier("customUserDetailService")
    private UserDetailsService userDetailsService;

    @Autowired
    @Qualifier("tokenServiceImpl")
    private TokenService tokenService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("/resources/**", "/to-sign-in", "/do-sign-in", "/to-sign-up", "/do-sign-up","/clearCache").permitAll()
                .anyRequest().authenticated()
                .and()
                .addFilter(new UserInfoAuthentication(authenticationManager(), tokenService))
                .addFilter(new UserRoleAuthentication(authenticationManager(), tokenService))
                // no need session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .exceptionHandling().authenticationEntryPoint(new AuthenticationResultHandle());


//        http.authorizeRequests()  //定义哪些url需要保护，哪些url不需要保护
//                .antMatchers("/resources/**", "/do-sign-in", "/to-sign-up", "/do-sign-up").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().loginPage("/to-sign-in").permitAll()
//                .and()
//                .logout()
//                .permitAll();
//        http.csrf().disable();
//        http
//                .antMatcher("/*")
//                .addFilterAfter(new TokenAuthenticationFilter(),
//                        BasicAuthenticationFilter.class)
//                .addFilterAfter(new ResultExceptionTranslationFilter(),
//                        ExceptionTranslationFilter.class)
//                .authorizeRequests()
//                .anyRequest().hasRole("USER")
//                .antMatchers("/resources/**","/do-sign-in","/to-sign-up","/do-sign-up").permitAll()
//                .and()
//                .csrf()
//                .disable()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }
}
