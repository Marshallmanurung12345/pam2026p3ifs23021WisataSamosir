package org.delcom.pam_2026_p3_ifs23021_wisatasamosir.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColors = lightColorScheme(
    primary = TobaBlue,
    onPrimary = Color.White,

    secondary = SamosirGreen,
    onSecondary = Color.White,

    tertiary = SamosirAmber,
    onTertiary = Color.Black,

    background = LightBg,
    onBackground = Color(0xFF0F172A),

    surface = LightSurface,
    onSurface = Color(0xFF0F172A),

    surfaceVariant = Color(0xFFE9F2FB),
    onSurfaceVariant = Color(0xFF1F2A37),

    outline = Color(0xFFCBD5E1)
)

private val DarkColors = darkColorScheme(
    primary = TobaBlueLight,
    onPrimary = Color(0xFF061627),

    secondary = Color(0xFF7DE2B3),   // versi terang hijau
    onSecondary = Color(0xFF061627),

    tertiary = SamosirSand,
    onTertiary = Color(0xFF061627),

    background = DarkBg,
    onBackground = Color(0xFFE5E7EB),

    surface = DarkSurface,
    onSurface = Color(0xFFE5E7EB),

    surfaceVariant = Color(0xFF16233A),
    onSurfaceVariant = Color(0xFFCBD5E1),

    outline = Color(0xFF334155)
)

@Composable
fun WisataSamosirTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography,
        content = content
    )
}