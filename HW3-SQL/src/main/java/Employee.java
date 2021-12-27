public class Employee {

    private int employeeID;
    private String person_name;
    private String occupation;
    private String working_date;
    private int workind_hours;


    public Employee(int employeeID, String person_name, String occupation, String working_date, int workind_hours) {
        this.employeeID = employeeID;
        this.person_name = person_name;
        this.occupation = occupation;
        this.working_date = working_date;
        this.workind_hours = workind_hours;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeID=" + employeeID +
                ", person_name='" + person_name + '\'' +
                ", occupation='" + occupation + '\'' +
                ", working_date='" + working_date + '\'' +
                ", workind_hours=" + workind_hours +
                '}';
    }
}
