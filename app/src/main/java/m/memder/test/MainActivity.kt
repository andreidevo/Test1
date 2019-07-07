package m.memder.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private var exampleList : ArrayList<VideoClass> = ArrayList<VideoClass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        exampleList.add(VideoClass("https://www.dropbox.com/s/n5lcbrymyvhnj53/file_photo_54485087_2087444998006526_7735827937999454208_n.png?dl=1"))
        exampleList.add(VideoClass("https://www.dropbox.com/s/s7ysvarted7fkze/file_52561210_1902052596584790_1932957839815344128_n.mp4?dl=1"))
        exampleList.add(VideoClass("https://www.dropbox.com/s/s7ysvarted7fkze/file_52561210_1902052596584790_1932957839815344128_n.mp4?dl=1"))
        exampleList.add(VideoClass("https://www.dropbox.com/s/s7ysvarted7fkze/file_52561210_1902052596584790_1932957839815344128_n.mp4?dl=1"))
        exampleList.add(VideoClass("https://www.dropbox.com/s/s7ysvarted7fkze/file_52561210_1902052596584790_1932957839815344128_n.mp4?dl=1"))
        exampleList.add(VideoClass("https://www.dropbox.com/s/s7ysvarted7fkze/file_52561210_1902052596584790_1932957839815344128_n.mp4?dl=1"))
        exampleList.add(VideoClass("https://www.dropbox.com/s/s7ysvarted7fkze/file_52561210_1902052596584790_1932957839815344128_n.mp4?dl=1"))


        val verticalView: VerticalView?
        val viewpagerAdapter: AdapterPages?
        verticalView = findViewById(R.id.pager)
        verticalView.offscreenPageLimit = 1
        viewpagerAdapter = AdapterPages(supportFragmentManager, exampleList)
        verticalView.adapter = viewpagerAdapter
        verticalView.setCurrentItem(0, false)

    }
}
