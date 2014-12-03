package com.bluemor.mvpdecoupling.commen;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.bluemor.mvpdecoupling.R;
import com.bluemor.mvpdecoupling.R.layout;

import java.util.Collection;
import java.util.HashMap;

public class ViewContainer {
    private final String KEY_CONTENT = "content";
    private final String KEY_NONET = "nonet";
    private final String KEY_ERROR = "error";
    private final String KEY_EMPTY = "empty";
    private final String KEY_LOADING = "loading";

    private Context context;
    private ViewGroup rootView;
    private String keyOfShownView;
    private OnClickListener onClickListener;
    private HashMap<String, View> viewMap = new HashMap<String, View>();

    public ViewContainer(Context mContext, int layout) {
        this.context = mContext;
        rootView = new FrameLayout(mContext);

        View contentView = View.inflate(context, layout, null);
        keyOfShownView = KEY_CONTENT;
        viewMap.put(KEY_CONTENT, contentView);

        setNonetView(R.layout.container_nonet);
        setErrorView(R.layout.container_error);
        setEmptyView(R.layout.container_empty);
        setLoadingView(R.layout.container_loading);
    }

    public ViewContainer setNonetView(int layout) {
        View view = View.inflate(context, layout, null);
        viewMap.put(KEY_NONET, view);
        return this;
    }

    public ViewContainer setErrorView(int layout) {
        View view = View.inflate(context, layout, null);
        viewMap.put(KEY_ERROR, view);
        return this;
    }

    public ViewContainer setEmptyView(int layout) {
        View view = View.inflate(context, layout, null);
        viewMap.put(KEY_EMPTY, view);
        return this;
    }

    public ViewContainer setLoadingView(int layout) {
        View view = View.inflate(context, layout, null);
        viewMap.put(KEY_LOADING, view);
        return this;
    }

    public ViewContainer setDefaultClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
        return this;
    }

    public ViewContainer addView(String key, View view) {
        viewMap.put(key, view);
        return this;
    }

    public View build(Object o) {
        Collection<View> views = viewMap.values();
        for (View view : views) {
            view.setVisibility(View.GONE);
            rootView.addView(view);
        }
        viewMap.get(keyOfShownView).setVisibility(View.VISIBLE);
        if (o instanceof Activity) {
            ((Activity) o).setContentView(rootView);
        }
        if (onClickListener != null) {
            viewMap.get(KEY_NONET).setOnClickListener(onClickListener);
            viewMap.get(KEY_ERROR).setOnClickListener(onClickListener);
            viewMap.get(KEY_EMPTY).setOnClickListener(onClickListener);
        }
        return rootView;
    }

    public void showContent() {
        show(KEY_CONTENT);
    }

    public void showNonet() {
        show(KEY_NONET);
    }

    public void showError() {
        show(KEY_ERROR);
    }

    public void showEmpty() {
        show(KEY_EMPTY);
    }

    public void showLoading() {
        show(KEY_LOADING);
    }

    public void showView(String key) {
        show(key);
    }

    private void show(String key) {
        View v_shown = viewMap.get(keyOfShownView);
        View view = viewMap.get(key);
        v_shown.setVisibility(View.GONE);
        view.setVisibility(View.VISIBLE);
        keyOfShownView = key;
    }

    // save this if you need to SaveInstanceState
    public String getKeyOfShownView() {
        return keyOfShownView;
    }

}
