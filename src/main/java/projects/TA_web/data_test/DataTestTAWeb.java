package projects.TA_web.data_test;

import SSO_project.data_test.DataTestSSO;
import SSO_project.entity.UserAccount;
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

    // page 'Change password'
    public String h1TitleChangePassword = "Change Password";
    public String labelPassword = "Password*";
    public String labelNewPassword = "New password*";
    public String labelConfirmPw = "Confirm new password*";
    public String placeholderTextForPw = "Please enter your password";
    public String placeholderTextForNewPw = "Please enter your new password";
    public String placeholderTextForConfirmPw = "Please confirm your new password";
    public String btnSubmit = "Submit";
    public String btnCancel = "Cancel";

    public UserAccount inactivated_SSO_account_for_server_23 = new UserAccount("internal testing only", "please ignored",
            "qatesting116@yopmail.com", "pass-02468", "pass-02468", "Logigear Test",
            "Logigear Test", "Uganda", "Abim", "0909999990");

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

    // the maximum number of columns of an 2 ways array is 4
    @DataProvider
    public Object[] getDataToCheckChangePwPage() {
        Object[][] data = new Object[11][4];
        // row 1, the password text is empty    -> ok
        data[0][0] = inactivated_SSO_account_for_server_23;
        data[0][1] = empty_text;
        data[0][2] = empty_text;
        data[0][3] = error_msg_empty_field;
        // row 2, the password text is only numbers     -> ok
        data[1][0] = inactivated_SSO_account_for_server_23;
        data[1][1] = pw_only_number;
        data[1][2] = pw_only_number;
        data[1][3] = error_msg_message_pw;
        // row 3, the password text is only letters     -> ok
        data[2][0] = inactivated_SSO_account_for_server_23;
        data[2][1] = pw_only_string;
        data[2][2] = pw_only_string;
        data[2][3] = error_msg_message_pw;
        // row 4, the password text is less than 8 characters   -> ok
        data[3][0] = inactivated_SSO_account_for_server_23;
        data[3][1] = pw_not_enough_length;
        data[3][2] = pw_not_enough_length;
        data[3][3] = error_msg_short_Pw;
        // row 5, the password text is valid and it consist a large number of special letters   -> ok
        data[4][0] = inactivated_SSO_account_for_server_23;
        data[4][1] = pw_contain_special_char;
        data[4][2] = pw_contain_special_char;
        data[4][3] = error_msg_message_pw;
        // row 6, the password text consists a/a few white space letters between other letters  -> ok
        data[5][0] = inactivated_SSO_account_for_server_23;
        data[5][1] = pw_has_whitespace;
        data[5][2] = pw_has_whitespace;
        data[5][3] = error_msg_message_pw;
        // row 7, the password text is valid and it consist a large number of special letters
        data[6][0] = inactivated_SSO_account_for_server_23;
        data[6][1] = pw_valid_strong;
        data[6][2] = pw_valid_strong;
        data[6][3] = empty_text;
        // row 8, new password, confirm password are same as the current password
        data[7][0] = inactivated_SSO_account_for_server_23;
        data[7][1] = activated_SSO_account.getPassword();
        data[7][2] = activated_SSO_account.getPassword();
        data[7][3] = error_msg_same_pw;
        // row 9, new password, confirm password are greater than 100 letters
        data[8][0] = inactivated_SSO_account_for_server_23;
        data[8][1] = pw_is_over_128_letters;
        data[8][2] = pw_is_over_128_letters;
        data[8][3] = empty_text;
        // row 10, new password, confirm password differences
        data[9][0] = inactivated_SSO_account_for_server_23;
        data[9][1] = pw_valid_strong;
        data[9][2] = pw_activated_strong;
        data[9][3] = error_msg_confirm_pw;
        // row 11, the current password is wrong
        data[10][0] = inactivated_SSO_account_for_server_23;
        data[10][1] = pw_valid_strong;
        data[10][2] = pw_valid_strong;
        data[10][3] = error_msg_current_pw_wrong;
        return data;
    }








}
