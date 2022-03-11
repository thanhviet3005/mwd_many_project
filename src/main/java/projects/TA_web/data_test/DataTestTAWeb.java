package projects.TA_web.data_test;

import SSO_project.data_test.DataTestSSO;
import org.testng.annotations.DataProvider;

public class DataTestTAWeb extends DataTestSSO {
    // page 'Leave a message', form 'Leave a message'
    public String h5LeaveAMsg = "Leave a Message";
    public String labelFirstName = "First Name*";
    public String labelLastName = "Last Name*";
    public String labelEmail = "Email*";
    public String labelPhone = "Phone";
    public String labelQuestion = "Question/ Comment";
    public String inputAttachFile = "Attached Files";
    public String btnSendMsg = "Send Message";

    // page 'Leave a message', table 'Message history'
    public String divTableTitle = "Message History";
    public String thDate = "DATE SORTED ASCENDING";
    public String thMessage = "MESSAGE";
    public String thStatus = "STATUS";

    @DataProvider
    public Object[] getDataForFieldPhone() {
        Object[][] data = new Object[9][2];
        // row 1, the phone text is a empty text
        data[0][0] = empty_text;
        data[0][1] = "";
        // row 2, the phone text has some letters
        data[1][0] = phone_contain_text_char;
        data[1][1] = error_msg_phone_invalid_number;
        // row 3, the phone text has some special letters
        data[2][0] = phone_contain_special_char;
        data[2][1] = error_msg_phone_invalid_number;
        // row 4, the phone text is less than 10 numbers
        data[3][0] = phone_less_than_10_number;
        data[3][1] = error_msg_phone_short_or_too_long;
        // row 5, the phone text is greater than 15 numbers
        data[4][0] = phone_greater_than_15_numbers;
        data[4][1] = error_msg_phone_short_or_too_long;
        // row 6, the phone text is mistake format
        data[5][0] = phone_invalid_format;
        data[5][1] = error_msg_phone_invalid_number;
        // row 7, the phone text is valid numbers
        data[6][0] = valid_phone_1;
        data[6][1] = "";
        // row 8, the phone text is valid numbers
        data[7][0] = valid_phone_2;
        data[7][1] = "";
        // row 9, the phone text is valid numbers
        data[8][0] = phone_has_space_at_beginning_ending;
        data[8][1] = "";
        return data;
    }









}
