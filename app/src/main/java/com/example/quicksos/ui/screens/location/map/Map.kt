
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.quicksos.ui.theme.QuickSOSTheme
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

@Composable
fun MapView() {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            val map = MapView(context)
            map.setTileSource(TileSourceFactory.DEFAULT_TILE_SOURCE)
            map.setMultiTouchControls(true)

            //map controller
            val mapController = map.controller
            mapController.setZoom(20.0)
            val startPoint = GeoPoint(47.583914, -122.150077);
            mapController.setCenter(startPoint);

            map
        }
    )
}

@Composable
fun MapCompose(modifier: Modifier = Modifier) {
    // A surface container using the 'background' color from the theme
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
            .height(300.dp)
            .padding(vertical = 8.dp)
    ) {
        MapView()
    }
}

@Preview(showBackground = true)
@Composable
fun MapViewPreview() {
    QuickSOSTheme {
        MapCompose()
    }
}