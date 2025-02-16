package com.tpe.service;

import com.tpe.domain.Message;
import com.tpe.repository.Repository;

public class WhatsappService implements  MessageService {
    //private Repository repo = new FileRepository();

    private Repository repo;
    //whatsapp service repository ye bağımlıdır fakat ben bunu parametreli constructor ile sonradan vericem.
    //fakat bunun için setter methodu da kullanılabilir dı

    public WhatsappService(Repository repo) {
        this.repo = repo;
    }

    @Override
    public void sendMessage(Message message) {
        System.out.println("Mesajınız whatsapp ile gönderiliyor... Mesaj: "+message.getBody());
    }

    @Override
    public void saveMessage(Message message) {

    }
}
