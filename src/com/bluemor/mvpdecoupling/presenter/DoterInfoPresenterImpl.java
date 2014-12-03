package com.bluemor.mvpdecoupling.presenter;

import com.bluemor.mvpdecoupling.bean.Doter;
import com.bluemor.mvpdecoupling.interactor.DoterInfoInteractor;
import com.bluemor.mvpdecoupling.interactor.DoterInfoInteractorImpl;

public class DoterInfoPresenterImpl implements DoterInfoPresenter, DoterInfoCallback {

    private DoterInfoView view;

    private DoterInfoInteractor interactor;

    public DoterInfoPresenterImpl(DoterInfoView view) {
        this.view = view;
        interactor = new DoterInfoInteractorImpl(this);
    }

    @Override
    public void loadData() {
        view.showLoading();
        interactor.getDoter();
    }

    @Override
    public void onResponse(Doter info) {
        view.showContent();
        view.showDoterInfo(info);
    }

    @Override
    public void onError() {
        view.showError();
    }

    @Override
    public void onNonet() {
        view.showNonet();
    }

    @Override
    public void onEmpty() {
        view.showEmpty();
    }

}
