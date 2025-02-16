package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;

public class MailService implements MessageService {

   // private DbRepository repo= new DbRepository();//mailservice dprepositorye sıkı sıkı bapımlı olur

    //private Repository repo = new DbRepository();
    //eğer ben burda objeyi doğrudan verirsen ilerleyen zamanlarda file repository olarak değiştirmek istediğimde.
    //tekrar Mail Service classına gelip objeyi DbRepository den file repository dönüştürmem gerekir

    //eğer benim bir objem başka bir objeye bağımlı ise bu bağımlılığını o anda vermek yerine ihtiyac anında vermek
    //için parametreli constractor ile ben sana bu fieldı vericem deyip .ben bu fielde daha sonra vericem diyoruz yani
    //kullanıcıcağım zaman yani ihtiyac anında içerisine enjekte edebilirim

    private Repository repo;//null

    public MailService(Repository repo) {
        this.repo = repo;
    }

    public void sendMessage(Message message){
        System.out.println("Mesajınız mail ile gönderiliyor...Mesaj: "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {
      //DbRepository repo = new Dbrepository();
        repo.save(message);
    }
}
