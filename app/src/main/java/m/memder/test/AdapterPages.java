package m.memder.test;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import java.util.List;


public class AdapterPages extends FragmentStatePagerAdapter {
    private List<VideoClass> videoclass;
    static int count = 0;
    static int pos = -100;
    public AdapterPages(FragmentManager fm, List<VideoClass> videos)
    {
        super(fm);
        this.videoclass = videos;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {


        if (position > pos)
            count++;
        else
            if (count > 0)
                count--;

        pos = position;
        String href = videoclass.get(count).getHref();
        return Fragmento.newInstance(href);

    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    @Override
    public int getCount() {
        return 9999999;
    }

    @Override
    public void setPrimaryItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        super.setPrimaryItem(container, position, object);
    }

    @Override
    public void finishUpdate(@NonNull ViewGroup container) {
        super.finishUpdate(container);
    }

}
