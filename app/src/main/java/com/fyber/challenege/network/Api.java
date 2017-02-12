package com.fyber.challenege.network;


import com.fyber.challenege.data.OffersResponse;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by vezikon on 1/28/15.
 */
public interface Api {

    @GET("offers.json?")
    Observable<OffersResponse> offers(@Query("appid") String appId, @Query("uid") String uId, @Query("ip") String ip,
                                      @Query("locale") String local, @Query("offer_types") String offerTypes,
                                      @Query("timestamp") String timestamp, @Query("hashkey") String hashKey);
}
