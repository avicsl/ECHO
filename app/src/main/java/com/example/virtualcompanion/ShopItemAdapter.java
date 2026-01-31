package com.example.virtualcompanion;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShopItemAdapter
        extends RecyclerView.Adapter<ShopItemAdapter.ViewHolder> {

    // Shop preview images
    private final int[] shopImages;

    // Equip images (on pet)
    private final int[] equipImages;

    // Prices
    private final String[] prices;

    // Click listener
    private final OnItemClickListener listener;


    // ===============================
    // INTERFACE
    // ===============================

    public interface OnItemClickListener {
        void onItemClick(int equipResId);
    }


    // ===============================
    // CONSTRUCTOR
    // ===============================

    public ShopItemAdapter(
            int[] shopImages,
            int[] equipImages,
            String[] prices,
            OnItemClickListener listener
    ) {

        this.shopImages = shopImages;
        this.equipImages = equipImages;
        this.prices = prices;
        this.listener = listener;
    }


    // ===============================
    // VIEW HOLDER
    // ===============================

    static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView itemImage;
        TextView itemPrice;
        LinearLayout priceContainer;

        ViewHolder(View itemView) {
            super(itemView);

            itemImage = itemView.findViewById(R.id.itemImage);
            itemPrice = itemView.findViewById(R.id.itemPrice);
            priceContainer = itemView.findViewById(R.id.priceContainer);
        }
    }


    // ===============================
    // CREATE
    // ===============================

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shop_item, parent, false);

        return new ViewHolder(view);
    }


    // ===============================
    // BIND
    // ===============================

    @Override
    public void onBindViewHolder(
            @NonNull ViewHolder holder,
            int position
    ) {

        // Set shop preview image
        holder.itemImage.setImageResource(shopImages[position]);

        // Set price
        String price = prices[position];

        if (price == null || price.isEmpty()) {

            // Hide price (for cancel)
            holder.priceContainer.setVisibility(View.GONE);

        } else {

            holder.priceContainer.setVisibility(View.VISIBLE);
            holder.itemPrice.setText(price);
        }


        // Click → equip
        holder.itemView.setOnClickListener(v -> {

            if (listener != null) {
                listener.onItemClick(equipImages[position]);
            }
        });
    }


    // ===============================
    // COUNT
    // ===============================

    @Override
    public int getItemCount() {
        return shopImages.length;
    }
}
