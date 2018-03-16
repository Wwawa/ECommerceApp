package com.oum.e_commerceapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.oum.e_commerceapp.adapter.CategoryAdapter;
import com.oum.e_commerceapp.adapter.ProductAdapter;
import com.oum.e_commerceapp.modal.ProductDomain;

import java.util.ArrayList;

public class ProductActivity extends Activity {

    GridView gridView;
    TextView txtItemCount;
    int itemCount;

    ArrayList<ProductDomain> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        productList = new ArrayList<>();

        gridView = findViewById(R.id.grid_product);

        int position = getIntent().getIntExtra("position", 0);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.description_layout, null));
        builder.create();

        Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_LONG).show();

        switch (position) {
            case 0:
                String[] clothList = {"JEANS", "SHIRTS", "SWEATSHIRT"};
                int[] clothimageList = {R.drawable.jeans, R.drawable.shirt, R.drawable.sweatshirt};
                String[] clothpriceList = {"200 MYR", "100 MYR", "120 MYR"};


                ProductDomain productDomain;
                for (int i = 0; i < clothList.length; i++) {
                    productDomain = new ProductDomain(clothList[i], clothimageList[i], clothpriceList[i]);
                    productList.add(productDomain);
                }

                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));


            case 1:
                String[] electronicList = {"TV", "RADIO", "LAPTOP",};
                int[] electroimageList = {R.drawable.tv, R.drawable.radio, R.drawable.laptop};

                String[] electropriceList = {"500 MYR", "250 MYR", "1000 MYR"};


                for (int i = 0; i < electronicList.length; i++) {
                    productDomain = new ProductDomain(electronicList[i], electroimageList[i], electropriceList[i]);
                    productList.add(productDomain);
                }

                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));

                break;

            case 2:

                String[] softwareList = {"MICROSOFT", "WINDOWS", "LINUX"};
                int[] softwareimageList = {R.drawable.microsoft, R.drawable.windows, R.drawable.linux};

                String[] softwarepriceList = {"200 MYR", "250 MYR", "100 MYR"};

                for (int i = 0; i < softwareList.length; i++) {
                    productDomain = new ProductDomain(softwareList[i], softwareimageList[i], softwarepriceList[i]);
                    productList.add(productDomain);
                }

                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));

                break;

            case 3:

                String[] cellList = {"SAMSUNG", "OPPO", "IPHONE"};
                int[] cellimageList = {R.drawable.samsung, R.drawable.oppo, R.drawable.iphone};

                String[] cellpriceList = {"200 MYR", "250 MYR", "100 MYR"};

                for (int i = 0; i < cellList.length; i++) {
                    productDomain = new ProductDomain(cellList[i], cellimageList[i], cellpriceList[i]);
                    productList.add(productDomain);
                }
                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));

                break;

            case 4:

                String[] autoList = {"BMW", "AUDI", "HONDA"};
                int[] autoimageList = {R.drawable.bmw, R.drawable.audi, R.drawable.hondo};

                String[] autopriceList = {"200 MYR", "250 MYR", "100 MYR"};

                for (int i = 0; i < autoList.length; i++) {
                    productDomain = new ProductDomain(autoList[i], autoimageList[i], autopriceList[i]);
                    productList.add(productDomain);
                }
                gridView.setAdapter(new ProductAdapter(productList, getApplicationContext()));

                break;
        }

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "clicked", Toast.LENGTH_LONG).show();
                productDetails(productList.get(i).getProductName(), productList.get(i).getProductPrice(), productList.get(i).getImageId(), i);
            }
        });
    }

    public void productDetails(final String productName, String productPrice, int imgId, final int position) {
        final AlertDialog alert;
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Get the layout inflater
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        //Inflate and set the layout for the dialog
        //Pass null as the parent view because its going in the dialog layout
        View view = inflater.inflate(R.layout.description_layout, null);
        builder.setView(view);
        alert = builder.create();
        alert.show();

        TextView txtProduct = view.findViewById(R.id.txt_product_name);
        TextView txtPrice = view.findViewById(R.id.txt_price);
        ImageView imageView = view.findViewById(R.id.img_product);
        Button btnCart = view.findViewById(R.id.button);

        txtProduct.setText(productName);
        txtPrice.setText(productPrice);
        imageView.setImageResource(imgId);

        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //cartArray.add(productList.get(position));
                itemCount++;
                updateHotCount(itemCount);
                alert.dismiss();

                ;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.cart_menu,menu);

        final View notifications = menu.findItem(R.id.cart_item).getActionView();

        txtItemCount = (TextView) notifications.findViewById(R.id.cart_badge);
        updateHotCount(itemCount++);
        txtItemCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateHotCount(itemCount++);
            }
        });


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle item selection
        switch (item.getItemId()) {
            case R.id.cart_item:
                //newGame();
                return true;

            default:

                return super.onOptionsItemSelected(item);

        }
    }


    public void updateHotCount(final int new_number) {

        itemCount = new_number;
        if (itemCount <0 ) return;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (itemCount ==0)
                    txtItemCount.setVisibility(View.GONE);
                else {
                    txtItemCount.setVisibility(View.VISIBLE);
                    txtItemCount.setText(Integer.toString(itemCount));
                    // supportInvalidateOptionsMenu();
                }
            }
        });

    }



    }




