package org.alekseev.webshop.configuration;

/*
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
*/
public class WebSecurity /*extends WebSecurityConfigurerAdapter*/ {

    //private final UserDetailsServiceImpl userDetailsService;

/*    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers(Constants.LOGIN_CONFIG).permitAll()
                .antMatchers(Constants.URL_REGISTRATION, Constants.ADMIN_CONFIG, Constants.DELETE_CONFIG).hasAuthority(Constants.ADMIN)
                .antMatchers(Constants.URL_INDEX).hasAnyAuthority(Constants.USER, Constants.ADMIN)
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage(Constants.URL_LOGIN)
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }*/
}
