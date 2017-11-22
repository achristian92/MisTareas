package apps.construyendo.mistareas.Presenter.presentacion.Presenter;

import apps.construyendo.mistareas.Presenter.presentacion.View.BaseView;

/**
 * Created by Christian 24 on 17/11/2017.
 */

public class BasePresenter <V extends BaseView> {
    protected V view;

    public BasePresenter(V view) {
        this.view = view;
    }
}
