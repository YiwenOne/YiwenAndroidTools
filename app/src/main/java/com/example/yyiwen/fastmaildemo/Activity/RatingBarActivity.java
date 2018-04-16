package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.yyiwen.fastmaildemo.R;

public class RatingBarActivity extends BaseActivity implements RatingBar.OnRatingBarChangeListener {

    private RatingBar smallRatingBar;
    private RatingBar indicatorRatingBar;
    private TextView textView;
    RatingBar ratingBar1,ratingBar2;
    @Override
    protected void initView() {
        setContentView(R.layout.activity_rating_bar);
        ratingBar1 = (RatingBar) findViewById(R.id.ratingbar1);
        ratingBar2 = (RatingBar) findViewById(R.id.ratingbar2);
        textView = (TextView) findViewById(R.id.textview);
        smallRatingBar = (RatingBar) findViewById(R.id.smallRatingbar);
        indicatorRatingBar = (RatingBar) findViewById(R.id.indicatorRatingbar);
    }

    @Override
    protected void initData() {
        //获取步长

    }

    @Override
    protected void initListener() {
        ratingBar1.setOnRatingBarChangeListener(this);
        ratingBar2.setOnRatingBarChangeListener(this);
    }

    @Override
    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
        smallRatingBar.setRating(rating);
        indicatorRatingBar.setRating(rating);
        if (ratingBar.getId() == R.id.ratingbar1)
            textView.setText("ratingbar1 的分数：" + rating);
        else
            textView.setText("ratingbar2 的分数：" + rating);

        if( ratingBar1.getRating()==4.0){
            textView.setText("ratingbar2 的分数：" + rating+"123");
        }
    }
}
