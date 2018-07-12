package com.videos.gujjuvideo.cutom_view;

import android.content.Context;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.videos.gujjuvideo.R;

public class TextViewBold extends AppCompatTextView {
    public TextViewBold(Context context) {
        super(context);
        init();
    }

    public TextViewBold(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public TextViewBold(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        setTypeface(ResourcesCompat.getFont(getContext(), R.font.muktavani_bold));
        setSelected(true);
    }
}
