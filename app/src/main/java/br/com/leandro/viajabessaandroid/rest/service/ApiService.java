package br.com.leandro.viajabessaandroid.rest.service;

import br.com.leandro.viajabessaandroid.model.Promotions;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by leandro on 5/3/15.
 */
public interface ApiService
{

    @GET("/promotions/androidVersion/deviceBrand/deviceModel")
    public void getPromotions(Callback<Promotions> callback);

}
