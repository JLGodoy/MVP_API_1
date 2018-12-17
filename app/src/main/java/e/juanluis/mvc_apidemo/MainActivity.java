package e.juanluis.mvc_apidemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import e.juanluis.mvc_apidemo.data.FlowerModel;
import e.juanluis.mvc_apidemo.flowerlist.FlowerList_PresentrImpl;
import e.juanluis.mvc_apidemo.flowerlist.IFlowerList_Contract;
import e.juanluis.mvc_apidemo.network.ConnectionService;
import e.juanluis.mvc_apidemo.network.IFlower_Interacter;
import e.juanluis.mvc_apidemo.presentation.FloweraAdapter;

public class MainActivity extends AppCompatActivity implements IFlowerList_Contract.IView_FlowerList {

    private FlowerList_PresentrImpl flowerList_presentr;
    private IFlower_Interacter iFlower_interacter;

    private RecyclerView mRecyclerView;

    private FloweraAdapter mAdapter;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _doCallFromAPI();
    }

    @Override
    public void _flowerList(List<FlowerModel> flowerModels) {
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        mRecyclerView.setLayoutManager(layoutManager);

        mAdapter = new FloweraAdapter(flowerModels);
        mRecyclerView.setAdapter(mAdapter);
    }

    public void _doCallFromAPI() {
        iFlower_interacter = new ConnectionService();
        flowerList_presentr = new FlowerList_PresentrImpl(iFlower_interacter);
        flowerList_presentr.onBind(this);
        flowerList_presentr.getListFromAPI();
    }




    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void onDestroy() {
        super.onDestroy();
        flowerList_presentr.unBind();
    }
}
