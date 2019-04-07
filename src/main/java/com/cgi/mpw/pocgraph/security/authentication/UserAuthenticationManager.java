package com.cgi.mpw.pocgraph.security.authentication;



import com.cgi.mpw.pocgraph.configurations.AuthProperties;
import com.cgi.mpw.pocgraph.entities.MicrosoftToken;
import com.cgi.mpw.pocgraph.utilities.RestUtilityBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;


@Service
@Scope("prototype")
public class UserAuthenticationManager implements IAuthentificationManager {

  @Autowired AuthProperties authProperties;

  @Autowired RestUtilityBuilder restUtilityBuilder;

  public UserAuthenticationManager() {
  }

  public MicrosoftToken getToken() {

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<String, String>();
    requestParams.add("grant_type", authProperties.getGrantUser());
    requestParams.add("client_id", authProperties.getClientId());
    requestParams.add("client_secret", authProperties.getClientSecret());
    requestParams.add("username", authProperties.getUserEmail());
    requestParams.add("password", authProperties.getUserPassword());
    requestParams.add("scope", authProperties.getDefaultScope());

    ResponseEntity<MicrosoftToken> response = restUtilityBuilder
            .addUrl(authProperties.getAuthentificationUrl())
            .addHeaders(headers)
            .addParametersBody(requestParams)
            .addResponseType(MicrosoftToken.class)
            .post();

    return response.getBody();
  }


}
