package project.superheroapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.superheroapp2.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(){
    lateinit var supLista: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Tag = javaClass.simpleName
        val service = APIservice.instance
        val repo = SupRepo(supService)
        val adapter = SupAdapter()

        repo.listarSuper {
            if (it != null) {
                Log.i(Tag, "Resultado = $it")
                adapter.listaSuper = it
                adapter.notifyDataSetChanged()
            }
        }
        supLista = supList
        supLista.layoutManager = LinearLayoutManager(this)
        supLista.adapter = adapter

    }
}
