package com.tuto.vle.service;
// https://developers.google.com/identity/sign-in/web/backend-auth

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Value;
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
import com.tuto.vle.exception.UserRegisterException;

@Service
public class GoogleService {

  // private String APPLICATION_NAME = "";

  // private final static JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();

  private HttpTransport httpTransport;

  private JsonFactory jsonFactory;

  private GoogleIdTokenVerifier verifier;

  @Value("${google.clientId}")
  private String google_clientId;



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

  public User getVerifiedUser(String idTokenString)
      throws GeneralSecurityException, IOException, Exception {
    GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(new NetHttpTransport(),
        JacksonFactory.getDefaultInstance())
            // Specify the CLIENT_ID of the app that accesses the backend:
            .setAudience(Collections.singletonList(google_clientId))
            // Or, if multiple clients access the backend:
            // .setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
            .build();

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
      user.setSocialToken(idTokenString);

    } else {
      throw new UserRegisterException("Could not register user");
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
