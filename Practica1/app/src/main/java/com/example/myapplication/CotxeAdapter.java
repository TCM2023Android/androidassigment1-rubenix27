package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CotxeAdapter extends RecyclerView.Adapter<CotxeAdapter.ViewHolder>{

    private ArrayList<Cotxe> data;

    @NonNull
    @Override
    public CotxeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        ViewHolder vh=new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull CotxeAdapter.ViewHolder holder, int position) {
        Cotxe c= data.get(position);

        holder.tvAlias.setText(String.valueOf(c.getAlias()));
        holder.tvMarca.setText(c.getMarca());
        holder.tvModel.setText(c.getModel());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvAlias,tvMarca, tvModel;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            tvAlias=itemView.findViewById(R.id.tvAlias);
            tvMarca=itemView.findViewById(R.id.tvMarca);
            tvModel=itemView.findViewById(R.id.tvModel);
        }
    }


}
