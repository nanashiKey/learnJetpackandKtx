package irfan.sampling.testjetpack.views.views_add

import android.app.Fragment
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import irfan.sampling.testjetpack.R
import irfan.sampling.testjetpack.StartApp
import irfan.sampling.testjetpack.data.data_model.People
import kotlinx.android.synthetic.main.fragment_add_people.*


/**
 *   created by Irfan Assidiq on 3/30/19
 *   email : assidiq.irfan@gmail.com
 **/
class FragmentAddPeople : android.support.v4.app.Fragment() {

    private lateinit var viewModel: AddPeopleViewModel

    lateinit var btn_ : Button;
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
       var view : View =  inflater.inflate(R.layout.fragment_add_people,
            container, false)
        btn_ = view.findViewById<Button>(R.id.btn_)

        return  view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddPeopleViewModel::class.java)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        btn_.setOnClickListener {
            savePeopleInfo()
        }
    }

    private fun savePeopleInfo(){
        val people = People(
            textInputName.editText?.text.toString(),
            textInputMetAt.editText?.text.toString(),
            textInputContact.editText?.text.toString(),
            textInputEmail.editText?.text.toString(),
            textInputFacebook.editText?.text.toString(),
            textInputTwitter.editText?.text.toString()
        )
        (activity?.application as StartApp).getPeopleRepo().insertingPeople(people)
        activity?.finish()
    }
}