package e.juanluis.mvc_apidemo.flowerlist;

import java.util.List;

import e.juanluis.mvc_apidemo.data.FlowerModel;
import e.juanluis.mvc_apidemo.network.IFlower_Interacter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FlowerList_PresentrImpl implements IFlowerList_Contract.IPresenter_FlowerList {

    private IFlowerList_Contract.IView_FlowerList iView_flowerList;
    private IFlower_Interacter iFlower_interacter;

    public FlowerList_PresentrImpl(IFlower_Interacter iFlower_interacter) {
        this.iFlower_interacter = iFlower_interacter;
    }


    @Override
    public void onBind(IFlowerList_Contract.IView_FlowerList iView_flowerList) {
        this.iView_flowerList = iView_flowerList;
    }

    @Override
    public void getListFromAPI() {
        iFlower_interacter.getFlowerList()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<FlowerModel>>(){

                    @Override
                    public void onCompleted(){

                    }

                    @Override
                    public void onError(Throwable e) {

                    }



                    @Override
                    public void onNext(List<FlowerModel> flowerModel){
                        iView_flowerList._flowerList(flowerModel);

                    }
                });

    }

    @Override
    public void unBind() {
        this.iView_flowerList = null;

    }
}
