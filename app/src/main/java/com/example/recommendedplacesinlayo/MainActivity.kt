package com.example.recommendedplacesinlayo

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.recommendedplacesinlayo.model.Recommendation
import androidx.compose.foundation.clickable
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.recommendedplacesinlayo.ui.theme.hitamabu
import com.example.recommendedplacesinlayo.ui.theme.kuning
import com.example.recommendedplacesinlayo.viewmodel.RecommendationViewModel
import kotlinx.coroutines.delay
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

class MainActivity : ComponentActivity() {
    private val recommendationViewModel: RecommendationViewModel by viewModels ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNavigation(recommendationViewModel)
            Log.d("MainActivity", "Recommendations from ViewModel: ${recommendationViewModel.recommendations}")
        }
    }
}

@Composable
fun AppNavigation(viewModel: RecommendationViewModel) {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "splash") {
        composable("splash") { WelcomeScreen(navController) }
        composable("home") { HomeScreen(navController, viewModel) }
        composable("childkategori/{title}") { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title")
            ChildKategoriScreen(title ?: "Detail", navController, viewModel)
        }
        composable("detail/{title}/{description}/{image}") { backStackEntry ->
            val title = backStackEntry.arguments?.getString("title")
            val description = backStackEntry.arguments?.getString("description")
            val image = backStackEntry.arguments?.getString("image")?.toIntOrNull()
            DetailScreen(
                title = title ?: "Detail",
                description = description ?: "Tidak ada deskripsi",
                image = image ?: 0
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController, viewModel: RecommendationViewModel) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Rekomendasi", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFD538),
                    titleContentColor = hitamabu
                )
            )
        }
    )  { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            // Fetching dari view model
            if (viewModel.recommendations.isNotEmpty()) {
                for (recommendation in viewModel.recommendations) {
                    RecommendationItem(recommendation) {
                        navController.navigate("childkategori/${recommendation.kategori}")
                    }
                }
            } else {
                Text("Tidak ada rekomendasi untuk ditampilkan.")
            }
        }
    }
}

@Composable
fun RecommendationItem(recommendation: Recommendation, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            elevation = CardDefaults.cardElevation(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .clickable(onClick = onClick)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(
                        color = kuning,
                        shape = RoundedCornerShape(12.dp)
                    ),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Box(
                        modifier = Modifier
                            .size(65.dp)
                            .background(
                                color = hitamabu,
                                shape = CircleShape,
                            ),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(
                            painter = painterResource(id = recommendation.iconResId),
                            contentDescription = null,
                            modifier = Modifier.size(33.dp),
                            tint = kuning,
                        )
                    }
                    Spacer(modifier = Modifier.width(13.dp))
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = recommendation.kategori,
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontWeight = FontWeight.Bold,
                                fontSize = 22.sp,
                                color = hitamabu
                            )
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChildKategoriScreen(title: String, navController: NavController, viewModel: RecommendationViewModel) {
    val items = viewModel.getItemsForCategory(title)
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("$title", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFD538),
                    titleContentColor = hitamabu
                )
            )
        }
    )  { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (items.isNotEmpty()) {
                for (item in items) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp,8.dp)
                            .clickable {
                                navController.navigate("detail/${item.nama}/${item.deskripsi}/${item.gambar}")
                            },
                        elevation = CardDefaults.cardElevation(4.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = kuning,
                                    shape = RoundedCornerShape(12.dp)
                                ),
                        ){
                        Row(
                            modifier = Modifier.padding(10.dp, 3.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(id = item.gambar),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(64.dp)
                                    .padding(end = 8.dp)
                                    .clip(RoundedCornerShape(10.dp))
                            )
                            Column(
                                verticalArrangement = Arrangement.Center,
                                modifier = Modifier.fillMaxHeight()
                            ) {
                                Text(
                                    text = item.nama,
                                    Modifier.padding(9.dp, 0.dp),
                                    style = MaterialTheme.typography.titleMedium.copy(
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 20.sp,
                                        color = hitamabu
                                    )
                                )
                                Text(
                                    text = item.nama,
                                    Modifier.padding(10.dp, 0.dp),
                                    style = MaterialTheme.typography.titleSmall.copy(
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 8.sp,
                                        color = hitamabu
                                    )
                                )

                                Spacer(modifier = Modifier.height(4.dp))
                            }
                        }
                        }
                    }
                }
            } else {
                Text("Tidak ada rekomendasi untuk ditampilkan.")
            }
        }
    }
}



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(title: String, description: String, image: Int) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("$title", style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFFFD538),
                    titleContentColor = hitamabu
                )
                )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            contentAlignment = Alignment.TopCenter
        ) {
            Column( modifier = Modifier
                .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = image),
                    contentDescription = null,
                    modifier = Modifier
                        .size(290.dp)
                        .padding(bottom = 16.dp, top= 15.dp)
                        .clip(RoundedCornerShape(30.dp))
                )
                Text(
                    text = title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        color = hitamabu,
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.height(13.dp))
                Box(
modifier = Modifier
    .padding(18.dp,0.dp,18.dp,18.dp)
                ){
                    Text(
                        text = description,
                        style = MaterialTheme.typography.bodyMedium,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.SemiBold,
                        color = kuning,
                        modifier = Modifier
                            .fillMaxSize()
                            .background(hitamabu, shape = RoundedCornerShape(12.dp))
                            .padding(14.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun WelcomeScreen(navController: NavController) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == Configuration.ORIENTATION_PORTRAIT

    // Launched untuk nunggu beberapo detik
    LaunchedEffect(key1 = true) {
        delay(3000)
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true } // supaya tidak back ke screen
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = kuning),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(R.drawable.logonobg),
                contentDescription = null,
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp)
            )
            Text(
                text = "Welcome to Recommended Places in Layo",
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Bold,
                    fontSize = 27.sp,
                    color = hitamabu
                ),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(bottom = 16.dp)
            )

        }
    }
    if (isPortrait) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.BottomCenter // Menempatkan gambar di bagian bawah
        ) {
            Image(
                painter = painterResource(R.drawable.welcom_indralaya),
                contentDescription = null,
                modifier = Modifier
                    .size(395.dp, 283.dp)
                    .padding(0.dp, 0.dp)
            )
        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    val viewModel = RecommendationViewModel()
//    HomeScreen(navController = rememberNavController(), viewModel = viewModel)
//}

//@Preview(showBackground = true)
//@Composable
//fun ChildKategoriScreenPreview() {
//    ChildKategoriScreen("Kedai Kopi", rememberNavController(), RecommendationViewModel())
//}

@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    DetailScreen("Jungle Cafe", "Sebuah kedai kopi yang menawarkan suasana hutan tropis dengan berbagai pilihan kopi spesial", R.drawable.jungle)
}

//@Preview(showBackground = true)
//@Composable
//fun LoadingScreenPreview() {
//    WelcomeScreen(rememberNavController())
//}


