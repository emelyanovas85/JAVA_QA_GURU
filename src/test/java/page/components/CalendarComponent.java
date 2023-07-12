package page.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setData(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(".react-datepicker__day--0" + day + ":not(react-datepicker__day--outside-month)").click();
    }
}



//        $("#dateOfBirthInput").click();
//        //        $(".react-datepicker__month-select").click();
////        $(byText("October")).click();
//        $(".react-datepicker__month-select").selectOption("October");
//        $(".react-datepicker__month-select").selectOptionByValue("10");
//        $(".react-datepicker__year-select").click();
//        $(byText("1985")).click();
//        //        $(by("aria-label", "Choose Saturday, October 5th, 1985")).click();
//        $(".react-datepicker__day--001:not(react-datepicker__day--outside-month)").click();
////        $x("//*[@class=react-datepicker__day--001][:not(contains(@class, 'react-datepicker__day--outside-month'))]").click();


