package com.gustiarysaputra.dailyprayer.prayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gustiarysaputra.dailyprayer.R

class PrayerActivity : AppCompatActivity() {

    private lateinit var prayRecyclerView: RecyclerView
    private lateinit var prayArrayList: ArrayList<PrayerData>
    lateinit var title: Array<String>
    lateinit var desc: Array<String>
    lateinit var image: Array<Int>
    lateinit var raw: Array<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prayer)

        prayRecyclerView = findViewById(R.id.recycler_view_prayer)
        prayRecyclerView.layoutManager = LinearLayoutManager(this)
        prayRecyclerView.setHasFixedSize(true)

        prayArrayList = arrayListOf<PrayerData>()

        image = arrayOf(
            R.drawable.sawah1,
            R.drawable.sawah2,
            R.drawable.sawah3,
            R.drawable.sawah1,
            R.drawable.sawah2,
            R.drawable.sawah3,
            R.drawable.sawah1,
            R.drawable.sawah2,
            R.drawable.sawah3,
            R.drawable.sawah1,
        )

        title = arrayOf(
            "Doa Bangun pagi",
            "Doa Menolak bahaya",
            "Doa Mandi",
            "Doa menjelang tidur",
            "Doa Ampunan segala dosa",
            "Doa Mohon bimbingan Tuhan",
            "Doa Mohon cinta kasih-Nya",
            "Doa Mohon inspirasi",
            "Doa untuk memohon ketenangan rumah tangga",
            "Doa Mohon umur panjang",
        )

        desc = arrayOf(
            "Oḿ Utedānīm bhagavantaḥ syāmota prapitva utamadhye ahnam, utoditā maghavanta sūryasya vayaḿ devānām sumatau syāma.\n" +
                    "\n" +
                    "Artinya : \n" +
                    "Ya Tuhan, hamba memuja-Mu, vahwa hamba telah bangun pagi dalam keadaan selamat.\n",
            "Om Om Asta Maha Bayaya\n" +
                    "Om Sarwa Dewa, Sarwa Sanjata, Sarwa Warna Ya Namah,\n" +
                    "Om Atma Raksaya, Sarwa Satru, Winasaya Namah Swaha\n" +
                    "\n" +
                    "Artinya : \n" +
                    "Oh Sanghyang Widhi Wasa Penakluk Segala Macam Bahaya Dari Segala Penjuru, Hamba Memujamu Dalam Wujud Sinar Suci Dengan Beraneka Warna Dan Senjata Yang Ampuh. Oh Sanghyang Widhi Wasa Lindungilah Jiwa Kami. Semoga Semua Musuh Binasa\n",
            "Om Cam Camani Ya Namah Swaha\n" +
                    "Om Waktra Parisudaha Ya Namah Swaha\n" +
                    "\n" +
                    "Artinya : \n" +
                    "Ya Tuhan, Hamba Memujamu, Semoga Muka Hamba Menjadi Bersih\n",
            "Om asato ma sat ganaya\n" +
                    "Tamaso ma jayatir ganaya\n" +
                    "Mrityor mamritam gamaya\n" +
                    "\n" +
                    "Artinya : \n" +
                    "Ya tuhan tuntunlah hamba dari jalan yang sesat menuju jalan yang benar\n" +
                    "Dari jalan gelap ke jalan terang\n" +
                    "Hindarkanlah hamba dari kematian menuju kehidupan abadi\n",
            "Om dewakrtasyainaso awaya janam\n" +
                    "asi manusyakrtasi nama awaya janam\n" +
                    "asipitra kitasi namo awaya janam asyatma\n" +
                    "krtasyaenaso awaya janam\n" +
                    "asyena sa' enase waya janam asi\n" +
                    "yacchaham eno vidvamscakara\n" +
                    "yacchavidvams tasya va ya janam asi\n" +
                    "\n" +
                    "Artinya : \n" +
                    "Om Sang Hyang Widhy Wasa, ampunilah dosa hamba terhadap-Mu. Ampunilah dosa hamba terhadap sesama manusia, terhadap orangtua hamba, terhadap teman hamba. Sang Hyang Widhy Wasa ampunilah dosa hamba terhadap segala macam dosa, terhadap dosa yang hamba lakukan dengan sadar atau tidak sadar. Sang Hyang Widhy Wasa semoga berkenan mengampuni semuanya itu.\n",
            "Oṁ Asato mā sadyamaya\n" +
                    "tamaso mā jyotir gamayamrtyor mā\n" +
                    "amrtam gamaya,\n" +
                    "Oṁ agne brahma grbhniswa\n" +
                    "dharunama syanta riksam drdvamha\n" +
                    "brahrnawanitwa ksatrawahi sajāta\n" +
                    "wanyu dadhami bhratrwyasya wadhyāya.\n" +
                    "\n" +
                    "Artinya : \n" +
                    "Oṁ Sang Hyang Widhy Wasa Yang Maha Suci, bimbinglah hamba dari yang tidak benar menuju yang benar. Bimbinglah hamba dari kegelapan pikiran menuju cahaya pengetahuan yang terang. Lepaskanlah hamba dari kematian menuju kehidupan yang abadi. Sang Hyang Widhy Wasa Yang Maha Suci, terimalah pujian yang hamba persembahkan melalui Weda mantra dan kembangkanlah pengetahuan rohani hamba agar hamba dapat menghancurkan musuh yang ada pada hamba (nafsu). Hamba menyadari bahwa Engkaulah yang berada dalam setiap insani (jiwatman), menolong orang terpelajar pemimpin negara dan para pejabat. Hamba memuja Engkau semoga melimpahkan anugrah kekuatan kepada hamba.\n",
            "Oṁ wicakrame prthiwim esa etām\n" +
                    "\n" +
                    "ksetrāya wisnur manuse dasasyan\n" +
                    "\n" +
                    "druwāso asya kirqya janāsa\n" +
                    "\n" +
                    "uruksitim sujanimā cakāra\n" +
                    "\n" +
                    "Artinya :\n" +
                    "Oṁ Sang Hyang Widhy Wasa, Engkau Hyang Wisnu yang membentang di bumi ini, menjadikah tempat tinggal bagi manusia. Kaum yang hina aman sentosa di bawah lindungan-Nya. Yang mulia telah menjadikan bumi tempat yang lega bagi mereka.\n",
            "Oṁ prano Dewi Saraswati\n" +
                    "\n" +
                    "wājebhir wājiniwati\n" +
                    "\n" +
                    "dhinam awiñyawantu.\n" +
                    "\n" +
                    "Artinya :\n" +
                    "Oṁ Sang Hyang Widhy Wasa dalam manifestasi Dewi Saraswati, Hyang Maha Agung dan Maha Kuasa, semoga Engkau memancarkan kekuatan rohani, kecerdasan pikiran, dan lindungilah hamba selama-lamanya.\n",
            "Om visovisovo atithim\n" +
                    "\n" +
                    "Vajayantah purupriyam\n" +
                    "\n" +
                    "Agnim vo duryam vacah\n" +
                    "\n" +
                    "Stuse sasasya manmabhih\n" +
                    "\n" +
                    "Artinya :\n" +
                    "Ya Tuhan, engkau adalah tamu yang datang pada setiap rumah. Engkau amat mencintai umatmu. Engkau adalah sahabat yang maha pemurah. Perkenankanlah hamba memuja-Mu dengan penuh kekuatan, dalam ucapan maupun tenaga dan dalam lagu pujian.\n",
            "Oṁ Taccaksur dewahitam sukram uccarat\n" +
                    "\n" +
                    "pasyema saradah satam\n" +
                    "\n" +
                    "jiwema saradah satam\n" +
                    "\n" +
                    "Artinya :\n" +
                    "Oṁ Sang Hyang Widhy Wasa Yang Maha Kuasa, semoga seratus tahun hamba selalu melihat mata yang bersinar ciptaanNya, semoga hamba hidup seratus tahun lamanya.\n",
        )

        raw = arrayOf(
            R.raw.bangun_pagi,
            R.raw.doa_terhindar_dari_segala_macam_bahaya,
            R.raw.mandi,
            R.raw.menjelang_tidur,
            R.raw.mohon_ampun_dlm_segala_dosa,
            R.raw.mohon_bimbingan_tuhan,
            R.raw.mohon_cinta_kasih_nya,
            R.raw.mohon_inspirasi,
            R.raw.mohon_ktnngn_rmh_tangga,
            R.raw.mohon_umur_panjang,
        )
        getPrayerData()
    }

    private fun getPrayerData() {
        for (i in image.indices){
            val pray = PrayerData(title[i], desc[i], image[i], raw[i])
            prayArrayList.add(pray)
        }

        val adapter = PrayerAdapter(prayArrayList)
        prayRecyclerView.adapter = adapter
        adapter.setOnItemClickListener(object : PrayerAdapter.onItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@PrayerActivity, DetailPrayerActivity::class.java).apply {
                    putExtra("title", prayArrayList[position].title)
                    putExtra("image", prayArrayList[position].image)
                    putExtra("desc", prayArrayList[position].desc)
                    putExtra("raw", prayArrayList[position].raw)
                }
                startActivity(intent)
            }

        })
    }
}