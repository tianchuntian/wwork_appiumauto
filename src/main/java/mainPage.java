public class mainPage extends basePage {
    public dailySchedule toDailySchedule() {
        return new dailySchedule(driver);
    }

    public toDoPage toToDo() {
        //待办
        return new toDoPage(driver);

    }

}
