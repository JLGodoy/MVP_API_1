package e.juanluis.mvc_apidemo.presentation;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import e.juanluis.mvc_apidemo.R;
import e.juanluis.mvc_apidemo.data.FlowerModel;

public class FloweraAdapter extends RecyclerView.Adapter<FloweraAdapter.ViewHolder>{

    private ArrayList<FlowerModel> mFlowerList;

    public FloweraAdapter(List<FlowerModel> flowerList){
        this.mFlowerList =mFlowerList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

        holder.mName.setText(mFlowerList.get(i).getName());
        holder.mCategory.setText(mFlowerList.get(i).getCategory());
        holder.mProductId.setText("ID: " + mFlowerList.get(i).getProductId());
        holder.mPrice.setText("$" + mFlowerList.get(i).getPrice());
        holder.mInstructions.setText(mFlowerList.get(i).getInstructions());

        String URL = "http://services.hanselandpetal.com/photos/" + mFlowerList.get(i).getPhoto();
        Picasso.get()
                .load(URL)
                .resize(120, 120)
                .centerCrop()
                .into(holder.mPhoto);

    }

    @Override
    public int getItemCount() {
        return mFlowerList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mName, mCategory, mProductId, mPrice, mInstructions;
        private ImageView mPhoto;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mName = itemView.findViewById(R.id.ap_text_name);
            mCategory = itemView.findViewById(R.id.ap_text_category);
            mProductId = itemView.findViewById(R.id.ap_text_id);
            mPrice = itemView.findViewById(R.id.ap_text_price);
            mInstructions = itemView.findViewById(R.id.ap_text_instructions);
            mPhoto = itemView.findViewById(R.id.ap_photo);


        }
    }
}
