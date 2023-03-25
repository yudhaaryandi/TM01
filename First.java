package TM01;

import TM01.Connecting;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class First {

    public static void main(String[] args) throws IOException {
        Connecting koneksisaya = new Connecting();
        URL myAddress = koneksisaya.buildURL("https://farmasi.mimoapps.xyz/mimoqss2auyqD1EAlkgZCOhiffSsFl6QqAEIGtM");
        String response = koneksisaya.getResponseFromHttpUrl(myAddress);
//        System.out.println(response);

        assert response != null;
        JSONArray responseJSON = new JSONArray(response);
        ArrayList<GetSet> GetSet =
                new ArrayList<>();
        int count = 0;
        for (int i = 0; i < responseJSON.length(); i++) {
            GetSet resmodel = new GetSet();
            JSONObject myJSONObject =
                    responseJSON.getJSONObject(i);
            String Harga = myJSONObject.
                    getString("i_sell");
            resmodel.setI_sell(Harga);
            GetSet.add(resmodel);

            int priceInt = Integer.parseInt(Harga);
            if (priceInt <= 2000) {
                count++;
            }
        }
//            System.out.println("response are:");
        for (int index = 0; index < GetSet.size(); index++) {
            int sell = Integer.parseInt(GetSet.get(index).getI_sell());
            if (sell <= 2000){

                System.out.println("harga:" + sell);
            }
        }

        System.out.println("total harga obat 2000= " +count);
    }
}



