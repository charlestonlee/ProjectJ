package com.example.charleston.projectj;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charleston.projectj.R;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainPostFragment extends Fragment {


    public MainPostFragment() {



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final String url="http://api.tumblr.com/v2/blog/yuholong.tumblr.com/avatar/64\\";
  View view = inflater.inflate(R.layout.fragment_main_post, container, false);

        ImageView imageView=(ImageView) view.findViewById(R.id.imageview1);
        final TextView textView=(TextView) view.findViewById(R.id.textview1);

        Ion.with(imageView).resize(450,450).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).load(url);
        Context context = getContext();
        Ion.with(context).load("http://yuholong.elasticbeanstalk.com/external/profile_images?facebook=facebook&twitter=twitter&tumblr=tumblr").asJsonObject().setCallback(new FutureCallback<JsonObject>() {
            @Override
            public void onCompleted(Exception e, JsonObject result) {
            textView.setText(result.toString());
                result = result.


            }
        });



    return view;
    }



}
