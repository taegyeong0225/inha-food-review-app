import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private final MutableLiveData<Boolean> isLoggedIn = new MutableLiveData<>(false);

    public LiveData<Boolean> getIsLoggedIn() {
        return isLoggedIn;
    }

    public void logIn() {
        isLoggedIn.setValue(true);
    }

    public void logOut() {
        isLoggedIn.setValue(false);
    }
}
