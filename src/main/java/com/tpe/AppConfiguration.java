package com.tpe;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration //bu class ta yapılandırma ayarları yapılacaktır
@ComponentScan("com.tpe")//bu path de yer alan tüm componentleri tarar
//default path: AppConfiguration classının içinde bulunduğu path tanımlar
public class AppConfiguration {
    public static void main(String[] args) {

    }
}
