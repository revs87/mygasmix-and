package com.rvcoding.mygasmix

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.MenuItemColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.isDigitsOnly
import androidx.core.view.WindowCompat
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

@SuppressLint("DefaultLocale")
@Composable
fun MyGasScreen() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.splash),
            contentScale = ContentScale.Crop,
            contentDescription = "background-img"
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(6.dp),
                textAlign = TextAlign.Center,
                text = "Copyright © RVCODING 2024",
                color = Color.White,
                fontSize = 8.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.SemiBold
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                var gasInput by rememberSaveable { mutableStateOf("") }
                var gasRatio by rememberSaveable { mutableStateOf("0.0190") }
                val keyboardController = LocalSoftwareKeyboardController.current
                val focusManager = LocalFocusManager.current

                Spacer(modifier = Modifier.weight(1f))

                TextField(
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(
                            text = "GAS mL",
                            color = Color.White,
                            fontFamily = FontFamily.Monospace,
                            fontWeight = FontWeight.SemiBold
                        ) },
                    trailingIcon = {
                        if (gasInput.isNotBlank()) {
                            IconButton(
                                modifier = Modifier,
                                onClick = {
                                    gasInput = ""
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Clear,
                                    contentDescription = "down",
                                    tint = Color.White
                                )
                            }
                        }
                    },
                    value = gasInput,
                    onValueChange = {
                        if (it.isDigitsOnly()
                            && it.length <= Int.MAX_VALUE
                            && it.toLong() < Int.MAX_VALUE) {
                            gasInput = it
                        }
                    },
                    textStyle = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Monospace,
                        fontWeight = FontWeight.SemiBold
                    ),
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            keyboardController?.hide()
                            focusManager.clearFocus()
                        }
                    ),
                    colors = TextFieldColors(
                        focusedContainerColor = Color.Transparent,
                        unfocusedContainerColor = Color.Transparent,
                        disabledTextColor = TextFieldDefaults.colors().disabledTextColor,
                        focusedIndicatorColor = Color.White,
                        unfocusedIndicatorColor = Color.White,
                        errorIndicatorColor = TextFieldDefaults.colors().errorIndicatorColor,
                        focusedTextColor = Color.White,
                        unfocusedTextColor = Color.White,
                        errorTextColor = TextFieldDefaults.colors().errorTextColor,
                        disabledContainerColor = TextFieldDefaults.colors().disabledContainerColor,
                        errorContainerColor = TextFieldDefaults.colors().errorContainerColor,
                        cursorColor = Color.White,
                        errorCursorColor = TextFieldDefaults.colors().errorCursorColor,
                        textSelectionColors = TextFieldDefaults.colors().textSelectionColors,
                        disabledIndicatorColor = TextFieldDefaults.colors().disabledIndicatorColor,
                        focusedLeadingIconColor = TextFieldDefaults.colors().focusedLeadingIconColor,
                        unfocusedLeadingIconColor = TextFieldDefaults.colors().unfocusedLeadingIconColor,
                        disabledLeadingIconColor = TextFieldDefaults.colors().disabledLeadingIconColor,
                        errorLeadingIconColor = TextFieldDefaults.colors().errorLeadingIconColor,
                        focusedTrailingIconColor = TextFieldDefaults.colors().focusedTrailingIconColor,
                        unfocusedTrailingIconColor = TextFieldDefaults.colors().unfocusedTrailingIconColor,
                        disabledTrailingIconColor = TextFieldDefaults.colors().disabledTrailingIconColor,
                        errorTrailingIconColor = TextFieldDefaults.colors().errorTrailingIconColor,
                        focusedLabelColor = TextFieldDefaults.colors().focusedLabelColor,
                        unfocusedLabelColor = TextFieldDefaults.colors().unfocusedLabelColor,
                        disabledLabelColor = TextFieldDefaults.colors().disabledLabelColor,
                        errorLabelColor = TextFieldDefaults.colors().errorLabelColor,
                        focusedPlaceholderColor = TextFieldDefaults.colors().focusedPlaceholderColor,
                        unfocusedPlaceholderColor = TextFieldDefaults.colors().unfocusedPlaceholderColor,
                        disabledPlaceholderColor = TextFieldDefaults.colors().disabledPlaceholderColor,
                        errorPlaceholderColor = TextFieldDefaults.colors().errorPlaceholderColor,
                        focusedSupportingTextColor = TextFieldDefaults.colors().errorPlaceholderColor,
                        unfocusedSupportingTextColor = TextFieldDefaults.colors().unfocusedSupportingTextColor,
                        disabledSupportingTextColor = TextFieldDefaults.colors().disabledSupportingTextColor,
                        errorSupportingTextColor = TextFieldDefaults.colors().errorSupportingTextColor,
                        focusedPrefixColor = TextFieldDefaults.colors().focusedPrefixColor,
                        unfocusedPrefixColor = TextFieldDefaults.colors().unfocusedPrefixColor,
                        disabledPrefixColor = TextFieldDefaults.colors().disabledPrefixColor,
                        errorPrefixColor = TextFieldDefaults.colors().errorPrefixColor,
                        focusedSuffixColor = TextFieldDefaults.colors().focusedSuffixColor,
                        unfocusedSuffixColor = TextFieldDefaults.colors().unfocusedSuffixColor,
                        disabledSuffixColor = TextFieldDefaults.colors().disabledSuffixColor,
                        errorSuffixColor = TextFieldDefaults.colors().errorSuffixColor
                    )
                )
                Spinner(
                    items = listOf(
                        "0.0200",
                        "0.0195",
                        "0.0190",
                        "0.0185",
                        "0.0180",
                        "0.0175",
                    ),
                    selectedItem = gasRatio,
                    onItemSelected = { selected ->
                        gasRatio = selected
                    }
                )

                HorizontalDivider(
                    color = Color.White
                )

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp, bottom = 16.dp, end = 16.dp),
                    text = "Result: ${String.format(
                        format = "%.1f",
                        when {
                            gasInput.isEmpty() -> 0f
                            else -> gasInput.toFloat() * gasRatio.toFloat()
                        }
                    )}mL (2 STROKE OIL)",
                    color = Color.White,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold
                )

                Spacer(modifier = Modifier.weight(0.15f))

            }
        }
    }
}

@Composable
fun Spinner(
    items: List<String>,
    selectedItem: String,
    onItemSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.wrapContentSize(Alignment.TopStart)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    bottom = 16.dp,
                    end = 16.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row {
                Text(
                    text = "Ratio:  ",
                    color = Color.White,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = selectedItem,
                    color = Color.White,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold
                )
            }
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = "down",
                tint = Color.White
            )
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth(),
            containerColor = GreenWoods
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    },
                    text = {
                        Row(
                            modifier = Modifier.fillMaxSize(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = item,
                                color = Color.White,
                                fontFamily = FontFamily.Monospace,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    },
                    colors = MenuItemColors(
                        textColor = Color.White,
                        leadingIconColor = MenuDefaults.itemColors().textColor,
                        trailingIconColor = MenuDefaults.itemColors().textColor,
                        disabledTextColor = Color.LightGray,
                        disabledLeadingIconColor = MenuDefaults.itemColors().textColor,
                        disabledTrailingIconColor = MenuDefaults.itemColors().textColor
                    )
                )
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