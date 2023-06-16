package com.recyclerview.gridview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyHolder> {
    Context context;
    ArrayList<DataModel> arrayList;

    public Adapter(Context context, ArrayList<DataModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public Adapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_layout, parent, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.name.setText(arrayList.get(position).getName());
        holder.image.setImageResource(arrayList.get(position).getImage());

//set onclick listener
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "" + arrayList.get(position).getName(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("name", arrayList.get(position).getName());
                intent.putExtra("image", arrayList.get(position).getImage());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }


    public static class MyHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView image;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textView);
            image = itemView.findViewById(R.id.imageView);

        }
    }
}
