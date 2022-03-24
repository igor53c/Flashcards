package com.ipcoding.flashcards.feature.presentation.start.components

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import com.ipcoding.flashcards.R
import com.ipcoding.flashcards.core.util.Constants.APPLICATION_LINK
import com.ipcoding.flashcards.ui.theme.AppTheme

@Composable
fun IconsRow(
    onChangeThemeClick: () -> Unit,
    isDarkTheme: Boolean
) {
    val uriHandler = LocalUriHandler.current
    val context = LocalContext.current
    val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, APPLICATION_LINK)
        type = "text/plain"
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        IconButton(
            onClick = { context.startActivity(Intent.createChooser(sendIntent, null)) },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = stringResource(id = R.string.share_icon),
                modifier = Modifier.size(AppTheme.dimensions.spaceLarge),
                tint = AppTheme.colors.primary
            )
        }

        IconButton(
            onClick = onChangeThemeClick,
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = if (isDarkTheme) Icons.Default.DarkMode else Icons.Default.WbSunny,
                contentDescription = stringResource(id = R.string.change_mode_icon),
                modifier = Modifier.size(AppTheme.dimensions.spaceLarge),
                tint = AppTheme.colors.primary
            )
        }

        IconButton(
            onClick = { uriHandler.openUri(APPLICATION_LINK) },
            modifier = Modifier.weight(1f)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = stringResource(id = R.string.rate_app_icon),
                modifier = Modifier.size(AppTheme.dimensions.spaceLarge),
                tint = AppTheme.colors.primary
            )
        }
    }
}