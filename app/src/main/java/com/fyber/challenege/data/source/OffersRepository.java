package com.fyber.challenege.data.source;

import android.support.annotation.NonNull;

import com.fyber.challenege.data.OffersResponse;
import com.fyber.challenege.data.source.local.OffersLocalDataSource;
import com.fyber.challenege.data.source.remote.OffersRemoteDataSource;

import rx.Observable;

/**
 * Created by mNagy on 2/12/17.
 */
public class OffersRepository implements OffersDataSource {
    private static OffersRepository INSTANCE;

    private OffersRemoteDataSource remoteDataSource;
    private OffersLocalDataSource localDataSource;

    public static OffersRepository getInstance(@NonNull OffersLocalDataSource localDataSource,
                                               @NonNull OffersRemoteDataSource remoteDataSource) {
        if (INSTANCE == null)
            INSTANCE = new OffersRepository(localDataSource, remoteDataSource);

        return INSTANCE;
    }

    private OffersRepository(@NonNull OffersLocalDataSource localDataSource,
                             @NonNull OffersRemoteDataSource remoteDataSource) {
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
    }

    @Override
    public Observable<OffersResponse> getOffers(String appId, String ip, String locale, String offer_type,
                                                String timestamp, String uId, String token) {
        return remoteDataSource.getOffers(appId, ip, locale, offer_type, timestamp, uId, token);
    }
}