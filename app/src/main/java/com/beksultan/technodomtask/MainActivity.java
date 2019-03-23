package com.beksultan.technodomtask;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.beksultan.technodomtask.adapter.SliderPagerAdapter;
import com.beksultan.technodomtask.adapter.ViewPagerAdapter;
import com.bumptech.glide.Glide;
import com.rd.PageIndicatorView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;

    @BindView(R.id.pageIndicatorView)
    PageIndicatorView pageIndicatorView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.txt_characteristic)
    TextView txt_characteristic;

    @BindView(R.id.txt_description)
    TextView txt_description;

    @BindView(R.id.btn_instruction)
    Button btn_instruction;

    @BindView(R.id.btn_inch13)
    Button btn_inch13;

    @BindView(R.id.btn_inch15)
    Button btn_inch15;

    @BindView(R.id.btn_memory128)
    Button btn_memory128;

    @BindView(R.id.btn_memory512)
    Button btn_memory512;

    @BindView(R.id.btn_grey)
    Button btn_grey;

    @BindView(R.id.btn_pink)
    Button btn_pink;

    @BindView(R.id.btn_grey_light)
    Button btn_grey_light;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.ll_view_offer)
    LinearLayout ll_view_offer;

    @BindView(R.id.ll_send)
    LinearLayout ll_send;

    @BindView(R.id.ll_more_info)
    LinearLayout ll_more_info;

    @BindView(R.id.img_basket)
    ImageView img_basket;

    @BindView(R.id.btn_buy)
    Button btn_buy;

    @BindView(R.id.btn_credit)
    Button btn_credit;

    @BindView(R.id.txt_price_all)
    TextView txt_price_all;

    @BindView(R.id.txt_all_price)
    TextView txt_all_price;

    @BindView(R.id.txt_old_price)
    TextView txt_old_price;

    private SliderPagerAdapter sliderPagerAdapter;
    private int drawables[] = new int[4];
    private boolean isClicked = false;
    private ShapeDrawable black = new ShapeDrawable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(getResources().getDrawable(R.drawable.ic_left_arrow));
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        txt_characteristic.setText("13.3' 2560x1600 | Intel Core i5 5287U | RAM 8 | SSD 512 | MAC OS X | Вес 1,56 кг");
        txt_description.setText("Notebook Apple MacBook Pro 13\" Retina 512 (MF841RS/A)");

        drawables[0] = R.drawable.macbook;
        drawables[1] = R.drawable.mac2;
        drawables[2] = R.drawable.macbook;
        drawables[3] = R.drawable.mac2;
        setSlider();

        txt_price_all.setPaintFlags(txt_price_all.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        txt_old_price.setPaintFlags(txt_old_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        txt_all_price.setPaintFlags(txt_all_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        // setupViewPager(viewPager);
        // tabLayout.setupWithViewPager(viewPager);
    }

    @SuppressLint({"NewApi", "ResourceAsColor"})
    @OnClick({R.id.ll_view_offer,
            R.id.ll_send,
            R.id.fab,
            R.id.btn_instruction,
            R.id.ll_more_info,
            R.id.img_basket,
            R.id.btn_buy,
            R.id.btn_credit,
            R.id.btn_grey,
            R.id.btn_pink,
            R.id.btn_grey_light})
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.fab:
                Toast.makeText(this, "FloatingActionButton", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_view_offer:
                Toast.makeText(this, "Посмотреть предложение", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_send:
                Toast.makeText(this, "Отправить", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_instruction:
                Toast.makeText(this, "Инструкция к товару", Toast.LENGTH_SHORT).show();
                break;
            case R.id.ll_more_info:
                Toast.makeText(this, "Подробнее", Toast.LENGTH_SHORT).show();
                break;
            case R.id.img_basket:
                Toast.makeText(this, "add", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_buy:
                Toast.makeText(this, "купить", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_credit:
                Toast.makeText(this, "в кредит", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_grey:
                isClicked = true;

                ShapeDrawable grey = new ShapeDrawable();

                // Specify the shape of ShapeDrawable
                grey.setShape(new RectShape());

                // Specify the border color of shape
                grey.getPaint().setColor(getResources().getColor(R.color.grey));

                // Set the border width
                grey.getPaint().setStrokeWidth(10);

                // Specify the style is a Stroke
                grey.getPaint().setStyle(Paint.Style.STROKE);

                // Finally, add the drawable background to TextView
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    btn_inch13.setBackground(grey);
                    btn_memory128.setBackground(grey);

                    if (isClicked) {

                        black = new ShapeDrawable();
                        black.setShape(new RectShape());
                        black.getPaint().setColor(getResources().getColor(R.color.black));
                        black.getPaint().setStrokeWidth(3);
                        black.getPaint().setStyle(Paint.Style.STROKE);

                        btn_inch15.setBackground(black);
                        btn_memory512.setBackground(black);
                    }
                }

                break;
            case R.id.btn_pink:
                isClicked = true;

                ShapeDrawable pink = new ShapeDrawable();

                // Specify the shape of ShapeDrawable
                pink.setShape(new RectShape());

                // Specify the border color of shape
                pink.getPaint().setColor(getResources().getColor(R.color.pink));

                // Set the border width
                pink.getPaint().setStrokeWidth(10);

                // Specify the style is a Stroke
                pink.getPaint().setStyle(Paint.Style.STROKE);

                // Finally, add the drawable background to TextView
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    btn_inch15.setBackground(pink);
                    btn_memory512.setBackground(pink);

                    if (isClicked) {

                        black = new ShapeDrawable();
                        black.setShape(new RectShape());
                        black.getPaint().setColor(getResources().getColor(R.color.black));
                        black.getPaint().setStrokeWidth(3);
                        black.getPaint().setStyle(Paint.Style.STROKE);

                        btn_inch13.setBackground(black);
                        btn_memory128.setBackground(black);
                    }
                }

                break;
            case R.id.btn_grey_light:
                isClicked = true;

                ShapeDrawable grey_light = new ShapeDrawable();

                // Specify the shape of ShapeDrawable
                grey_light.setShape(new RectShape());

                // Specify the border color of shape
                grey_light.getPaint().setColor(getResources().getColor(R.color.grey_light));

                // Set the border width
                grey_light.getPaint().setStrokeWidth(10);

                // Specify the style is a Stroke
                grey_light.getPaint().setStyle(Paint.Style.STROKE);

                // Finally, add the drawable background to TextView
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    btn_inch13.setBackground(grey_light);
                    btn_memory512.setBackground(grey_light);

                    if (isClicked) {

                        black = new ShapeDrawable();
                        black.setShape(new RectShape());
                        black.getPaint().setColor(getResources().getColor(R.color.black));
                        black.getPaint().setStrokeWidth(3);
                        black.getPaint().setStyle(Paint.Style.STROKE);

                        btn_inch15.setBackground(black);
                        btn_memory128.setBackground(black);
                    }
                }
                break;
            default:
                break;
        }

    }
    ////////////////////////////////

    @Override
    public boolean onSupportNavigateUp() {
        Toast.makeText(this, "back", Toast.LENGTH_SHORT).show();
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_present:
                Toast.makeText(this, "present", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_favorite:
                Toast.makeText(this, "favorite", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void setSlider() {
        sliderPagerAdapter = new SliderPagerAdapter();
        viewPager.setAdapter(sliderPagerAdapter);

        for (int i = 0; i < drawables.length; i++) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.slider_pager_item, null, false);
            sliderPagerAdapter.addView(frameLayout, i);
            sliderPagerAdapter.notifyDataSetChanged();
            View root = sliderPagerAdapter.getView(i);

            ImageView imageView = root.findViewById(R.id.image_slider_pager);
            Glide.with(MainActivity.this)
                    .load(drawables[i])
                    .into(imageView);
        }
    }

    //    private void setupViewPager(ViewPager viewPager) {
//        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
//        adapter.addFragment(new PageFragment(),"3  мес");
//        adapter.addFragment(new PageFragment(),"6  мес");
//        adapter.addFragment(new PageFragment(),"9  мес");
//        adapter.addFragment(new PageFragment(),"12  мес");
//        adapter.addFragment(new PageFragment(),"24  мес");
//        viewPager.setAdapter(adapter);
//    }

    /////////// Onclick /////////////
}
