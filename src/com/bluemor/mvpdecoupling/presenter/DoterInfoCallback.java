package com.bluemor.mvpdecoupling.presenter;

import com.bluemor.mvpdecoupling.bean.Doter;
import com.bluemor.mvpdecoupling.commen.LoadDataCallback;

public interface DoterInfoCallback extends LoadDataCallback {
    public void onResponse(Doter info);
}
