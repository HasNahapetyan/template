package com.example.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//run lineluc heto springy arajiny es @Configuration klassnery knaye
//piti veradarcnenq voroshaki objectner, voronc springy vercne ira mot,
// u ira unecac defoultnery override ani, vortev skzbic springy sarqel e
// securityi configurationner, vory sax pagel e
@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    //es dzevov securityn kochvum e in memory security, exanak e bayc shat chi ogtagorcvum
//    @Bean
//    public UserDetailsService userDetailsService(){
//        UserDetails user1 = User.withUsername("user")//mxac login
//                .username("user")
//                .password(passwordEncoder.encode("pass"))//u mxac password
//                .roles("USER")
//                .build();
//        InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1);
//        return inMemoryUserDetailsManager;
//    }

    //irakan securityn grum e ayspes
    // piti asenq te vorexic gna gtni usernameov userin(mer depqum db-ic), dra hamar
    // piti tanq class vory implement e anum UserDetailsService-y u ira miak metody, vortex asum enq te vortexic userin gtni
    @Autowired
    public UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf().disable()
                .authorizeRequests()
                .antMatchers("/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login();
    //csrf-y tokennery inch vor hamakarg e vory mer sayti bolor formaneri mej piti dnenq,
                // vor sayti formen inch vor tocken e generacnwum, u naxqan controller galy mi hat securityn stugum e te ira generacrac tockenn er te che
                // himnakanum sa chenq ogtagwrcum, dra hamar disable arecinq
                //.authorizeHttpRequests()
                //.requestMatchers(HttpMethod.GET/*vor metodov dime*/,"/"/*vor controllerin, es depqum glavni ejy bacoxin*/)
                //.permitAll()//bolorin tuyl tur glavni ejy mtnel
                //.requestMatchers(HttpMethod.GET,"/customLogin").permitAll()
                //.requestMatchers("/user/register").permitAll()
//                .requestMatchers("/categories/remove").hasAnyAuthority("ADMIN")//ayspes miayn adminnern en karox remove gnal
//                .requestMatchers("/vendor/**").permitAll()
//                .requestMatchers("/css/**").permitAll()
//                .requestMatchers("/js/**").permitAll()
//                .requestMatchers("/img/**").permitAll()
//                .requestMatchers("/categories/**").hasAnyAuthority("ADMIN", "USER")
                //.requestMatchers("/user/admin").hasAuthority("ADMIN")
                //.anyRequest().authenticated()//mnacac bolor ejeri hamar piti grancvi
                //.and()//????????????????????????????????????????????????????
                //formLogin talov springy haskanum e vor logini ej piti baci
                //.formLogin();//ete formLogin()-y verjinn e, sa nshanakum e vor Springi logini pagen e
                            // ashxatelu, bayc hima formLogin()-ic heto eli functionner enq grelu vor mer sarqac logini ejy baci

                //.loginPage("/customLogin")
//                .defaultSuccessUrl("/customSuccessLogin")//login lineluc heto kanchi sa, isk menq (type-ic elnelov, admin e te user)  kvoroshenq ur uxarkenq
//                .loginProcessingUrl("/login")//asum enq vor logini processy tox Springy ani, voch te menq
//                .permitAll()
//                .and()//???????????????????????????????????????????/
//                .logout()
//                .logoutSuccessUrl("/")//te logoutic heto vor eji vra gna
                //.permitAll();

        return httpSecurity.build();
    }


    //kanfiguracia enq talis te inch dzevov piti login lini
    //stexic haskanum  e vor setUserDetailsService()-y piti lini setUserDetailsService-y vory mer CustomUserDetailsService-n e
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        //mer depqum db-ic enq vercnelu, dra hamar ogtagorcum en DaoAuthenticationProvider
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(userDetailsService);
//        authenticationProvider.setPasswordEncoder(passwordEncoder);
//        return authenticationProvider;
//    }

}