package com.codegym.config;

import com.codegym.service.ClassRoomService;
import com.codegym.service.StudentService;
import com.codegym.service.impl.ClassRoomServiceImpl;
import com.codegym.service.impl.StudentServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
    @Bean
    public ClassRoomService classRoomService(){
        return new ClassRoomServiceImpl();
    }
    
    @Bean
    public StudentService studentService(){
        return new StudentServiceImpl();
    }
}
