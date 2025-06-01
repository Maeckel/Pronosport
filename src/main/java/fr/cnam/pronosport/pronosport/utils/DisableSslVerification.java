package fr.cnam.pronosport.pronosport.utils;

import javax.net.ssl.*;
import java.security.cert.X509Certificate;
import java.security.SecureRandom;

public class DisableSslVerification {
    public static void disable() {
        try {
            // Crée un TrustManager qui fait confiance à tous les certificats
            TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        public X509Certificate[] getAcceptedIssuers() { return null; }
                        public void checkClientTrusted(X509Certificate[] certs, String authType) { }
                        public void checkServerTrusted(X509Certificate[] certs, String authType) { }
                    }
            };

            // Configure le contexte SSL pour ignorer les vérifications
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

            // Désactive la vérification du nom d'hôte
            HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
