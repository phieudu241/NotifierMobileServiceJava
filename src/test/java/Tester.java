import com.notifiermobile.NotifierMobileService;
import com.notifiermobile.enums.NotificationType;
import com.notifiermobile.models.*;

import java.util.Date;

public class Tester {
    public static void main(String[] args) {
        Credential credential = new Credential("test", "123");
        //String secretKey = NotifierMobileService.getSecretKey(credential);

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
        updateModel.setType(NotificationType.WARNING.ordinal());
        updateModel.setUnRead(true);
        NotifierMobileService.update(21, authentication, updateModel);

        //NotifierMobileService.delete(30, authentication);

        NotifierMobileService.markAsRead(27, authentication);
    }
}
