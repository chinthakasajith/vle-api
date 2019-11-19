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
import com.tuto.vle.dto.SignUpRequest;
import com.tuto.vle.exception.CustomException;
import com.tuto.vle.util.CustomErrorCodes;

@Service
public class GoogleService implements AuthenticationService {

  private HttpTransport httpTransport;

  private JsonFactory jsonFactory;

  private GoogleIdTokenVerifier verifier;

  @Value("${google.clientId}")
  private String google_clientId;



  public GoogleService() {

  }

  public User getViewerUserData(SignUpRequest signUpRequest)
      throws GeneralSecurityException, IOException, Exception {

    httpTransport = new NetHttpTransport();
    jsonFactory = JacksonFactory.getDefaultInstance();

    verifier = new GoogleIdTokenVerifier.Builder(httpTransport, jsonFactory)
        // Specify the CLIENT_ID of the app that accesses the backend:
        .setAudience(Collections.singletonList(google_clientId))
        // Or, if multiple clients access the backend:
        // .setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
        .setIssuer("https://accounts.google.com").build();

    Payload payload = null;

    if (verifier != null) {
      payload = getViewerData(signUpRequest.getSocial_token());
    }

    // Use or store profile information
    User user = new User();


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


    user.setFirstName(name);
    user.setLastName(familyName);
    user.setEmail(email);
    // user.setPassword(signUpRequest.getPassword());
    user.setSocialType(AuthProvider.google.toString());
    user.setSocialToken(signUpRequest.getSocial_token());
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
        throw new CustomException(CustomErrorCodes.GOOGLE_TOKEN_EXPIRED);
      }
    } catch (GeneralSecurityException es) {
      throw new CustomException(CustomErrorCodes.FAIL_USER_REGISTRATION);

    } catch (IOException ei) {
      ei.printStackTrace();
    }

    return payload;
  }

}
