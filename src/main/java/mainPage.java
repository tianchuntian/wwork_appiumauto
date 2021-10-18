public class mainPage extends basePage {
    public dailySchedulePage toDailySchedule() {
        click("日程");
        return new dailySchedulePage(driver);
    }

    public toDoPage toToDo() {
        //待办
        click("待办");
        return new toDoPage(driver);

    }

}
