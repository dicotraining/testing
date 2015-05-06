package es.adama.integrationTest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.junit.Test;

import java.io.IOException;

import static org.fest.assertions.api.Assertions.assertThat;

@SuppressWarnings("deprecation")
public class ControladorIT {
  private static final String URL = "http://localhost:8080/numero";

  @Test
  public void testIfAppIsUp() throws IOException {

      HttpClient client = new DefaultHttpClient();
      HttpGet httpget = new HttpGet(URL);

    
      HttpResponse response = client.execute(httpget);

    
      assertThat(response.getStatusLine().getStatusCode()).isEqualTo(HttpStatus.SC_OK);
  }
}

