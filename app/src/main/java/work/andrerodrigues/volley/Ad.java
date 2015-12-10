package work.andrerodrigues.volley;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andre on 07/12/2015.
 */
public class Ad {

    private String name;
    private String urlImg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    @Override
    public String toString() {
        return "Ad{" +
                "name='" + name + '\'' +
                ", urlImg='" + urlImg + '\'' +
                '}';
    }
}
