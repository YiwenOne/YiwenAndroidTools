package com.example.yyiwen.fastmaildemo.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yyiwen.fastmaildemo.R;

import java.util.List;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;

public class RxjavaHelloActivity extends AppCompatActivity {
    TextView tv_1;
    String urls[]={"url1","url2","url3"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_hello);
        tv_1= (TextView) findViewById(R.id.tv_1);
//        Observable<String> myObservable= Observable.create(new Observable.OnSubscribe<String>(){
//            @Override
//            public void call(Subscriber<? super String> subscriber) {
//                subscriber.onNext("HelloWorld");
//                subscriber.onCompleted();
//            }
//        });
//        Observable<String> myObservable=Observable.just("hello,world");
//        Action1<String> onNextAction=new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Toast.makeText(RxjavaHelloActivity.this,s,Toast.LENGTH_LONG).show();
//            }
//        };
//        myObservable.subscribe(onNextAction);

//        Observable.just("Hello,World").subscribe(new Action1<String>() {
//            @Override
//            public void call(String s) {
//                Toast.makeText(RxjavaHelloActivity.this,s,Toast.LENGTH_LONG).show();
//                tv_1.setText(s);
//            }
//        });
//        Subscriber<String> mySubscriber = new Subscriber<String>() {
//            @Override
//            public void onNext(String s) { System.out.println(s); }
//
//            @Override
//            public void onCompleted() { }
//
//            @Override
//            public void onError(Throwable e) { }
//        };
//        myObservable.subscribe(mySubscriber);
//        query("Hello, world!").subscribe()
    }

    Observable<List<String>> query(String text) {
        return null;
    }
}
