package org.alekseev.webshop.configuration;

import org.alekseev.webshop.Constants;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController(Constants.URL).setViewName(Constants.INDEX);
        registry.addViewController(Constants.URL_LOGIN).setViewName(Constants.LOGIN);
    }
}
