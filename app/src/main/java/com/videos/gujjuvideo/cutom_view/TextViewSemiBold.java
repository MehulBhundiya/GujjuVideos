package com.videos.gujjuvideo.cutom_view;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.util.AttributeSet;
import android.widget.TextView;

import com.videos.gujjuvideo.R;

public class TextViewSemiBold extends TextView {
    public TextViewSemiBold(Context context) {
        super(context);
        init();
    }

    public TextViewSemiBold(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TextViewSemiBold(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setTypeface(ResourcesCompat.getFont(getContext(), R.font.muktavani_semi_bold));
        setSelected(true);
    }
}
