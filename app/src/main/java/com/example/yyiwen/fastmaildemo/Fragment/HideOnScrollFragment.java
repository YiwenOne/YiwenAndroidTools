package com.example.yyiwen.fastmaildemo.Fragment;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yyiwen.fastmaildemo.Adapter.RecyclerAdapter;
import com.example.yyiwen.fastmaildemo.R;
import com.example.yyiwen.fastmaildemo.Utils.UIUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class HideOnScrollFragment extends Fragment {
    public final static String ITEMS_COUNT_KEY="PartThreeFragment";
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    public static HideOnScrollFragment createInstance(int itemsCount){
        HideOnScrollFragment hideOnScrollFragment=new HideOnScrollFragment();
        Bundle bundle=new Bundle();
        bundle.putInt(ITEMS_COUNT_KEY,itemsCount);
        hideOnScrollFragment.setArguments(bundle);
        return hideOnScrollFragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        recyclerView= (RecyclerView) inflater.inflate(R.layout.fragment_hide_on_scroll,container,false);
        setUpRecyclerView(recyclerView);

        return recyclerView;
    }

    //设置界面
    private void setUpRecyclerView(RecyclerView recyclerView){
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        recyclerAdapter= new RecyclerAdapter(createItemList());

        recyclerAdapter.setOnItemClickListener(new RecyclerAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data) {
                UIUtils.showToastSafe("点击了"+data);
            }
        });
        recyclerView.setAdapter(recyclerAdapter);

    }
    //创建数据集合
    private List<String> createItemList(){
        List<String> itemList=new ArrayList<>();
        Bundle bundle=getArguments();
        if(bundle!=null){
            int itemsCount=bundle.getInt(ITEMS_COUNT_KEY);
            for(int i=0;i<itemList.size();i++){
                itemList.add("item" +i);
            }
        }
        return itemList;
    }
}
