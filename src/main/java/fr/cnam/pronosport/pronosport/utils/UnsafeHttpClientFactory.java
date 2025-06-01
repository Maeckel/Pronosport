package fr.cnam.pronosport.pronosport.utils;

import javax.net.ssl.TrustManager;
import java.net.http.HttpClient;
import javax.net.ssl.*;
import java.net.http.HttpClient;
import java.security.cert.X509Certificate;
import java.security.SecureRandom;

public class UnsafeHttpClientFactory {

        public static HttpClient createUnsafeHttpClient() throws Exception {
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() { return null; }
                        public void checkClientTrusted(X509Certificate[] certs, String authType) { }
                        public void checkServerTrusted(X509Certificate[] certs, String authType) { }
                    }
            };

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustAllCerts, new SecureRandom());

            return HttpClient.newBuilder()
                    .sslContext(sslContext)
                    .build();
        }
    }


