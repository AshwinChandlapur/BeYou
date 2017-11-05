package luck.materialdesign.tabsnavigator.retrofit_MainPage;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ashwinchandlapur on 04/10/17.
 */

public interface RequestInterface_MP {

    @GET("/AshwinChandlapur/BeYouJson/master/Lifestyle/beauty.json")
    Call<JSONResponse_MP> getBeauty();

    @GET("/AshwinChandlapur/BeYouJson/master/Lifestyle/fashion.json")
    Call<JSONResponse_MP> getFashion();

    @GET("/AshwinChandlapur/BeYouJson/master/Lifestyle/food.json")
    Call<JSONResponse_MP> getFood();

    @GET("/AshwinChandlapur/BeYouJson/master/Lifestyle/intimacy.json")
    Call<JSONResponse_MP> getIntimacy();

    @GET("/AshwinChandlapur/BeYouJson/master/Lifestyle/lifestyle.json")
    Call<JSONResponse_MP> getLifeStyle();

    @GET("/AshwinChandlapur/BeYouJson/master/Lifestyle/relationships.json")
    Call<JSONResponse_MP> getRelationships();

    @GET("/AshwinChandlapur/BeYouJson/master/Lifestyle/wedding.json")
    Call<JSONResponse_MP> getWedding();

    @GET("/AshwinChandlapur/BeYouJson/master/Lifestyle/work.json")
    Call<JSONResponse_MP> getWork();

}