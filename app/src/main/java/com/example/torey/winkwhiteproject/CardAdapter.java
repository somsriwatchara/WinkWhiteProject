package com.example.torey.winkwhiteproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by TOREY on 08/06/17.
 */

class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardHolder> {
    private TypedArray titleArray;
    private TypedArray logoArray;
    private TypedArray priceProductArray;
    private TypedArray nameproductArray;
    private TypedArray descriptionproductArray;
    private TypedArray howTOUseproductArray;

    private Context context;

    CardAdapter(Context context) {
        this.context = context;
        titleArray = context.getResources().obtainTypedArray(R.array.title_place);
        logoArray = context.getResources().obtainTypedArray(R.array.logo_drawable);
        nameproductArray = context.getResources().obtainTypedArray(R.array.title_place);
        descriptionproductArray = context.getResources().obtainTypedArray(R.array.description_product);
        howTOUseproductArray = context.getResources().obtainTypedArray(R.array.how_to_use_product);
        priceProductArray = context.getResources().obtainTypedArray(R.array.price_product);
    }

    @Override
    public CardHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_view
                , parent, false);
        return new CardHolder(v);
    }

    @Override
    public void onBindViewHolder(final CardHolder holder, final int position) {
        holder.logoImageView.setImageResource(logoArray.getResourceId(position, R.drawable.logo_wink_white));
        holder.titleView.setText(titleArray.getString(position));
        holder.cardViewClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "Position = " + position, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, ThirdActivity.class);
                intent.putExtra("imagesproduct", logoArray.getResourceId(position, R.drawable.logo_wink_white));
                intent.putExtra("nameproduct", nameproductArray.getString(position));
                intent.putExtra("descriptionproduct", descriptionproductArray.getString(position));
                intent.putExtra("howtouseproduct", howTOUseproductArray.getString(position));
                intent.putExtra("priceProduct", priceProductArray.getString(position));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {

        return titleArray.length();
    }


    class CardHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.title_name)
        TextView titleView;
        @BindView(R.id.logo_image)
        ImageView logoImageView;
        @BindView(R.id.card_view)
        CardView cardViewClick;


        CardHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }

}

