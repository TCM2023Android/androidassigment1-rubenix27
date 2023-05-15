package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CotxeAdapter extends RecyclerView.Adapter<CotxeAdapter.ViewHolder>{

    private ArrayList<Cotxe> llista_cotxes;
    private OnItemClickListener listener;
    public CotxeAdapter(ArrayList<Cotxe> llista_cotxes){
        this.llista_cotxes=llista_cotxes;
    }

    public interface OnItemClickListener{
        public void onClick(View view, int position);
    }

    public void setClickListener(OnItemClickListener itemClickListener){
       //preguntar
        this.listener=itemClickListener;
    }



    @NonNull
    @Override
    public CotxeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row,parent,false);
        ViewHolder vh=new ViewHolder(v, listener);

        return vh;
    }



    @Override
    public int getItemCount() {
        return llista_cotxes.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvAlias,tvMarca, tvModel;
        OnItemClickListener onItemClickListener;

        public ViewHolder(@NonNull View itemView, OnItemClickListener onItemClickListener){
            super(itemView);
            this.onItemClickListener=onItemClickListener;
            tvAlias=itemView.findViewById(R.id.tvAlias);
            tvMarca=itemView.findViewById(R.id.tvMarca);
            tvModel=itemView.findViewById(R.id.tvModel);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View view) {
            //preguntar
            onItemClickListener.onClick(view, getAdapterPosition());
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cotxe c= llista_cotxes.get(position);
        holder.tvAlias.setText(String.valueOf(c.getAlias()));
        holder.tvMarca.setText(c.getMarca());
        holder.tvModel.setText(c.getModel());
    }


}
