package org.bu.android.widget;

import org.bu.android.R;
import org.bu.android.misc.BuGenerallyHolder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class BuMenuItemPop extends LinearLayout {

	private LinearLayout ll_pops;
	private LayoutInflater layoutInflater;

	public BuMenuItemPop(Context context) {
		super(context);
		layoutInflater = LayoutInflater.from(context);
		layoutInflater.inflate(R.layout.bu_menu_item_pop, this);
		ll_pops = (LinearLayout) findViewById(R.id.ll_pop);
	}

	public void addViews(Button... btns) {
		for (Button child : btns) {
			ll_pops.addView(child);
		}
	}

	public void setOnClickListener(View.OnClickListener listener) {
		for (int index = 0; index < ll_pops.getChildCount(); index++) {
			ll_pops.getChildAt(index).setOnClickListener(listener);
		}
	}

	public Button builderItem() {
		Button button = (Button) layoutInflater.inflate(R.layout.bu_menu_item_btn, null);
		button.setTag(BuGenerallyHolder.nextSerialNumber());
		return button;
	}

	public Button builderItem(int resId) {
		return builderItem(getContext().getString(resId));
	}

	public Button builderItem(String text) {
		Button btn = builderItem();
		btn.setText(text);
		addViews(btn);
		return btn;
	}

}
