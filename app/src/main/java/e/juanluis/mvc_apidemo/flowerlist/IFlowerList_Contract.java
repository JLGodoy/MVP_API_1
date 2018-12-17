package e.juanluis.mvc_apidemo.flowerlist;

import java.util.List;

import e.juanluis.mvc_apidemo.data.FlowerModel;

public interface IFlowerList_Contract {

    interface IView_FlowerList{
        //Methods that going to be called in the view
        // by the presenter by using the view instance.
        void _flowerList(List<FlowerModel> flowerModels);



    }

    interface IPresenter_FlowerList{
        //methods that will be called in the view by using the presenter instance

        void onBind(IView_FlowerList iView_flowerList);
        void getListFromAPI();
        void unBind();

    }
}
