package Activities;

public class HealthRecord {
    private String studentName;
    private String bloodType;
    private String rhFactor;
    
    public void HealthRecordSys (String studentName, String bloodType, String rhFactor) {
        studentName = this.studentName;
        bloodType = this.bloodType;
        rhFactor = this.rhFactor;
    }
    
    public void setStudentName (String studentName) {
        this.studentName = studentName;
    }
    
    public void setBloodType (String bloodType) {
        this.bloodType = bloodType;
    }
    
    public void setRhFactor (String rhFactor) {
        this.rhFactor = rhFactor;
    }
    
    public String getStudentName() {
        return studentName;
    }
    
    public String getBloodType() {
        return bloodType;
    }
    
    public String getRhFactor() {
        return rhFactor;
    }
    
    public void displayInfo() {
        System.out.println("Student Name:       " + studentName);
        System.out.println("Blood Type:         " + bloodType);
        System.out.println("Rh Factor:          " + rhFactor);
    }
}