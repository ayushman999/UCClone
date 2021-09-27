package com.ayushman999.urbanclapclone.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ayushman999.urbanclapclone.Listener.ClickListener;
import com.ayushman999.urbanclapclone.Model.Seller;
import com.ayushman999.urbanclapclone.R;
import com.ayushman999.urbanclapclone.databinding.SellingModelBinding;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class SellingAdapter extends RecyclerView.Adapter<SellingAdapter.SellerHolder> {
    ArrayList<Seller> list;
    ClickListener listener;
    public SellingAdapter(ArrayList<Seller> list, ClickListener listener)
    {
        this.list=list;
        this.listener=listener;
    }
    @NonNull
    @NotNull
    @Override
    public SellerHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View myView= LayoutInflater.from(parent.getContext()).inflate(R.layout.selling_model,parent,false);
        SellerHolder holder=new SellerHolder(myView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull SellerHolder holder, int position) {
        Seller s=list.get(position);
        holder.binding.sellerName.setText(s.getName());
        holder.binding.sellerSkill.setText(s.getSkill());
        holder.binding.sellerAddress.setText(s.getAddress());
        holder.binding.sellerCard.setOnClickListener(v->{
            listener.onSellerClick(s);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class SellerHolder extends RecyclerView.ViewHolder {
        SellingModelBinding binding;
        public SellerHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            binding=SellingModelBinding.bind(itemView);
        }
    }
}
