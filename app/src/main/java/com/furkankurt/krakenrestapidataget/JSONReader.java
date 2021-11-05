package com.furkankurt.krakenrestapidataget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class JSONReader {
    public String Read(String urls) {
        String OkunanVeriler="";
        try {
            URL url = new URL(urls);
            HttpsURLConnection cnn = (HttpsURLConnection) url.openConnection();
            cnn.setRequestMethod("GET");//Url'de ne tür işlem yapılacak GET(Çekmek-Reques)-POST(Göndermek-Response)
            //Bazı durumlarda hangi tür verinin geldiğini bilemeyiz veya tahmin edemeyiz.
            //Bu tarz durumlarda verinin ne tür olduğu ile ilgilenmeyen sadece okumaya odaklanan sınıflarımzı vardır.
            //INPUTSTREAM SINIFI=>Sadece veriyi okumaya odaklanır.
            BufferedReader reader = new BufferedReader(new InputStreamReader(cnn.getInputStream()));
            //Artık verileri alıp satır satır ekrana basacaz.
            String Okunan="";
            while((Okunan=reader.readLine())!=null)
            {
                OkunanVeriler+=Okunan;
            }

        } catch (IOException e) {

        }
        return OkunanVeriler;
    }
}
