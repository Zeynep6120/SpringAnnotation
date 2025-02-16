package com.tpe.controller;

import com.tpe.AppConfiguration;
import com.tpe.domain.Message;
import com.tpe.repository.DbRepository;
import com.tpe.repository.Repository;
import com.tpe.service.MessageService;
import com.tpe.service.SlackService;
import com.tpe.service.SmsService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class MessageApplicationWithSpring {
    public static void main(String[] args) {
        Message message=new Message();
        message.setBody("Welcome SPRING: ");

        //config classını okur ve componentscan ile componentları ve beanleri tarar ve her birinden
        //sadece 1 tane Spring bean oluşturur ve contexte atar ve hazır olarak bekletir.
        //bean istendiğinde gerekliyse içine bağımlılığını da enjekte ederek gönderir.
        AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(AppConfiguration.class);

//        //bu mesajı sms ile gönderelim:smsservice nin objesi gerekli
//        MessageService service1=context.getBean(SmsService.class);//newlemedik.context ten rica ettik.
//        service1.sendMessage(message);
//
//        MessageService service2=context.getBean("sms_service",MessageService.class);//sms service,slackService
//        //sms_service den bean istiyorum dedim,
//        service2.sendMessage(message);
//
//        //getBean methoduna parametre olarak parenti verirsek ve birden fazla childi varsa beanin ismini belirtmeliyi
////(MessageService.class);burda ben dedimki benim mesaj service data tipinde bir objeye ihtiyacım var dedim.Message service
//        //bir interface ve onun objesi olmaz bu yüzden onun türünde olan sms servie gönderdi bana
//
//        //mesajı Slack ile gönderelim
//        MessageService service3=context.getBean(SlackService.class);
//        service3.sendMessage(message);

        //eğer talep ettiğim bean yani şuan sms service repository e bağımlı
        //biz bu bağımlılığı autowired annotasyoni ile otomatik olarka enjekte edilmesini sağlayabiliriz.
        MessageService service4=context.getBean(SmsService.class);
        service4.sendMessage(message);
        service4.saveMessage(message);
        //smsService i newlemedik
        //service repoya bağımlı ama biz enjekte etmedik
        //repo objesini de biz oluşturmadık
        //Spring SAĞOLSUN:)


        Repository repository = context.getBean(DbRepository.class);
        repository.save(message);
        //dp repository i burada kullanabildiğim gibi sms service içine de enjekte ediliyorum.ve iki yerde de kullandığım
        //obje aynı obje .


        //random bir değer üretelim ve yazdıralım
        //Random random= new Random();
        Random random=context.getBean(Random.class);
        //bana context ten random class ı tipinde bir bean verirmisin
        //random objemiz var context te ve biz constuctor kullanmadan random objemize ulaştık
        System.out.println("random değer: "+random.nextInt(100));


        MessageService service5= context.getBean(SlackService.class);
       // service5.saveMessage(message);


        MessageService service6=context.getBean(SlackService.class);
        MessageService service7=context.getBean(SlackService.class);

        if(service6==service7){
            System.out.println("Aynı Objeler");
            System.out.println(service6);
            System.out.println(service7);
        }else{
            System.out.println("Farklı Objeler");
            System.out.println(service6);
            System.out.println(service7);
        }
    context.close();
        context.close();

//        SmsService service=context.getBean(SmsService.class);
//        service.sendMessage(message);


    }
}
/*
Singleton Scope
Spring konteyneri, bir bean tanımı için yalnızca bir örnek (instance) oluşturur ve bu örneği tüm uygulama boyunca paylaşır.
Bean, Spring konteyneri başlatıldığında oluşturulur.
Uygulama kapanana kadar aynı örnek kullanılır.
Stateless (Durumsuz) nesneler için kullanılır.
Aynı davranışı ve veriyi paylaşması gereken hizmet sınıfları (örneğin, Service ve Repository sınıfları) için idealdir.
Tek bir örnek oluşturulduğu için bellek tüketimini azaltır.
----------------
Prototype Scope
Spring konteyneri, bir bean'e her erişimde yeni bir örnek (instance) oluşturur.
Bean, Spring konteyneri tarafından her çağrıldığında (örneğin, getBean() metodu ile) yeniden oluşturulur.
Kısa ömürlüdür ve Spring konteyneri yaşam döngüsünü yönetmez.
Stateful (Durum bilgisi taşıyan) nesneler için kullanılır.
Her istekte farklı veriyle çalışması gereken nesneler (örneğin, kullanıcı oturum bilgisi veya dosya işlemleri) için uygundur.
-------------
Singleton: Varsayılan olduğu için Spring genellikle bu scope'u kullanır ve çoğu servis veya repository sınıfı için yeterlidir.
Prototype: Kısa ömürlü nesneler için kullanışlıdır, ancak manuel olarak yönetilmesi gerekebilir. Özellikle Spring konteynerinin dışında kullanılan prototip nesnelerin yaşam döngüsüne dikkat edilmelidir.
 */