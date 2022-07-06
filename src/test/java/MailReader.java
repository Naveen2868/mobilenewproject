import javax.mail.*;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MailReader {

    String hostName = "smtp.gmail.com";
    String username = "naveenreddyaleti@gmail.com";
    String password = "naveen@123!";
    int messageCount;
    int unreadMsgCount;
    String emailSubject;
    Message emailMessage;

    public static void main(String args[]){
        MailReader mailReader = new MailReader();
        mailReader.mailReader();
    }

    public void mailReader() {
        Properties sysProps = System.getProperties();
        sysProps.setProperty("mail.store.protocol", "imaps");

        try {
            Session session = Session.getInstance(sysProps, null);
            Store store = session.getStore();
            store.connect(hostName, username, password);
            Folder emailInbox = store.getFolder("INBOX");
            emailInbox.open(Folder.READ_WRITE);
            messageCount = emailInbox.getMessageCount();
            System.out.println("Total Message Count: " + messageCount);
            unreadMsgCount = emailInbox.getNewMessageCount();
            System.out.println("Unread Emails count:" + unreadMsgCount);
            emailMessage = emailInbox.getMessage(messageCount);
            System.out.println(emailMessage);
            emailSubject = emailMessage.getSubject();
            System.out.println(emailSubject);

            Pattern linkPattern = Pattern.compile("[0-9]"); // here you need to define regex as per you need
            Matcher pageMatcher =
                    linkPattern.matcher(emailMessage.getContent().toString());

            while (pageMatcher.find()) {
                System.out.println("Found OTP " + pageMatcher.group(1));
            }
            emailMessage.setFlag(Flags.Flag.SEEN, true);
            emailInbox.close(true);
            store.close();

        } catch (Exception mex) {
            mex.printStackTrace();
        }
    }



}
