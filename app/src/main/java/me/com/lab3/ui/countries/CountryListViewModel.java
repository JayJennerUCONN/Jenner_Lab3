package me.com.lab3.ui.countries;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import me.com.lab3.model.Country;

public class CountryListViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<ArrayList<Country>> countryList;
    public CountryListViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is countries fragment");

        countryList = new MutableLiveData<>();
        countryList.setValue(new ArrayList<>());

    }

    public void addCountryList(ArrayList<Country> myCountryList){
        countryList.postValue(myCountryList);
    }
    public LiveData<String> getText() {
        return mText;
    }
}