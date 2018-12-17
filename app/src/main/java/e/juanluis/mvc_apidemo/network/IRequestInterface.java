package e.juanluis.mvc_apidemo.network;


import java.util.List;

import e.juanluis.mvc_apidemo.data.FlowerModel;
import rx.Observable;
import retrofit2.http.GET;

public interface IRequestInterface {

    @GET(API_Request.API_LIST)
    Observable<List<FlowerModel>>getFlowerList();
}
