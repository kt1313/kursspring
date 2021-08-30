package com.clockworkjava.kursspring.config;


import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig extends WebMvcAutoConfiguration.WebMvcAutoConfigurationAdapter {

    public SecurityConfig(ResourceProperties resourceProperties, WebProperties webProperties, WebMvcProperties mvcProperties, ListableBeanFactory beanFactory, ObjectProvider<HttpMessageConverters> messageConvertersProvider, ObjectProvider<WebMvcAutoConfiguration.ResourceHandlerRegistrationCustomizer> resourceHandlerRegistrationCustomizerProvider, ObjectProvider<DispatcherServletPath> dispatcherServletPath, ObjectProvider<ServletRegistrationBean<?>> servletRegistrations) {
        super(resourceProperties, webProperties, mvcProperties, beanFactory, messageConvertersProvider, resourceHandlerRegistrationCustomizerProvider, dispatcherServletPath, servletRegistrations);
    }

    @Override
    public void configure(HttpSecurity security) throws Exception{
        security.authorizeRequest()
                .antMatcher("/h2-console/**").permitAll()
                .antMatcher("/knights").hasAnyRole("USER", "ADMIN")
                .antMatcher("/knight").hasAnyRole( "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/knights");



    }

    @Autowired
    public void securityUsers(AuthenticationManagerBuilder auth){
        auth.inMemoryAuthentication().
                withUser("user1").password("user1").role("USER")
                .and()
                .withUser("user2").password("user2").role("ADMIN");
    }


}
