package luck.materialdesign.tabsnavigator.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ashwinchandlapur on 04/10/17.
 */

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestInterface {

    @GET("/AshwinChandlapur/ImgLoader/gh-pages/hackerss.json")
    Call<JSONResponse> getJSON();
}