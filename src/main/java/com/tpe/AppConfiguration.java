package com.tpe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

@Configuration //bu class ta yapılandırma ayarları yapılacaktır
@ComponentScan("com.tpe")//bu path de yer alan tüm componentleri tarar
//default path: AppConfiguration classının içinde bulunduğu path tanımlar
@PropertySource("classpath:application.properties")
//application.properties dosyasındaki bilgilerin okunmasını sağlar
public class AppConfiguration {

    //Springe ait bir interface, bean oluşturmadan enjekte edilebilir
    //PropertySource daki dosyanın içindeki özelliklere(propertylere)
    //ve hatta uygulamanın çalıştığı ortam değişkenlerine
    //erişmemizi sağlayan methodlar içerir.
    @Autowired
    private Environment environment;
    //springle çalıştığımzı için direk hazır olarak contexte bean i bulunur ayrıca bir daha uygulama yaparken bean
    //oluşturmamıza gerek yok direkt contexten çekeriz

    @Bean//thirdParty classtan bean oluşturulmasını sağlar
    public Random random(){
        return new Random();
    }

    @Bean//thirdParty classtan bean oluşturulmasını sağlar
    //classı ben yazmadıysam constructori ile method kullanılarak bean objesi üretilir
    public Scanner scanner(){
        return new Scanner(System.in);
    }

    //value anatasyonun ile yaptığımız işlemi Environment ve Properties Classı ile yapabiliriz
    @Bean
    public Properties properties(){
        Properties properties=new Properties();
        //properties.put("mymail","techproed@gmail.com");
        properties.put("mymail",environment.getProperty("eposta"));
        properties.put("myphone",environment.getProperty("phone"));
        properties.put("password",environment.getProperty("password.admin"));
        return properties;
    }






}
