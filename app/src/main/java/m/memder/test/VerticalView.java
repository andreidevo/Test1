package m.memder.test;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class VerticalView extends ViewPager {
    public VerticalView(@NonNull Context context)
    {
        super(context);
    }
    public VerticalView(@NonNull Context context, @NonNull AttributeSet attrs)
    {
        super(context,attrs);
        init();
    }

    private void init(){
        setPageTransformer(true, new Verticalpage());
        setOverScrollMode(OVER_SCROLL_NEVER);
    }
    private MotionEvent XY(MotionEvent ev)
    {
        float width = getWidth();
        float height = getHeight();
        float newx = (ev.getY() / height) * width;
        float newy = (ev.getX() / width) * height;
        ev.setLocation(newx, newy);
        return ev;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        boolean inter = super.onInterceptTouchEvent(XY(ev));
        XY(ev);
        return inter;
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return super.onTouchEvent(XY(ev));
    }
    private class Verticalpage implements ViewPager.PageTransformer{

        @Override
        public void transformPage(@NonNull View page, float position) {
            if(position<-1)
            {
                page.setAlpha(0);
            }
            else if ( position <= 1)
            {
                page.setAlpha(1);
                page.setTranslationX(page.getWidth() * - position);
                float Vpos = position * page.getHeight();
                page.setTranslationY(Vpos);
            }
            else
                page.setAlpha(0);
        }
    }
}
