package luck.materialdesign.tabsnavigator.retrofit_BeautyTips;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ashwinchandlapur on 04/10/17.
 */

public interface RequestInterface_BT {

    @GET("/AshwinChandlapur/BeYouJson/master/Lifestyle/lifestyle.json")
    Call<JSONResponse_BT> getJSON();

    @GET("/AshwinChandlapur/BeYouJson/master/Lifestyle/sampleContent.json")
    Call<JSONResponse_BT> getContentsEyes();

    //------------------------------Actual JSON ------------------------
    @GET("/AshwinChandlapur/BeYouJson/master/Eyes/eyesAll.json")
    Call<JSONResponse_BT> getEyesAll();

    @GET("/AshwinChandlapur/BeYouJson/master/Eyes/darkcirlces.json")
    Call<JSONResponse_BT> getDarkCircles();

    @GET("/AshwinChandlapur/BeYouJson/master/Eyes/eyebrows.json")
    Call<JSONResponse_BT> getEyeBrows();

    @GET("/AshwinChandlapur/BeYouJson/master/Eyes/eyecare.json")
    Call<JSONResponse_BT> getEyeCare();

    @GET("/AshwinChandlapur/BeYouJson/master/Lifestyle/face.json")
    Call<JSONResponse_BT> getFace();

    @GET("/AshwinChandlapur/BeYouJson/master/Lifestyle/hair.json")
    Call<JSONResponse_BT> getHair();

    @GET("/AshwinChandlapur/BeYouJson/master/Lifestyle/mind.json")
    Call<JSONResponse_BT> getMind();

    @GET("/AshwinChandlapur/BeYouJson/master/Lifestyle/skin.json")
    Call<JSONResponse_BT> getSkin();

}