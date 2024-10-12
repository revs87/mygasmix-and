package com.rvcoding.mygasmix

import android.annotation.SuppressLint
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
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.text.isDigitsOnly
import com.rvcoding.mygasmix.ui.theme.MyGasMixTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyGasMixTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
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
                    label = { Text(text = "mLs") },
                    value = gasInput,
                    onValueChange = {
                        if (it.isDigitsOnly()
                            && it.length <= Int.MAX_VALUE
                            && it.toLong() < Int.MAX_VALUE) {
                            gasInput = it
                        }
                    },
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
                        focusedIndicatorColor = TextFieldDefaults.colors().focusedIndicatorColor,
                        unfocusedIndicatorColor = TextFieldDefaults.colors().unfocusedIndicatorColor,
                        errorIndicatorColor = TextFieldDefaults.colors().errorIndicatorColor,
                        focusedTextColor = TextFieldDefaults.colors().focusedTextColor,
                        unfocusedTextColor = TextFieldDefaults.colors().unfocusedTextColor,
                        errorTextColor = TextFieldDefaults.colors().errorTextColor,
                        disabledContainerColor = TextFieldDefaults.colors().disabledContainerColor,
                        errorContainerColor = TextFieldDefaults.colors().errorContainerColor,
                        cursorColor = TextFieldDefaults.colors().cursorColor,
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
                    color = Color.LightGray
                )

                Text(
                    modifier = Modifier.fillMaxWidth().padding(start = 16.dp, top = 16.dp, bottom = 16.dp, end = 16.dp),
                    text = "Result: ${String.format(
                        format = "%.3f",
                        when {
                            gasInput.isEmpty() -> 0f
                            else -> gasInput.toFloat() * gasRatio.toFloat()
                        }
                    )}mLs"
                )

                Spacer(modifier = Modifier.weight(0.3f))

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
            Text(selectedItem)
            Icon(Icons.Filled.ArrowDropDown, "down")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.fillMaxWidth()
        ) {
            items.forEach { item ->
                DropdownMenuItem(
                    onClick = {
                        onItemSelected(item)
                        expanded = false
                    },
                    text = {
                        Text(text = item)
                    }
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