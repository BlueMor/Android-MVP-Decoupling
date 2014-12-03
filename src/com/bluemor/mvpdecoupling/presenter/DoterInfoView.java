package com.bluemor.mvpdecoupling.presenter;

import com.bluemor.mvpdecoupling.bean.Doter;
import com.bluemor.mvpdecoupling.commen.LoadDataView;

public interface DoterInfoView extends LoadDataView {
    public void showDoterInfo(Doter info);
}
