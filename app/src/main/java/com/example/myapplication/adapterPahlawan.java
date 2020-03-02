package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapterPahlawan extends RecyclerView.Adapter<adapterPahlawan.ViewHolder> {
    private ArrayList<modelPahlawan> pahlawan;
    private Context context;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pahlawan,parent,false);
        return new ViewHolder(itemRow);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(getPahlawan().get(position).getHeroesImages()).into(holder.gambar);
        holder.nama.setText(getPahlawan().get(position).heroNames);
//        holder.detail.setText(getPahlawan().get(position).heroDetails);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Main2Activity.class);
                intent.putExtra("name", getPahlawan().get(position).heroNames);
                intent.putExtra("deskription",getPahlawan().get(position).heroDetails);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getPahlawan().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView gambar;
        private TextView nama, detail;
        LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gambar = itemView.findViewById(R.id.gb);
            nama = itemView.findViewById(R.id.judul);
            //detail = itemView.findViewById(R.id.deskripsi);
            parentLayout = itemView.findViewById(R.id.parentLayout);



        }
    }

    public ArrayList<modelPahlawan> getPahlawan() {
        return pahlawan;
    }

    public void setPahlawan(ArrayList<modelPahlawan> pahlawan) {
        this.pahlawan = pahlawan;
    }

    public adapterPahlawan(Context context) {
        this.context = context;
    }
}
