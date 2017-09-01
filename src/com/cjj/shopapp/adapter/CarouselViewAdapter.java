package com.cjj.shopapp.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cjj.shopapp.activity.R;
import com.cjj.shopapp.models.CategoryInfo;

public class CarouselViewAdapter extends BaseAdapter{

	private Context mContext;
	private List<CategoryInfo> mList;
	
	public CarouselViewAdapter(Context mContext,List<CategoryInfo> mList){
		this.mContext = mContext;
		this.mList = mList;
	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public CategoryInfo getItem(int position) {
		return mList == null ? null : mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder mHolder;
		CategoryInfo categoryInfo = getItem(position);
		if(convertView == null){
			convertView = LayoutInflater.from(mContext).inflate(R.layout.item_carousel_view, null);
			mHolder = new ViewHolder();
			mHolder.icon = (ImageView) convertView.findViewById(R.id.itemsIcon);
			mHolder.msg = (TextView) convertView.findViewById(R.id.itemsText);
			convertView.setTag(mHolder);
		}else{
			mHolder = (ViewHolder) convertView.getTag();
		}
		
		mHolder.icon.setImageResource(categoryInfo.getIcon());
		mHolder.msg.setText(categoryInfo.getMsg());
		
		return convertView;
	}
	
	private class ViewHolder{
		private ImageView icon;
		private TextView msg;
	}

	

}
