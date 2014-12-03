package com.bluemor.mvpdecoupling.interactor;

import com.bluemor.mvpdecoupling.bean.Doter;
import com.bluemor.mvpdecoupling.presenter.DoterInfoCallback;

import java.util.Random;

public class DoterInfoInteractorImpl implements DoterInfoInteractor {

    private DoterInfoCallback callback;

    public DoterInfoInteractorImpl(DoterInfoCallback callback) {
        this.callback = callback;
    }

    @Override
    public void getDoter() {
        try {
            Thread.sleep(1111);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int nextInt = new Random().nextInt(4);

        switch (nextInt) {
            case 0:
                callback.onResponse(new Doter("BlueMor", "5 years"));
                break;
            case 1:
                callback.onEmpty();
                break;
            case 2:
                callback.onError();
                break;
            case 3:
                callback.onNonet();
                break;
        }
    }

}
