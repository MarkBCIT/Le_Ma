package ca.bcit.ass1.le_ma;

import android.content.Context;
import android.support.v4.view.ActionProvider;
import android.view.SubMenu;
import android.view.View;

public class CustomActionProvider extends ActionProvider {

    private Context mContext;

    public CustomActionProvider(Context context) {
        super(context);

        mContext = context;
    }

    @Override
    public View onCreateActionView() {
        //LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        return null;
    }

    @Override
    public void onPrepareSubMenu(SubMenu subMenu) {
        super.onPrepareSubMenu(subMenu);

        subMenu.clear();

        subMenu.add("menu 1");
        subMenu.add("menu 2");
        subMenu.add("menu 3");
    }

    @Override
    public boolean hasSubMenu() {
        return true;
    }

    @Override
    public boolean onPerformDefaultAction() {
        return super.onPerformDefaultAction();
    }
}
