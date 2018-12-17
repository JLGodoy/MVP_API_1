package e.juanluis.mvc_apidemo.network;

import java.util.List;


import e.juanluis.mvc_apidemo.data.FlowerModel;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

public class ConnectionService implements IFlower_Interacter{

    private static Retrofit retrofit;
    private static OkHttpClient okHttpClient;






    public ConnectionService(){ getConnection(); }

    public static IRequestInterface getConnection(){



        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(API_Request.FLOWER_BASE_URL)
                .build();

        return retrofit.create(IRequestInterface.class);

    }

    @Override
    public Observable<List<FlowerModel>> getFlowerList(){
        return getConnection().getFlowerList();
    }
}
