package com.example.recommendedplacesinlayo.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.recommendedplacesinlayo.R
import com.example.recommendedplacesinlayo.model.ItemRecommendation
import com.example.recommendedplacesinlayo.model.Recommendation

class RecommendationViewModel : ViewModel() {
    private val _recommendations = mutableStateListOf<Recommendation>()
    val recommendations: List<Recommendation> get() = _recommendations

    init {
        loadRecommendations()
    }

    private fun loadRecommendations() {
        _recommendations.addAll(listOf(
            Recommendation(
                kategori = "Kedai Kopi",
                items = listOf(
                    ItemRecommendation("Jungle Cafe",
                        "Jungle Cafe adalah salah satu kedai kopi yang menawarkan pengalaman unik di mana pengunjung bisa merasakan suasana alam di tengah kota. Berada di antara pepohonan hijau dan tanaman hias, kafe ini memberikan suasana yang sejuk dan asri, membuat setiap tamu merasa berada di dalam hutan tropis. Dekorasi alami yang kaya akan elemen kayu dan batuan alam menciptakan kesan pedesaan yang modern. Jungle Cafe tidak hanya menawarkan kopi lokal yang diracik dengan teknik manual brewing terbaik, tetapi juga aneka varian kopi internasional, seperti espresso, cappuccino, dan latte yang diolah oleh barista profesional. Selain kopi, pengunjung juga dapat menikmati berbagai menu pendamping seperti croissant, sandwich, dan pastry buatan sendiri. Jungle Cafe sering menjadi pilihan bagi pengunjung yang ingin melarikan diri dari hiruk-pikuk kota sambil menikmati aroma kopi segar dan suasana alam yang menyegarkan.",
                        "Jl. Nusantara, Timbangan, Kecamatan Indralaya Utara, Kabupaten Ogan Ilir, Sumatera Selatan 30862",
                        R.drawable.jungle),
                    ItemRecommendation("J&J Cafe",
                        "Sebuah kedai kopi yang menawarkan suasana hutan tropis dengan berbagai pilihan kopi spesial Sebuah kedai kopi yang menawarkan suasana hutan tropis dengan berbagai pilihan kopi spesial Sebuah kedai kopi yang menawarkan suasana hutan tropis dengan berbagai pilihan kopi spesial Sebuah kedai kopi yang menawarkan suasana hutan tropis dengan berbagai pilihan kopi spesial Sebuah kedai kopi yang menawarkan suasana hutan tropis dengan berbagai pilihan kopi spesial Sebuah kedai kopi yang menawarkan suasana hutan tropis dengan berbagai pilihan kopi spesial Sebuah kedai kopi yang menawarkan suasana hutan tropis dengan berbagai pilihan kopi spesial Sebuah kedai kopi yang menawarkan suasana hutan tropis dengan berbagai pilihan kopi spesial Sebuah kedai kopi yang menawarkan suasana hutan tropis dengan berbagai pilihan kopi spesial Sebuah kedai kopi yang menawarkan suasana hutan tropis dengan berbagai pilihan kopi spesial Sebuah kedai kopi yang menawarkan suasana hutan tropis dengan berbagai pilihan kopi spesial Sebuah kedai kopi yang menawarkan suasana hutan tropis dengan berbagai pilihan kopi spesial",
                        "Jl. Sudirman Km. 34, Kel, Indralaya Raya, Kec. Indralaya, Kabupaten Ogan Ilir, Sumatera Selatan 30862",
                        R.drawable.jj),
                    ItemRecommendation("Biloni Coffee 'n reams",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                        "rumah makan cipta rasa, lorong samping, Kabupaten Ogan Ilir, Sumatera Selatan 30662",
                        R.drawable.biloni),
                    ItemRecommendation("LiriKopi",
                        "LirikKopi menawarkan suasana nyaman dengan sentuhan desain tradisional yang memadukan elemen kayu dan rotan. Dengan menu andalan kopi lokal yang diseduh langsung dari biji-biji terbaik, cafe ini menjadi tempat favorit bagi para pecinta kopi. Tersedia juga pilihan makanan ringan khas Indonesia, seperti pisang goreng dan tempe mendoan, yang sempurna untuk menemani secangkir kopi. Setiap sudut cafe memberikan nuansa tenang, cocok untuk bersantai sambil menikmati musik akustik yang menyegarkan. Lokasinya yang strategis di pusat kota memudahkan akses pengunjung dari berbagai kalangan.",
                       "Jl. Raya Lintas Timur Palembang - Prabumulih No.KM. 32, Timbangan, Kecamatan Indralaya Utara, Kabupaten Ogan Ilir, Sumatera Selatan 30862",
                        R.drawable.lirikkopi),
                    ItemRecommendation("Rikuh Coffee",
                        "Rikuh Coffee menawarkan suasana yang sangat asri dengan area outdoor yang dikelilingi taman hijau dan pepohonan rindang. Tempat ini menjadi favorit bagi mereka yang mencari kedamaian sambil menikmati secangkir kopi. Barista di Rikuh Coffee menggunakan biji kopi pilihan dari berbagai daerah di Indonesia, seperti Gayo, Toraja, dan Bali, yang memberikan rasa kopi yang berbeda dan kaya. Di samping menu kopi klasik seperti Americano dan Latte, Rikuh Coffee juga menawarkan varian minuman es yang menyegarkan, seperti iced caramel macchiato dan cold brew tonic. Selain itu, Rikuh Coffee juga dikenal karena hidangan pendampingnya yang lezat, seperti waffle dengan topping es krim dan sirup maple, serta croffle (croissant waffle) yang renyah di luar dan lembut di dalam. Suasana di Rikuh Coffee sangat ramah dan menyenangkan, dengan staf yang selalu tersenyum dan siap melayani. Tempat ini sering kali menjadi pilihan untuk acara kecil seperti gathering komunitas atau rapat santai dengan kolega",
                        "Jl. Raya Lintas Timur Palembang - Prabumulih No.19, Timbangan, Kecamatan Indralaya Utara, Kabupaten Ogan Ilir, Sumatera Selatan 30862",
                        R.drawable.rikuhcaffe),
                    ItemRecommendation("Pojok Kopi",
                        "Pojok Kopi adalah kedai kopi mungil namun memiliki suasana yang sangat cozy dan menarik. Terletak di pojok jalan yang tenang, Pojok Kopi menawarkan suasana yang homy, cocok untuk mereka yang ingin menghabiskan waktu sendiri atau berkumpul dengan teman dalam suasana yang lebih intim. Meskipun ukurannya kecil, Pojok Kopi menyajikan berbagai pilihan kopi yang tak kalah dengan kedai kopi besar lainnya. Mereka menggunakan biji kopi lokal yang digiling setiap hari, memastikan kesegaran dalam setiap cangkir kopi yang disajikan. Menu andalan Pojok Kopi termasuk espresso yang kuat, cappuccino dengan foam yang lembut, serta signature drink mereka, Es Kopi Susu Gula Aren, yang menjadi favorit pelanggan setia. Selain kopi, Pojok Kopi juga menyediakan berbagai makanan ringan seperti roti bakar, kue cubit, dan pisang goreng keju yang sangat pas sebagai teman minum kopi. Suasana kedai yang nyaman dan pelayanan yang ramah menjadikan Pojok Kopi tempat yang selalu dirindukan oleh para pelanggannya.",
                        "QMR2+J8Q, Timbangan, Kecamatan Indralaya Utara, Kabupaten Ogan Ilir, Sumatera Selatan 30862",
                        R.drawable.pojokkopi)
                ),

                iconResId = R.drawable.ic_coffee
            ),
            Recommendation(
                kategori = "Restoran",
                items = listOf(
                    ItemRecommendation("Rumah Makan Pagi Sore",
                        "Rumah Makan Pagi Sore adalah restoran legendaris yang sudah dikenal luas di Indonesia, terutama di daerah Sumatra. Tempat ini terkenal dengan masakan Padang yang autentik dan lezat. Hidangan andalan di sini termasuk rendang, ayam pop, gulai kepala ikan, dan sambal hijau yang menggugah selera. Interior restoran sederhana namun nyaman, dengan suasana yang bersahabat dan pelayanan yang cepat. Restoran ini menjadi pilihan favorit bagi mereka yang mencari makan siang cepat namun berkualitas dengan harga yang terjangkau. Bagi para pengunjung yang datang beramai-ramai, Pagi Sore juga menyediakan paket nasi kotak dan catering untuk acara besar.",
                        "QJVG+3HX, Tj. Baru, Kecamatan Indralaya Utara, Kabupaten Ogan Ilir, Sumatera Selatan 30862",
                        R.drawable.pagisore
                    ),
                    ItemRecommendation("Pindang Pas",
                        "Pindang Pas menawarkan masakan khas Palembang dengan spesialisasi pindang ikan yang segar dan gurih. Restoran ini selalu menggunakan ikan segar yang dimasak dengan bumbu pindang tradisional, menghasilkan rasa asam dan pedas yang khas. Selain pindang ikan, menu lain yang ditawarkan di sini adalah pempek, model, dan tekwan, yang semuanya merupakan makanan khas Palembang. Tempat ini dikenal dengan suasana yang homey dan pelayanannya yang ramah. Pengunjung dapat menikmati makan di dalam ruangan ber-AC atau di area terbuka yang lebih santai. Pindang Pas juga menyediakan layanan pesan antar bagi pelanggan yang ingin menikmati hidangan lezat mereka di rumah.",
                        "Jl. Lintas Sumatra, Indralaya Indah, Kec. Indralaya, Kabupaten Ogan Ilir, Sumatera Selatan 30862",
                        R.drawable.pindangpas
                    ),
                    ItemRecommendation("Rumah Makan Soponyono",
                        "Rumah Makan Soponyono adalah restoran yang terkenal dengan hidangan sop buntut yang lezat. Sop buntut di sini memiliki kuah yang bening dan gurih, dengan daging buntut yang empuk dan bumbu yang meresap sempurna. Selain sop buntut, restoran ini juga menawarkan berbagai pilihan hidangan khas Indonesia lainnya seperti nasi goreng, ayam goreng, dan soto ayam. Suasana restoran sangat nyaman dengan dekorasi tradisional yang membuat pengunjung merasa seperti di rumah sendiri. Cocok untuk acara keluarga atau makan bersama teman-teman.",
                        "Jl. Lintas Sumatra No.468, Timbangan, Kecamatan Indralaya Utara, Kabupaten Ogan Ilir, Sumatera Selatan 30862",
                        R.drawable.sopoyono
                    ),
                    ItemRecommendation("Pondok Pindang Musi Rawas",
                        "Pondok Pindang Musi Rawas menyajikan hidangan pindang ikan khas Palembang dengan cita rasa yang otentik. Tempat ini terkenal dengan pindang patin dan pindang baung, yang disajikan dengan sambal tempoyak dan lalapan segar. Selain pindang, Pondok Pindang Musi Rawas juga menawarkan berbagai hidangan lain seperti pempek, tekwan, dan berbagai olahan ikan lainnya. Restoran ini memiliki suasana yang nyaman dengan interior kayu dan pemandangan sungai, membuatnya menjadi tempat favorit bagi mereka yang ingin menikmati hidangan tradisional sambil menikmati suasana alam.",
                        "Jl. Angkatan 45 No.18, Lorok Pakjo, Kec. Ilir Bar. I, Kota Palembang, Sumatera Selatan 30137",
                        R.drawable.pondokpindangmantap
                    )
                ),


                iconResId = R.drawable.ic_restaurant
            ),
            Recommendation(
                kategori = "Taman",
                items = listOf(
                    ItemRecommendation(
                        "Taman Pemerintah Kabupaten Ogan Ilir",
                        "Taman Pemerintah Kabupaten Ogan Ilir merupakan sebuah ruang terbuka hijau yang dirancang untuk menyediakan tempat rekreasi yang nyaman bagi warga setempat. Taman ini dilengkapi dengan berbagai fasilitas seperti tempat duduk, area bermain anak-anak, dan jalan setapak yang dikelilingi oleh pepohonan rindang. Taman ini menjadi tempat favorit untuk bersantai di akhir pekan, terutama bagi keluarga yang ingin menghabiskan waktu berkualitas bersama anak-anak mereka. Selain itu, taman ini sering dijadikan lokasi berbagai acara komunitas, seperti bazar, pameran, dan kegiatan olahraga pagi seperti senam bersama. Pada hari-hari tertentu, taman ini juga menjadi lokasi penyelenggaraan konser musik lokal dan pertunjukan seni budaya yang menarik perhatian banyak pengunjung. Suasananya yang tenang dan asri membuat taman ini cocok untuk semua kalangan, mulai dari anak-anak hingga orang dewasa, yang ingin menikmati suasana segar di tengah hiruk-pikuk kota.",
                        "PMQ3+M6J, Sakatiga Seberang, Kec. Indralaya, Kabupaten Ogan Ilir, Sumatera Selatan 30815",
                        R.drawable.tamanpemerintahan
                    ),
                    ItemRecommendation(
                        "TAMAN PANCASILA",
                        "TAMAN PANCASILA KM 32 Indralaya merupakan salah satu ikon penting di daerah Ogan Ilir. Taman ini memiliki sebuah monumen Pancasila yang megah sebagai pusatnya, yang merupakan simbol nasionalisme dan persatuan bangsa. Selain itu, taman ini juga dilengkapi dengan fasilitas jogging track yang sangat cocok untuk olahraga pagi. Banyak warga setempat yang datang ke taman ini untuk berjalan-jalan santai, berlari, atau sekadar menikmati udara segar di pagi hari. Taman ini juga memiliki ruang terbuka yang sering dijadikan tempat piknik oleh keluarga, serta area hijau yang luas yang ideal untuk berbagai aktivitas luar ruangan. Di sekitar taman, terdapat beberapa pedagang kaki lima yang menjual makanan ringan dan minuman, membuat tempat ini semakin ramai terutama pada akhir pekan. Taman Pancasila juga sering dijadikan lokasi untuk peringatan hari-hari nasional dan acara kebudayaan lokal, menjadikannya tempat yang sangat bernilai sejarah bagi masyarakat setempat.",
                        "Jl. Lintas Sumatra No.2016, Timbangan, Kecamatan Indralaya Utara, Kabupaten Ogan Ilir, Sumatera Selatan 30862",
                        R.drawable.tp
                    ),
                    ItemRecommendation(
                        "Danau Teluk Seruo",
                        "Danau Teluk Seruo adalah salah satu destinasi wisata alam yang paling dicari di Ogan Ilir. Danau ini terkenal karena pemandangannya yang indah dengan air yang tenang dan jernih, serta dikelilingi oleh pepohonan hijau yang menambah kesejukan suasana. Banyak pengunjung yang datang ke danau ini untuk piknik bersama keluarga atau teman-teman. Di sekitar danau, tersedia area terbuka yang cocok untuk bermain, berolahraga, atau sekadar duduk santai menikmati pemandangan alam. Di sore hari, danau ini sering dipadati pengunjung yang ingin menikmati matahari terbenam yang spektakuler di tepi air. Selain itu, danau ini juga merupakan habitat berbagai jenis burung dan satwa liar, sehingga menjadi tempat yang menarik bagi para pecinta alam dan pengamat burung. Pengunjung juga bisa berperahu santai di danau ini, yang menambah keseruan liburan di tempat ini. Danau Teluk Seruo benar-benar menjadi tempat yang ideal untuk melarikan diri dari kesibukan sehari-hari dan menikmati ketenangan alam.",
                        "PJRV+FMJ, Sakatiga Seberang, Kec. Indralaya, Kabupaten Ogan Ilir, Sumatera Selatan 30664",
                        R.drawable.teluksero
                    ),
                    ItemRecommendation(
                        "Danau Universitas Sriwijaya Indralaya",
                        "Danau Universitas Sriwijaya di Indralaya adalah salah satu aset alam yang paling berharga dari kampus Universitas Sriwijaya. Danau ini tidak hanya menjadi daya tarik bagi mahasiswa, tetapi juga bagi masyarakat umum yang ingin menikmati suasana yang tenang dan damai. Dengan pemandangan hijau yang melingkupi danau dan pepohonan yang rindang, tempat ini memberikan suasana yang sangat mendukung untuk belajar atau hanya sekadar bersantai. Banyak mahasiswa yang menggunakan area sekitar danau sebagai tempat untuk berdiskusi, belajar kelompok, atau hanya sekadar berkumpul bersama teman-teman. Pada waktu-waktu tertentu, danau ini juga menjadi lokasi favorit untuk kegiatan olahraga air seperti dayung atau kano. Suasana di sekitar danau semakin indah di sore hari, terutama ketika matahari mulai terbenam, menciptakan pemandangan yang sangat memukau. Tempat ini juga sering dijadikan lokasi foto pre-wedding atau acara kampus seperti lomba perahu hias. Bagi siapa saja yang mencari ketenangan di tengah kesibukan kampus, Danau Universitas Sriwijaya adalah tempat yang sempurna untuk melarikan diri dari hiruk pikuk kehidupan akademik.",
                        "QJCX+CWX, Indralaya Indah, Kec. Indralaya, Kabupaten Ogan Ilir, Sumatera Selatan 30862",
                        R.drawable.danaunsri
                    ),
                    ItemRecommendation(
                        "Taman Tugu Pendidikan",
                        "Taman Tugu Pendidikan merupakan salah satu ruang hijau yang paling dikenal di Indralaya, terutama di kalangan pelajar dan akademisi. Taman ini memiliki sebuah tugu besar yang menjadi simbol pendidikan di daerah tersebut, yang sering dijadikan sebagai titik pertemuan atau tempat berkumpul. Taman ini dikelilingi oleh pepohonan yang teduh, sehingga menciptakan suasana yang sangat nyaman untuk belajar di luar ruangan atau sekadar bersantai. Banyak mahasiswa yang datang ke sini untuk menghabiskan waktu dengan membaca buku atau berdiskusi kelompok. Di sekitar tugu, terdapat beberapa bangku taman dan meja yang memfasilitasi kegiatan belajar atau bekerja di luar ruangan. Pada hari-hari tertentu, taman ini juga menjadi tempat berkumpulnya komunitas-komunitas lokal yang mengadakan diskusi atau kegiatan kreatif seperti seni jalanan dan pertunjukan musik akustik. Suasananya yang sejuk dan tenang membuat taman ini menjadi tempat favorit bagi banyak orang untuk mengisi waktu luang sekaligus menambah wawasan.",
                        "QMP4+28H, Timbangan, Kecamatan Indralaya Utara, Kabupaten Ogan Ilir, Sumatera Selatan 30862",
                        R.drawable.tamantugupddk
                    )
                ),
                iconResId = R.drawable.ic_park
            ),
            Recommendation(
                kategori = "Pusat Perbelanjaan",
                items = listOf(
                    ItemRecommendation(
                        "Pasar Kalangan Palem Raya",
                        "Pasar Kalangan Palem Raya merupakan pasar tradisional yang menyediakan berbagai kebutuhan sehari-hari, mulai dari bahan makanan segar, pakaian, hingga alat rumah tangga. Pasar ini selalu ramai dengan pedagang lokal yang menawarkan produk dengan harga yang terjangkau. Salah satu daya tarik utama pasar ini adalah variasi produknya yang sangat lengkap, sehingga pengunjung dapat menemukan hampir semua barang yang mereka butuhkan dalam satu tempat. Selain itu, pasar ini juga dikenal dengan suasana yang hidup dan penuh warna, di mana pengunjung dapat merasakan kehangatan interaksi antar pedagang dan pembeli. Banyak produk lokal yang dijual di pasar ini, mulai dari hasil tani hingga kerajinan tangan. Selain itu, beberapa pedagang makanan juga menjual jajanan tradisional khas Palembang yang sulit ditemukan di tempat lain, membuat pengalaman berbelanja di pasar ini tidak hanya memuaskan kebutuhan sehari-hari, tetapi juga memberikan kesempatan untuk menikmati cita rasa lokal.",
                        "RM5M+3CF, Palem Raya, Kecamatan Indralaya Utara, Kabupaten Ogan Ilir, Sumatera Selatan 30817",
                        R.drawable.pasarpalemraya
                    ),
                    ItemRecommendation(
                        "Pasar Indralaya",
                        "Pasar Indralaya merupakan pasar tradisional terbesar di daerah ini, dan menjadi pusat aktivitas perdagangan bagi penduduk lokal. Pasar ini menawarkan berbagai jenis produk, mulai dari sayur-sayuran segar, daging, ikan, hingga barang kebutuhan rumah tangga lainnya. Pasar ini juga menyediakan berbagai jenis pakaian dan aksesoris dengan harga yang terjangkau, sehingga menjadi tujuan belanja yang populer bagi masyarakat. Di pagi hari, suasana pasar sangat ramai dengan pembeli yang mencari bahan makanan segar untuk memasak. Pasar ini juga memiliki area khusus yang menjual makanan siap saji, di mana pengunjung dapat mencicipi berbagai hidangan lokal seperti nasi uduk, lontong sayur, dan aneka gorengan. Suasana pasar yang ramai dan interaksi yang hangat antara pedagang dan pembeli membuat pasar ini menjadi pusat kehidupan sosial masyarakat di daerah Indralaya.",
                       "PMWG+FPV, Jl. Lintas Timur KM. 38, Komp Pasar Indralaya Kel, Jl. Lintas Sumatra Pasar, Indralaya Mulia, Indralaya, Ogan Ilir Regency, South Sumatra 30862",
                        R.drawable.pasarlayo
                    ),
                    ItemRecommendation(
                        "Toko TH. Pelangi Tanjung Raya",
                        "Toko TH. Pelangi Tanjung Raya merupakan toko serba ada yang menawarkan berbagai macam barang kebutuhan rumah tangga, pakaian, dan aksesoris. Toko ini dikenal dengan kualitas produknya yang baik serta harga yang kompetitif, menjadikannya salah satu tempat belanja favorit bagi penduduk lokal. Selain itu, toko ini juga menyediakan berbagai barang impor yang sulit ditemukan di tempat lain, sehingga menjadi daya tarik tersendiri bagi pengunjung yang mencari produk-produk unik. Pelayanan yang ramah dan suasana toko yang nyaman juga membuat pengalaman berbelanja di sini lebih menyenangkan. Dengan koleksi yang lengkap, mulai dari pakaian, alat-alat dapur, hingga mainan anak-anak, Toko TH. Pelangi selalu menjadi pilihan utama bagi keluarga yang ingin berbelanja kebutuhan sehari-hari dalam satu tempat.",
                        "QM45+58M, Indralaya Mulia, Kec. Indralaya, Kabupaten Ogan Ilir, Sumatera Selatan 30862",
                        R.drawable.pelangi
                    ),
                    ItemRecommendation(
                        "Kaiia Fashion & Dapur Kaiia",
                        "Kaiia Fashion & Dapur Kaiia adalah toko yang unik, menggabungkan bisnis fashion dengan kafe yang menyajikan berbagai makanan enak. Di satu sisi, toko ini menawarkan berbagai produk fashion terkini yang cocok untuk semua kalangan, mulai dari pakaian kasual hingga busana formal. Desain pakaian yang modern dan up-to-date menjadi daya tarik utama bagi pelanggan muda yang selalu ingin tampil stylish. Di sisi lain, pengunjung juga dapat menikmati berbagai hidangan lezat di Dapur Kaiia, seperti nasi goreng, mie ayam, dan aneka kue-kue yang segar. Kombinasi antara fashion dan kuliner ini menjadikan Kaiia sebagai tempat yang populer di kalangan anak muda, terutama mereka yang ingin menghabiskan waktu bersama teman sambil berbelanja dan menikmati makanan lezat. Lokasinya yang strategis dan suasana yang nyaman membuat toko ini menjadi salah satu destinasi favorit di Palemraya.",
                        "Perumahan palemraya, Palem Raya, Kecamatan Indralaya Utara, Kabupaten Ogan Ilir, Sumatera Selatan 30862",
                        R.drawable.kaiia
                    ),
                    ItemRecommendation(
                        "MR. DIY Indralaya",
                        "MR. DIY  merupakan toko serba ada yang menawarkan berbagai macam barang kebutuhan rumah tangga, pakaian, dan aksesoris. Toko ini dikenal dengan kualitas produknya yang baik serta harga yang kompetitif, menjadikannya salah satu tempat belanja favorit bagi penduduk lokal. Selain itu, toko ini juga menyediakan berbagai barang impor yang sulit ditemukan di tempat lain, sehingga menjadi daya tarik tersendiri bagi pengunjung yang mencari produk-produk unik. Pelayanan yang ramah dan suasana toko yang nyaman juga membuat pengalaman berbelanja di sini lebih menyenangkan. Dengan koleksi yang lengkap, mulai dari pakaian, alat-alat dapur, hingga mainan anak-anak, Toko TH. Pelangi selalu menjadi pilihan utama bagi keluarga yang ingin berbelanja kebutuhan sehari-hari dalam satu tempat.",
                       "Jl. Lintas Sumatra No.Km 37, Indralaya Mulia, Kec. Indralaya, Kabupaten Ogan Ilir, Sumatera Selatan 30862",
                        R.drawable.diy
                    )
                ),
                iconResId = R.drawable.ic_shopping
            )
        ))
    }

    // Method untuk mengambil item berdasarkan kategori
    fun getItemsForCategory(category: String): List<ItemRecommendation> {
        return _recommendations.find { it.kategori == category }?.items ?: emptyList()
    }
}
