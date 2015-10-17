import com.notifiermobile.NotifierMobileService;
import com.notifiermobile.enums.NotificationType;
import com.notifiermobile.models.*;

import java.util.Date;

public class Tester {
    public static void main(String[] args) {
        Credential credential = new Credential("test", "123");
        String secretKey = NotifierMobileService.getSecretKey(credential);

        Authentication authentication = new Authentication("test", "123");
        NotifierMobileService.getAll(authentication);
        NotifierMobileService.get(9, authentication);

        Notification addModel = new Notification("eeeeeeeeee", "message", NotificationType.INFO.ordinal(), new Date());
        //addModel.setId(1);
        NotifierMobileService.add(addModel, authentication);

        Notification updateModel = new Notification();
        //addModel.setId(1);
        updateModel.setTitle("hahahahahahhahahaha");
        updateModel.setMessage("update");
        updateModel.setType(NotificationType.WARNING.ordinal());
        updateModel.setUnRead(true);
        NotifierMobileService.update(27, updateModel, authentication);

        NotifierMobileService.markAsRead(27, authentication);

        NotifierMobileService.delete(91, authentication);
    }
}
