package project.superheroapp

import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.superheroapp2.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){
    lateinit var supLista: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val Tag=javaClass.simpleName
        val service=APIservice.instance
        val repo=SupRepo(supService)
        val adapter=SupAdapter()

        repo.listarSuper {
            if (it != null){
                Log.i(Tag,"Resultado = $it")
                adapter.listaSuper=it
                adapter.notifyDataSetChanged()
            }
        }
        supLista=supList
        supLista.layoutManager=LinearLayoutManager(this)
        supLista.adapter=adapter
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_change_recycler_manager) {
            changeLayoutManager()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun receivedNewPhoto(newPhoto: ContactsContract.CommonDataKinds.Photo) {
        runOnUiThread {
            photosList.add(newPhoto)
            adapter.notifyItemInserted(photosList.size-1)
        }
    }
    private fun setRecyclerViewScrollListener() {
        supList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val totalItemCount = recyclerView.layoutManager!!.itemCount
                if (!imageRequester.isLoadingData && totalItemCount == lastVisibleItemPosition + 1) {
                    requestPhoto()
                }
            }
        })
    }
    private fun changeLayoutManager() {
        if (supList.layoutManager == linearLayoutManager) {
            supList.layoutManager = gridLayoutManager
            if (photosList.size == 1) {
                requestPhoto()
            }
        } else {
            supList.layoutManager = linearLayoutManager
        }
    }

    private fun setRecyclerViewItemTouchListener() {
        val itemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, viewHolder1: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {
                val position = viewHolder.adapterPosition
                photosList.removeAt(position)
                supList.adapter!!.notifyItemRemoved(position)
            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouchCallback)
        itemTouchHelper.attachToRecyclerView(supList)
    }
}
