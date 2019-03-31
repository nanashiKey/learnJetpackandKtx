package irfan.sampling.testjetpack.views.views_list

import android.app.Fragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
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
import irfan.sampling.testjetpack.views.views_detail.DetailAct
import kotlinx.android.synthetic.main.fragment_for_list_people.*
import kotlinx.android.synthetic.main.mainlayout.*


/**
 *   created by Irfan Assidiq on 3/30/19
 *   email : assidiq.irfan@gmail.com
 **/
class ListPeopleFragment : android.support.v4.app.Fragment(), ListPeopleAdapter.OnItemClickListener,
        SearchView.OnQueryTextListener,
        SearchView.OnCloseListener{

    private lateinit var searchView: SearchView
    private lateinit var viewModel : PeopleListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PeopleListViewModel::class.java)
    }

//    override fun onResume() {
//        super.onResume()
//
////        val people = (activity?.application as StartApp).getPeopleRepo().getAllPeple()
////        populatePeopleList(people)
//        val peopleRepo = (activity?.application as StartApp).getPeopleRepo()
//        peopleRepo.getAllPeple().observe(this, Observer {
//            peopleList -> populatePeopleList(peopleList!!)
//        })
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_for_list_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addFab.setOnClickListener {
            //            Toast.makeText(activity.applicationContext, "Test Add Data", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, AddPeopleData::class.java)
            startActivity(intent)
        }

        viewModel.getPeopleList().observe(this, Observer<List<People>> {
                peoples -> peoples?.let{
            populatePeopleList(peoples)
        }
        })
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
//        Toast.makeText(activity.applicationContext, "Test Click list data", Toast.LENGTH_SHORT).show()
        val detailsIntent = Intent(context, DetailAct::class.java)
        detailsIntent.putExtra(getString(R.string.people_id), people.id)
        startActivity(detailsIntent)
    }


    private fun populatePeopleList(peopleList: List<People>) {
        peopleRecyclerView.adapter = ListPeopleAdapter(peopleList, this)
    }

}