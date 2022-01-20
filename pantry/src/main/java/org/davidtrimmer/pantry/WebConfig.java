//package org.davidtrimmer.pantry;
//
//import org.hibernate.cfg.Environment;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.CorsRegistry;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//import javax.sql.DataSource;
//
//@Configuration
//    @EnableWebMvc
//
//    public class WebConfig implements WebMvcConfigurer {
//        @Override
//        public void addCorsMappings(CorsRegistry registry){
//            registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE");
//        }
//
//        @Autowired
//        private Environment env;
//
//        @Bean
//        public DataSource securityDataSource() {
//
//            ComboPooledDataSource
//        }
//
//    }
//
