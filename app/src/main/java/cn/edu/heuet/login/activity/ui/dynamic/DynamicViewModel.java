package cn.edu.heuet.login.activity.ui.dynamic;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DynamicViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DynamicViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}