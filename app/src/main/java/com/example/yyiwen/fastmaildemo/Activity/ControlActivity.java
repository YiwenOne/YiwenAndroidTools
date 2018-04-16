package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.UIUtils;
import com.example.yyiwen.fastmaildemo.View.RoundMenuView;

public class ControlActivity extends AppCompatActivity {
    RoundMenuView.RoundMenu roundMenu;
    RoundMenuView roundMenuView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control);

        roundMenu = new RoundMenuView.RoundMenu();

//        init();

    }

//    private void init() {
//        RoundMenuView.RoundMenu roundMenu = new RoundMenuView.RoundMenu();
//        roundMenu.selectSolidColor = ColorUtils.getColor(getActivity(), R.color.gray_9999);
//        roundMenu.strokeColor = ColorUtils.getColor(getActivity(), R.color.gray_9999);
//        roundMenu.icon=ImageUtils.drawable2Bitmap(getActivity(),R.drawable.ic_right);
//        roundMenu.onClickListener=new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                UIUtils.showToastSafe("点击了1");
//            }
//        };
//        roundMenuView.addRoundMenu(roundMenu);
//
//        roundMenu = new RoundMenuView.RoundMenu();
//        roundMenu.selectSolidColor = ColorUtils.getColor(UIUtils.getContext(), R.color.gray_lite);
//        roundMenu.strokeColor = ColorUtils.getColor(UIUtils.getContext(), R.color.gray_lite);
//        roundMenu.icon=ImageUtils.drawable2Bitmap(UIUtils.getContext(),R.drawable.ic_right);
//        roundMenu.onClickListener=new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                UIUtils.showToastSafe("点击了2");
//            }
//        };
//        roundMenuView.addRoundMenu(roundMenu);
//
//        roundMenu = new RoundMenuView.RoundMenu();
//        roundMenu.selectSolidColor = ColorUtils.getColor(UIUtils.getContext(), R.color.gray_lite);
//        roundMenu.strokeColor = ColorUtils.getColor(UIUtils.getContext(), R.color.gray_lite);
//        roundMenu.icon=ImageUtils.drawable2Bitmap(UIUtils.getContext(),R.drawable.ic_right);
//        roundMenu.onClickListener=new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                UIUtils.showToastSafe("点击了3");
//            }
//        };
//        roundMenuView.addRoundMenu(roundMenu);
//
//        roundMenu = new RoundMenuView.RoundMenu();
//        roundMenu.selectSolidColor = ColorUtils.getColor(UIUtils.getContext(), R.color.gray_lite);
//        roundMenu.strokeColor = ColorUtils.getColor(UIUtils.getContext(), R.color.gray_lite);
//        roundMenu.icon=ImageUtils.drawable2Bitmap(UIUtils.getContext(),R.drawable.ic_right);
//        roundMenu.onClickListener=new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                UIUtils.showToastSafe("点击了4");
//            }
//        };
//        roundMenuView.addRoundMenu(roundMenu);
//
//        roundMenuView.setCoreMenu(ColorUtils.getColor(UIUtils.getContext(), R.color.gray_f2f2),
//                ColorUtils.getColor(UIUtils.getContext(), R.color.gray_lite), ColorUtils.getColor(UIUtils.getContext(), R.color.gray_lite)
//                , 1, 0.43,ImageUtils.drawable2Bitmap(UIUtils.getContext(),R.drawable.ic_ok), new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        UIUtils.showToastSafe("点击了中心圆圈");
//                    }
//                });
//    }
}
