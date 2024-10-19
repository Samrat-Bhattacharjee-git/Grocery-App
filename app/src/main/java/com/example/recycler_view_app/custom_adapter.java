package com.example.recycler_view_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class custom_adapter extends RecyclerView.Adapter<custom_adapter.MyViewHolder> {
    private final List<model_class> itemList;

    public ItemsClickListner clickListner;

    public void setClickListner(ItemsClickListner mylistner){
        this.clickListner = mylistner;
    }

    public custom_adapter(List<model_class> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);


        return new MyViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        model_class item=itemList.get(position);

        holder.img.setImageResource(item.getImg());
        holder.title.setText(item.getTitle());
        holder.des.setText(item.getDescription());


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView img;
        TextView title;
        TextView des;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            img=itemView.findViewById(R.id.img);
            title=itemView.findViewById(R.id.title1);
            des=itemView.findViewById(R.id.description1);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(clickListner != null){

                clickListner.onClick(view,getAdapterPosition());

            }
        }
    }

}
