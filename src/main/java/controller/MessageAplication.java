package controller;

import domain.Message;
import repository.DbRepository;
import repository.FileRepository;
import repository.Repository;
import service.MailService;
import service.MessageService;
import service.WhatsappService;

import java.awt.*;

public class MessageAplication {
    public static void main(String[]args){

        Message message = new Message();
        message.setBody("Spring is COMING: ");

//        //bu mesajı maille gönderelim.
//        MailService mailService =new MailService();
//        mailService.sendMessage(message);

//        //bu mesajı whatsapp ile gönderelim
//        WhatsappService whatsappService =new WhatsappService();
//        whatsappService.sendMessage(message);


        // referansımı interfaceden alalım
        Repository repository=new FileRepository();//bağımlılık enjeksiyonu_dependency injection
        MessageService service=new WhatsappService(repository);//servicen parametresine repositoryi enjekte ettikk
        service.sendMessage(message);

        //service artık whatsapp service diye değil mail service olarak çalışsın

        service=new MailService(repository);
        service.sendMessage(message);

        //gönderilen mesajjı kaydedelim
        service.saveMessage(message);

        MessageService service2=new WhatsappService(repository);
        service2.sendMessage(message);
        service2.saveMessage(message);


        //objeler arasındaki bağımlılığı gevşetmek(azaltmak için)için
        //1-- referans olarak interface kullandık
        //2--bağımlılığı yani classın içerisinde objeyi doğrudan vermek yerine daha sonra
        // parametreli constructor(veya setter methodu) ile verdik

        //problem:
        //1-objeleri biz oluşturuyoruz
        //2-objelerin bağımlılıklarını biz manuel olarak enjekte etmek zorundayız

        //çözüm:
        //spring is COMING:
    }
}
