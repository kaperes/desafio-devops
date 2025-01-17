package br.com.letscodebyada.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/api/usuarios").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/api/clientes/**").authenticated()
                .antMatchers("/api/orcamentos/**").authenticated()
                .antMatchers("/api/contratos/**").authenticated()
                .antMatchers("/api/funcionarios/**").authenticated()
                .antMatchers("/api/fornecedores/**").authenticated()
                .anyRequest().denyAll();
    }
}
