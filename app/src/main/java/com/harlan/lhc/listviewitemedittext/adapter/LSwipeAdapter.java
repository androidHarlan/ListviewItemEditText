package com.harlan.lhc.listviewitemedittext.adapter;

import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import com.harlan.lhc.listviewitemedittext.R;
import com.harlan.lhc.listviewitemedittext.bean.Student;

import java.util.List;


public class LSwipeAdapter extends BaseAdapter {
    List<Student> data;
    /**
     * 上下文对象
     */
    private Activity mContext = null;





    /**
     * @param
     */
    public LSwipeAdapter(Activity ctx, List<Student> mdata) {
        mContext = ctx;
        data=mdata;
    }


    public List<Student> getData() {
        return data;
    }


    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ViewHolder holder;

    @Override
    public View getView(final int mposition, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.edit_item, parent, false);
            holder = new ViewHolder();

            holder.valuse = (EditText) convertView.findViewById(R.id.name);
            convertView.setTag(holder);
        } else {// 有直接获得ViewHolder
            holder = (ViewHolder) convertView.getTag();
        }
        holder.valuse.setTag(mposition);//设置editext一个标记
        holder.valuse.clearFocus();//清除焦点  不清除的话因为item复用的原因   多个Editext同时改变

        final EditText tempEditText = holder.valuse;
        holder.valuse.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s != null && !"".equals(s.toString())) {
                    int position = (Integer) tempEditText.getTag();
                    data.get(position).setValuse(s.toString());
                }

            }
        });

        holder.valuse.setText(data.get(mposition).getValuse());
        return convertView;
    }


    private class ViewHolder {
        EditText valuse;


    }
}