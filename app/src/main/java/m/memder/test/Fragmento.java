package m.memder.test;

import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;


public class Fragmento extends Fragment {

    private static final String MY_NUM_KEY = "href";

    private SimpleExoPlayer player;
    private View v1;
    private com.google.android.exoplayer2.ui.PlayerView Video;
    private String mNum;

    static Fragmento newInstance(String href) {
        Fragmento f = new Fragmento();
        Bundle args = new Bundle();
        args.putString(MY_NUM_KEY, href);
        f.setArguments(args);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mNum = getArguments().getString(MY_NUM_KEY);
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.page_1, container, false);

        Video = v.findViewById(R.id.video);

        player = ExoPlayerFactory.newSimpleInstance(getContext());
        Video.setPlayer(player);
        player.setRepeatMode(Player.REPEAT_MODE_ALL);

        player.seekTo(0, 100000);
        DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(getContext(), Util.getUserAgent(getContext(), "animation"));
        MediaSource videoSource = new ProgressiveMediaSource.Factory(dataSourceFactory).createMediaSource(Uri.parse(mNum));
        player.prepare(videoSource, true, true);
        player.setPlayWhenReady(true);
        player.getAnalyticsCollector();

        return v;
    }
}