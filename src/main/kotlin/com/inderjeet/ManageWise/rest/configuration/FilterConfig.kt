package com.inderjeet.ManageWise.rest.configuration

import com.inderjeet.ManageWise.business.filter.FirebaseAuthenticationFilter
import org.springframework.boot.web.servlet.FilterRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.UrlBasedCorsConfigurationSource

@Configuration
class FilterConfig {

    @Bean
    fun firebaseAuthenticationFilter(): FilterRegistrationBean<FirebaseAuthenticationFilter> {
        val registrationBean = FilterRegistrationBean<FirebaseAuthenticationFilter>()
        registrationBean.filter = FirebaseAuthenticationFilter()
        registrationBean.addUrlPatterns("/v1/user","/v1/user/*","/v1/business","/v1/business/**")
        registrationBean.order = Ordered.HIGHEST_PRECEDENCE
        return registrationBean
    }

    @Bean
    fun corsConfigurationSource(): UrlBasedCorsConfigurationSource {
        val source = UrlBasedCorsConfigurationSource()
        val config = CorsConfiguration().apply {
            allowCredentials = true
            allowedOrigins = listOf("xxxxxxxxxxxxxBaseURLxxxxxxxxxxxxxxxxxxxx")
            allowedHeaders = listOf("*")
            allowedMethods = listOf("GET", "POST", "PUT", "DELETE", "PATCH","OPTIONS")
        }
        source.registerCorsConfiguration("/**", config)
        return source
    }
}