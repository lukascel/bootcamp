package com.bootcamp.bootcamp.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //nak powiązać logowanie z bazą danych - hasło i email zeby brać z bd?:
    @Autowired
    private DataSource dataSource; //autoconfiguracja springa! Bierze to z applicationProperties

    @Override //nadpisuje metodę do autentykacji bo default ma hasło w programie.
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(); //bo tak kodowalismy dzisiaj hasło w UserService
    auth.jdbcAuthentication()
            //sprawdzanie i pobieranie loginu i hasła uzytkownika po adresie email, który u nas jest loginem. Muszą być trzy parametry. Jedynka jest potrzebna, że zawsze true.
            .usersByUsernameQuery("SELECT email, password, 1 FROM user WHERE email=?")

            //pobieranie roli użytkownika z bazy danych po pobranym e-mailu(loginie)
            .authoritiesByUsernameQuery("SELECT u.email, r.role FROM user u INNER JOIN role r on r.id=u.role_id WHERE u.email=?")

            //ustawienie klasy odpowiedzialnej za nawiązanie połączenia do bazy danych. Parametrem jest dataSource z góry - z automtu ze springa
            .dataSource(dataSource)

            //ustawienie sposobu kodowania hasła w bazie
            .passwordEncoder(bCryptPasswordEncoder);

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //kazde żądanie
                    //.antMatchers("/").permitAll() //sprawdza jaki dostęp. / to strona główna
                    //.anyRequest().authenticated() //inne - wymaga logowania
                    .antMatchers("/admin/*", "/admin").hasAuthority("admin")
                    .antMatchers("/user/**", "/user").hasAuthority("user")
                    .anyRequest().permitAll()
//                .and() //pozwala mo pójśc dalej, pisać dodatkowe.
//                .logout()
//                    .logoutUrl("/logout")
//                    .logoutSuccessUrl("/")
                .and()
                .formLogin()
                    .loginPage("/logowanie")
                    .defaultSuccessUrl("/")
                    .usernameParameter("username") //żeby zmienić nazwę w loginFormie - tutaj podaję tę samą nazwę co name dla loginu
                    .passwordParameter("password") //żeby zmienić nazwę w loginFormie - tutaj podaję tę samą nazwę co name dla hasła;
                .and()
                .logout()
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/");
    }
}
