package irfan.sampling.testjetpack.views.views_detail

import android.app.Fragment
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import irfan.sampling.testjetpack.R
import irfan.sampling.testjetpack.StartApp
import irfan.sampling.testjetpack.data.data_model.People
import kotlinx.android.synthetic.main.fragment_people_details.*


/**
 *   created by Irfan Assidiq on 3/30/19
 *   email : assidiq.irfan@gmail.com
 **/
class DetailFragment : android.support.v4.app.Fragment() {

    private lateinit var viewModel: PeopleDetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PeopleDetailsViewModel::class.java)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_people_details,
            container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val peopleId = activity?.intent?.getIntExtra(getString(R.string.people_id), 0)
        peopleId?.let {
//            val peopleDetails = (activity?.application as StartApp)
//                .getPeopleRepo().findPeople(peopleId)
//            populatePeopleDetails(peopleDetails)
            viewModel.getPeopleDetails(peopleId).observe(this,
                Observer {
                    peopleDetails -> populatePeopleDetails(peopleDetails)
                })
        }
    }
    /**
     * Binds people info into views
     */
    private fun populatePeopleDetails(people: People?) {
        textViewName.text = people?.name
        textViewMet.text = people?.metAt
        buttonContact.text = people?.contact
        textViewEmail.text = people?.email
        textViewFacebook.text = people?.facebook
        textViewTwitter.text = people?.twitter
    }
}