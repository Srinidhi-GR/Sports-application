package com.example.sportsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    ArrayList<cardModelClass> sportCards;

    ItemClickListener clickListener;

    public void setClickListener(ItemClickListener clickListener){
        this.clickListener = clickListener;
    }

    public CustomAdapter(ArrayList<cardModelClass> sportCards) {
        this.sportCards = sportCards;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        cardModelClass card = sportCards.get(position);
        holder.sportName.setText(card.getSportsName());
        holder.sportImg.setImageResource(card.getSportsImage());
    }

    @Override
    public int getItemCount() {
        return sportCards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView sportImg;
        TextView sportName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.sportImg = itemView.findViewById(R.id.sportsImage);
            this.sportName = itemView.findViewById(R.id.sportsName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if(clickListener != null){
                clickListener.onClick(v, getAdapterPosition());
            }
        }
    }
}
