package com.tuto.vle.service;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;

@Service
public class EmailService {

  @Value("${sendgrid.apiKey}")
  private String SENDGRID_API_KEY;

  public void sendEmail(String subject, String toEmail, String contentString) throws IOException {
    Email from = new Email("chinthaka@tuto.com");
    Email to = new Email(toEmail);
    Content content = new Content("text/plain", contentString);
    Mail mail = new Mail(from, subject, to, content);

    SendGrid sg = new SendGrid(SENDGRID_API_KEY);
    Request request = new Request();
    try {
      request.setMethod(Method.POST);
      request.setEndpoint("mail/send");
      request.setBody(mail.build());
      Response response = sg.api(request);
      System.out.println(response.getStatusCode());
      System.out.println(response.getBody());
      System.out.println(response.getHeaders());
    } catch (IOException ex) {
      throw ex;
    }
  }
}
