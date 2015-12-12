package work.andrerodrigues.volley;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 07/12/2015.
 */
public class AdService {

    public static List<Ad> getAds(Context context) {
        List<Ad> ads = new ArrayList<Ad>();
        for (int i=0; i<10; i++) {
            Ad ad = new Ad();
            ad.setName("Anúncio");
            ad.setUrlImg("http://bomercado.com.br/panel/img/products/fchPZwAv_006464.jpg");
            ads.add(ad);
        }
        return ads;
    }
}
