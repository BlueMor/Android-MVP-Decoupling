package com.bluemor.mvpdecoupling.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.bluemor.mvpdecoupling.R;
import com.bluemor.mvpdecoupling.bean.Doter;
import com.bluemor.mvpdecoupling.commen.ViewContainer;
import com.bluemor.mvpdecoupling.presenter.DoterInfoPresenter;
import com.bluemor.mvpdecoupling.presenter.DoterInfoPresenterImpl;
import com.bluemor.mvpdecoupling.presenter.DoterInfoView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity
public class MainActivity extends Activity implements DoterInfoView {

    private ViewContainer vc;

    private DoterInfoPresenter presenter;

    @ViewById(R.id.tv_info)
    TextView tv_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViewContainer();
    }

    private void initViewContainer() {
        vc = new ViewContainer(this, R.layout.activity_main);
        vc.setDefaultClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                clickButton();
            }
        });
        vc.build(this);
    }

    @AfterViews
    void initPresenter() {
        presenter = new DoterInfoPresenterImpl(this);
    }

    @Background
    @Click(R.id.bt)
    void clickButton() {
        presenter.loadData();
    }

    @UiThread
    @Override
    public void showLoading() {
        vc.showLoading();
    }

    @UiThread
    @Override
    public void showContent() {
        vc.showContent();
    }

    @UiThread
    @Override
    public void showError() {
        vc.showError();
    }

    @UiThread
    @Override
    public void showNonet() {
        vc.showNonet();
    }

    @UiThread
    @Override
    public void showEmpty() {
        vc.showEmpty();
    }

    @UiThread
    @Override
    public void showDoterInfo(Doter info) {
        tv_info.setText(info.toString());
    }
}
