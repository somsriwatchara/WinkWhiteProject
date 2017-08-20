package com.example.torey.winkwhiteproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class ThirdActivity extends AppCompatActivity {
    @BindView(R.id.how_to_use)
    TextView howToUse;
    @BindView(R.id.name_product)
    TextView nameProduct;
    @BindView(R.id.description_product)
    TextView descriptionProduct;
    @BindView(R.id.image_product)
    ImageView imageProduct;
    @BindView(R.id.price_product)
    TextView priceProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ButterKnife.bind(this);
        Integer images = getIntent().getIntExtra("imagesproduct",R.drawable.logo_wink_white);
        String name = getIntent().getStringExtra("nameproduct");
        String description = getIntent().getStringExtra("descriptionproduct");
        String howtouse = getIntent().getStringExtra("howtouseproduct");
        String price = getIntent().getStringExtra("priceProduct");

        imageProduct.setImageResource(images);
        nameProduct.setText(name);
        howToUse.setText(howtouse);
        descriptionProduct.setText(description);
        priceProduct.setText(price);
    }
    @OnClick(R.id.buy_product)
    public void OnClickNewApp (){
        Uri uri = Uri.parse("http://line.me/ti/p/k733cFrE9j");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(Intent.createChooser(intent, "Wink White"));

    }
}