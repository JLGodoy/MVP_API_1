package e.juanluis.mvc_apidemo.network;

import java.util.List;
import rx.Observable;

import e.juanluis.mvc_apidemo.data.FlowerModel;

public interface IFlower_Interacter {

    Observable<List<FlowerModel>>getFlowerList();
}
