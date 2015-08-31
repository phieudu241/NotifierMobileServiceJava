import com.notifiermobile.NotifierMobileService;
import com.notifiermobile.models.*;

import java.util.Date;

public class Tester {
    public static void main(String[] args) {
        Authentication authentication = new Authentication("test", "123");
        NotifierMobileService.getAll(authentication);
        NotifierMobileService.get(9, authentication);

        AddModel addModel = new AddModel();
        addModel.setTitle("title");
        addModel.setMessage("message");
        addModel.setCreateDate(new Date());
        NotifierMobileService.add(authentication, addModel);

        UpdateModel updateModel = new UpdateModel();
        updateModel.setTitle("title");
        updateModel.setMessage("update");
        updateModel.setType(2);
        updateModel.setUnRead(true);
        NotifierMobileService.update(21, authentication, updateModel);

        NotifierMobileService.delete(30, authentication);

        NotifierMobileService.markAsRead(27, authentication);
    }
}
