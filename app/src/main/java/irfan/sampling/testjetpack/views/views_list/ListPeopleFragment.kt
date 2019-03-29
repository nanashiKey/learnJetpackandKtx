package irfan.sampling.testjetpack.views.views_list

import android.app.Fragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import android.widget.Toast
import irfan.sampling.testjetpack.R
import irfan.sampling.testjetpack.StartApp
import irfan.sampling.testjetpack.data.data_model.People
import irfan.sampling.testjetpack.views.views_add.AddPeopleData
import kotlinx.android.synthetic.main.fragment_for_list_people.*
import kotlinx.android.synthetic.main.mainlayout.*


/**
 *   created by Irfan Assidiq on 3/30/19
 *   email : assidiq.irfan@gmail.com
 **/
class ListPeopleFragment : Fragment(), ListPeopleAdapter.OnItemClickListener,
        SearchView.OnQueryTextListener,
        SearchView.OnCloseListener{

    private lateinit var searchView: SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onResume() {
        super.onResume()

        val people = (activity?.application as StartApp).getPeopleRepo().getAllPeple()
        populatePeopleList(people)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_for_list_people, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFab.setOnClickListener {
//            Toast.makeText(activity.applicationContext, "Test Add Data", Toast.LENGTH_SHORT).show()
        val intent = Intent(activity.applicationContext, AddPeopleData::class.java)
        startActivity(intent)
        }

    }


    override fun onQueryTextSubmit(query: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClose(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemClick(people: People, itemView: View) {
        Toast.makeText(activity.applicationContext, "Test Click list data",
            Toast.LENGTH_SHORT).show()
    }


    private fun populatePeopleList(peopleList: List<People>) {
        peopleRecyclerView.adapter = ListPeopleAdapter(peopleList, this)
    }

}