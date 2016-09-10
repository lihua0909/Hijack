package com.group.adapters;

import com.group.hijack.R;
import com.group.utils.MyListData;
import com.group.utils.MyListData.Type;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ExpendListViewAdapter extends ArrayAdapter<String> {
	private MyListData mdatas;
	private LayoutInflater minflater;

	public ExpendListViewAdapter(Context context, MyListData objects) {
		super(context, -1);
		mdatas = objects;
		minflater = LayoutInflater.from(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHoder holder = null;
		String info = mdatas.getDatas().get(position);
		if (convertView == null) {
			convertView = minflater.inflate(R.layout.treeview_item, parent,
					false);
			
			holder = new ViewHoder();
			holder.image = (ImageView) convertView
					.findViewById(R.id.textview_item_icon);
			holder.text = (TextView) convertView
					.findViewById(R.id.textview_item_text);
			convertView.setTag(holder);
		} else {
			holder = (ViewHoder) convertView.getTag();
		}

		initalItemView(holder, info);
		holder.text.setText(info);

		return convertView;
	}

	/**
	 * ��ʼ��Item�Ŀؼ�����ʾ״̬��
	 * 
	 * @param holder
	 * @param info
	 */
	private void initalItemView(ViewHoder holder, String info) {
		int index = mdatas.inParentindexOf(info);
		// �ظ��ϴε����á�
		holder.text.setPadding(0, 0, 0, 0);
		holder.image.setVisibility(View.VISIBLE);
		// �ٸ���������������ڵĲ��������
		if (index != -1) {
			// �Ǹ������е�һ���ڵ㡣
			if (mdatas.haveChild(index)) {
				// �к��ӽڵ�
				if (Type.OPEN == mdatas.getItemType(index)) {
					// ����չ��״̬��
					holder.image.setImageResource(R.drawable.tree_ex);
				} else {
					// �ر�״̬��
					holder.image.setImageResource(R.drawable.tree_ec);
				}
			} else {
				// û�к��ӽڵ㡣
				holder.image.setVisibility(View.INVISIBLE);
			}
		} else {
			// ���Ǹ������еĽڵ㣬˵���Ǻ��ӽڵ㡣
			holder.image.setVisibility(View.INVISIBLE);
			holder.text.setPadding(30, 0, 0, 0);
		}
	}

	@Override
	public void notifyDataSetChanged() {
		super.notifyDataSetChanged();
	}

	public class ViewHoder {
		ImageView image;
		TextView text;
	}

	@Override
	public int getCount() {
		return mdatas.size();
	}

}
