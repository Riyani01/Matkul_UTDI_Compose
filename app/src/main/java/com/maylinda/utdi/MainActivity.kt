package com.maylinda.utdi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.maylinda.utdi.data.Utdi
import com.maylinda.utdi.data.utdis
import com.maylinda.utdi.ui.theme.UtdiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UtdiTheme {
                UtdiApp()
            }
        }
    }
}

@Composable
fun UtdiApp() {
    Scaffold(
        topBar = {
            UtdiTopAppBar()
        }
    ) {
        LazyColumn(modifier = Modifier.background(MaterialTheme.colors.background)) {
            items(utdis) {
                UtdiItem(utdi = it)
            }
        }
    }
}

@Composable
fun UtdiItem(utdi: Utdi, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        elevation = 4.dp,
        modifier = modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                UtdiIcon(utdi.imageResourceId)
                UtdiInformation(utdi.name, utdi.age)
                Spacer(Modifier.weight(1f))
                UtdiItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                )
            }
            if (expanded) {
                UtdiHobby(utdi.hobbies)
            }
        }
    }
}
@Composable
private fun UtdiItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colors.secondary,
            contentDescription = stringResource(R.string.expand_button_content_description),
        )
    }
}
@Composable
fun UtdiTopAppBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colors.primary),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = modifier
                .size(100.dp)
                .padding(14.dp),
            painter = painterResource(R.drawable.ic_utdi),
            /*
             * Content Description is not needed here - image is decorative, and setting a null
             * content description allows accessibility services to skip this element during
             * navigation.
             */
            contentDescription = null
        )
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.h1
        )
        Text(
            modifier = modifier.padding(top = 8.dp),
            text = stringResource(R.string.app_info),
            style = MaterialTheme.typography.body1
        )

    }
}
@Composable
fun UtdiIcon(@DrawableRes utdiIcon: Int, modifier: Modifier = Modifier) {
    Image(
        modifier = modifier
            .size(80.dp)
            .padding(8.dp)
            .clip(RoundedCornerShape(50)),
        contentScale = ContentScale.Crop,
        painter = painterResource(utdiIcon),
        /*
         * Content Description is not needed here - image is decorative, and setting a null content
         * description allows accessibility services to skip this element during navigation.
         */
        contentDescription = null
    )
}
@Composable
fun UtdiInformation(@StringRes utdiName: Int, utdiAge: Int, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = stringResource(utdiName),
            style = MaterialTheme.typography.h2,
            modifier = modifier.padding(top = 8.dp)
        )
        Text(
            text = stringResource(R.string.banyak_sks, utdiAge),
            style = MaterialTheme.typography.body1
        )
    }
}
@Composable
fun UtdiHobby(@StringRes UtdiHobby: Int, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(
            start = 16.dp,
            top = 8.dp,
            bottom = 16.dp,
            end = 16.dp
        )
    ) {
        Text(
            text = stringResource(R.string.sks),
            style = MaterialTheme.typography.h3
        )
        Text(
            text = stringResource(UtdiHobby),
            style = MaterialTheme.typography.body1
        )
    }
}
@Preview
@Composable
fun UtdiPreview() {
    UtdiTheme(darkTheme = false) {
        UtdiApp()
    }
}
@Preview
@Composable
fun UtdiDarkThemePreview() {
    UtdiTheme(darkTheme = true) {
        UtdiApp()
    }
}


