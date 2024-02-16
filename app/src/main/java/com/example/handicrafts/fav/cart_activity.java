package com.example.handicrafts.fav;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.airbnb.lottie.LottieAnimationView;
import com.example.handicrafts.R;
import com.facebook.shimmer.ShimmerFrameLayout;

public class cart_activity extends Fragment {
    LottieAnimationView imageView;
    Animation animation;
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_cart,null);
        imageView=view.findViewById(R.id.animation);
        textView=view.findViewById(R.id.text);
        textView.setText("No Items Selected");
        animation=AnimationUtils.loadAnimation(getActivity(),R.anim.anim1);
        textView.startAnimation(animation);

        imageView.setAnimation(R.raw.lottie);
        imageView.playAnimation();
        return view;
    }
}
