package com.rvcoding.mygasmix

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import com.rvcoding.mygasmix.ui.MyGasScreen
import com.rvcoding.mygasmix.ui.theme.GreenWoods
import com.rvcoding.mygasmix.ui.theme.MyGasMixTheme

class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            WindowCompat.setDecorFitsSystemWindows(window, false)
        }
        enableEdgeToEdge()
        setContent {
            MyGasMixTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ) { _ ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize(),
                        color = GreenWoods
                    ) {
                        MyGasScreen()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyGasMixTheme {
        MyGasScreen()
    }
}