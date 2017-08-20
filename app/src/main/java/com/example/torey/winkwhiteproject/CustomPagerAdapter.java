package com.example.torey.winkwhiteproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


class CustomPagerAdapter extends PagerAdapter {
    private TypedArray imageSlideArray;
    private TypedArray titleSlideArray;
    private TypedArray priceProductSlideArray;
    private TypedArray descriptionProductSlideArray;
    private TypedArray howToUseProductSlideArray;
    private Context context;
    private LayoutInflater layoutInflater;


    public CustomPagerAdapter(Context context) {
        this.context = context;
        imageSlideArray = context.getResources().obtainTypedArray(R.array.image_slide);
        titleSlideArray = context.getResources().obtainTypedArray(R.array.title_slide);
        priceProductSlideArray = context.getResources().obtainTypedArray(R.array.price_product_slide);
        descriptionProductSlideArray = context.getResources().obtainTypedArray(R.array.description_product_slide);
        howToUseProductSlideArray = context.getResources().obtainTypedArray(R.array.how_to_use_product_slide);
    }


    @Override
    public int getCount() {
        return imageSlideArray.length();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == (LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe_layout, container, false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.image_slid);
        imageView.setImageResource(imageSlideArray.getResourceId(position, R.drawable.logo_wink_white));
        container.addView(item_view);
        item_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, ThirdActivity.class);
                intent.putExtra("imagesproduct", imageSlideArray.getResourceId(position, R.drawable.logo_wink_white));
                intent.putExtra("nameproduct", titleSlideArray.getString(position));
                intent.putExtra("descriptionproduct", descriptionProductSlideArray.getString(position));
                intent.putExtra("howtouseproduct", howToUseProductSlideArray.getString(position));
                intent.putExtra("priceProduct", priceProductSlideArray.getString(position));
                context.startActivity(intent);
            }
        });
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
