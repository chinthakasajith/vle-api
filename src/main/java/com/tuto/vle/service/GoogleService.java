package com.tuto.vle.service;
// https://developers.google.com/identity/sign-in/web/backend-auth

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import org.springframework.stereotype.Service;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.tuto.vle.domain.User;
import com.tuto.vle.dto.AuthProvider;

@Service
public class GoogleService {

  // private String APPLICATION_NAME = "";

  // private final static JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

  private HttpTransport httpTransport;

  private JsonFactory jsonFactory;

  private GoogleIdTokenVerifier verifier;



  public GoogleService() {


    // APPLICATION_NAME = proputil.getProperty("google.app.name");
    // try {
    // httpTransport = new NetHttpTransport();
    // jsonFactory = JacksonFactory.getDefaultInstance();
    //
    // String audIds = "545664378170-pm68dsiuke80uukfri8kv1mho1hc4345.apps.googleusercontent.com";
    // System.out.println(audIds);
    // String[] audIdArray = audIds.split("\\|");
    //
    // verifier = new GoogleIdTokenVerifier.Builder(httpTransport, jsonFactory)
    // .setAudience(Arrays.asList(audIdArray)).setIssuer("https://accounts.google.com").build();
    //
    // } catch (Exception eg) {
    // System.out.println(eg);
    // }

  }

  public User getVerifiedUser(String idTokenString) throws GeneralSecurityException, IOException {
    GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(),
        JacksonFactory.getDefaultInstance())
            // Specify the CLIENT_ID of the app that accesses the backend:
            .setAudience(Collections.singletonList(
                "545664378170-pm68dsiuke80uukfri8kv1mho1hc4345.apps.googleusercontent.com"))
            // Or, if multiple clients access the backend:
            // .setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
            .build();

    // (Receive idTokenString by HTTPS POST)
    // String idTokenString =
    // "eyJhbGciOiJSUzI1NiIsImtpZCI6ImVlNGRiZDA2YzA2NjgzY2I0OGRkZGNhNmI4OGMzZTQ3M2I2OTE1YjkiLCJ0eXAiOiJKV1QifQ.eyJpc3MiOiJodHRwczovL2FjY291bnRzLmdvb2dsZS5jb20iLCJhenAiOiI0MDc0MDg3MTgxOTIuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiI0MDc0MDg3MTgxOTIuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMTI0MzU5Mjg4NTY5OTgzMTE4OTIiLCJhdF9oYXNoIjoiQUZsa1pEZDVpZ2dmQkVMM0ZLTU1UQSIsIm5hbWUiOiJNSURJVEhBIEZFUk5BTkRPIiwicGljdHVyZSI6Imh0dHBzOi8vbGgzLmdvb2dsZXVzZXJjb250ZW50LmNvbS9hLS9BQXVFN21CTkJTVDdtMVhHMHllMk9SalZDdkNvQjdxUURjaV9JekhMcTJGS3hBPXM5Ni1jIiwiZ2l2ZW5fbmFtZSI6Ik1JRElUSEEiLCJmYW1pbHlfbmFtZSI6IkZFUk5BTkRPIiwibG9jYWxlIjoiZW4iLCJpYXQiOjE1NzA1MjE1MTUsImV4cCI6MTU3MDUyNTExNX0.R-KYqR0sugo6mr9GYT5RfiW9z71zfo9WsX0l1QA_8g9HcjDrUnwESYq3uaglz0RFsti0iw1zq551A-NAf7nKH3enJT5NkkD6wsmqMD0C6EUH_Fl9g438rV1IWVpKcMRlqTGJrv8i9LAjXuDU7biedpHoZAg7E0r2PkeGshHCJjYPuUmq1gXmlUlpfXbhM7MRnvYq4u7zvPUsAHhkAg4D8307XP6GnT9oTYgN9gCMlOivY5_Ff584vfc4p0OOk6OdCCQHqgtxzutqe7Zb-BpbAOEu4zL09eCzIWWjYJE8jn-rA3X6Onv6G2rx4iKKo-viAa3ymMeWgbvvzlaqPsAm-A";
    GoogleIdToken idToken = verifier.verify(idTokenString);
    // Use or store profile information
    User user = new User();
    if (idToken != null) {
      Payload payload = idToken.getPayload();

      // Print user identifier
      String userId = payload.getSubject();
      System.out.println("User ID: " + userId);

      // Get profile information from payload
      String email = payload.getEmail();
      boolean emailVerified = Boolean.valueOf(payload.getEmailVerified());
      String name = (String) payload.get("name");
      String pictureUrl = (String) payload.get("picture");
      String locale = (String) payload.get("locale");
      String familyName = (String) payload.get("family_name");
      String givenName = (String) payload.get("given_name");


      user.setLastName(familyName);
      user.setEmail(email);
      // user.setPassword(signUpRequest.getPassword());
      user.setSocialType(AuthProvider.google.toString());

    } else {
      System.out.println("Invalid ID token.");
    }
    return user;
  }

  public Payload getViewerData(String accessTokenID) {
    Payload payload = null;
    GoogleIdToken idToken = null;
    try {
      idToken = verifier.verify(accessTokenID);
      if (idToken != null) {
        payload = idToken.getPayload();
      } else {
        System.out.println("empty");
      }
    } catch (GeneralSecurityException es) {
      es.printStackTrace();

    } catch (IOException ei) {
      ei.printStackTrace();
    }

    return payload;
  }

}
