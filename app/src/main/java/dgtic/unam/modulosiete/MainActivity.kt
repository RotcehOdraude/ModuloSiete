package dgtic.unam.modulosiete

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var drawer: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inicioToolsBar()
    }

    private fun inicioToolsBar(){
        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)
        drawer = findViewById(R.id.drawer_layout)
        val toggle = ActionBarDrawerToggle(this, drawer,toolbar,R.string.abrir,R.string.cerrar)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        toolbar.setNavigationIcon(R.drawable.unam_32)
        iniciarNavegacionView()
    }
    private fun iniciarNavegacionView(){
        val navegacionView: NavigationView =findViewById(R.id.nav_view)
        navegacionView.setNavigationItemSelectedListener(this)
        val headerView: View = LayoutInflater.from(this).inflate(R.layout.header_main,
            navegacionView,false)
        navegacionView.addHeaderView(headerView)
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.contraint_layout -> { //Práctica 2
                startActivity(Intent(this,ConstraintActivity::class.java))
            }
            R.id.nestedscrollview -> { //Práctica 3
                startActivity(Intent(this,NestedScrollView::class.java))
            }
            R.id.collapsing -> { //Práctica 4
                startActivity(Intent(this,CollapsingToolbarLayout::class.java))
            }
            R.id.reproduccionVideo -> { //Práctica 5 Reproduccion de video
                startActivity(Intent(this,Video::class.java))
            }
            R.id.reproduccionAudio -> { //Práctica 6 Reproducción de audio
                startActivity(Intent(this,Audio::class.java))
            }
            R.id.recyclerView -> { //Práctica 7 Recycler View
                startActivity(Intent(this,RecyclerView::class.java))
            }

        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}