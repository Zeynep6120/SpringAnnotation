package com.tpe;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Random;
import java.util.Scanner;

@Configuration //bu class ta yapılandırma ayarları yapılacaktır
@ComponentScan("com.tpe")//bu path de yer alan tüm componentleri tarar
//default path: AppConfiguration classının içinde bulunduğu path tanımlar
public class AppConfiguration {

    @Bean//thirdParty classtan bean oluşturulmasını sağlar
    public Random random(){
        return new Random();
    }

    @Bean//thirdParty classtan bean oluşturulmasını sağlar
    //classı ben yazmadıysam constructori ile method kullanılarak bean objesi üretilir
    public Scanner scanner(){
        return new Scanner(System.in);
    }
}
