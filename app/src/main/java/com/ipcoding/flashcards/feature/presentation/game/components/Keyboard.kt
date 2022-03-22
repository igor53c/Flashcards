package com.ipcoding.flashcards.feature.presentation.game.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import com.ipcoding.flashcards.core.util.Constants
import com.ipcoding.flashcards.ui.theme.AppTheme
import com.ipcoding.flashcards.R

@Composable
fun Keyboard(
    maxWidth: Dp
) {
    Row(
        modifier = Modifier.height(maxWidth * 3 / 11)
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(3) { item1 ->
                LazyRow(modifier = Modifier) {
                    items(10) { item2 ->
                        val keyboardLetter = Constants.ALL_LETTERS[item1 * 10 + item2]

                        Box(
                            modifier = Modifier
                                .size(size = maxWidth / 11)
                                .padding(AppTheme.dimensions.spaceSuperSmall)
                                .clickable {  }
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize(),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = keyboardLetter,
                                    color = AppTheme.colors.primary,
                                    style = AppTheme.typography.h5
                                )
                            }
                        }
                    }
                }
            }
        }
        Box(
            modifier = Modifier
                .width(maxWidth / 11)
                .height(maxWidth * 3 / 11)
                .padding(AppTheme.dimensions.spaceSuperSmall)
                .clickable { }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        color = AppTheme.colors.primary,
                        shape = AppTheme.customShapes.roundedCornerShapeSmall
                    ),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Send,
                    contentDescription = stringResource(id = R.string.enter_icon),
                    tint = AppTheme.colors.background,
                    modifier = Modifier.padding(AppTheme.dimensions.spaceExtraSmall)
                )
            }
        }
    }
}