package app.entity;

import java.io.Serializable;

public class Certificate implements Serializable {

    private int id;
    private int patientId;
    private String dateRelease;
    private String dateFrom;
    private String dateTo;
    private int type;
    private int code;

    public Certificate(int id, int patientId, String dateRelease, String dateFrom, String dateTo, int type, int code) {
        this.id = id;
        this.patientId = patientId;
        this.dateRelease = dateRelease;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.type = type;
        this.code = code;
    }

    public void setId(int id) { this.id = id; }
    public int getId() { return this.id; }

    public void setPatientId(int userId) { this.patientId = patientId; }
    public int setPatientId() { return this.patientId; }

    public void setDateRelease(String dateRelease) { this.dateRelease = dateRelease; }
    public String getDateRelease() { return this.dateRelease; }

    public void setDateFrom(String dateFrom) { this.dateFrom = dateFrom; }
    public String getDateFrom() { return this.dateFrom; }

    public void setDateTo(String pesel) { this.dateTo = dateTo; }
    public String getDateTo() { return this.dateTo; }

    public void setType(int type) { this.type = type; }
    public int getType() { return this.type; }

    public void setCode(int code) { this.code = code; }
    public int getCode() { return this.code; }
}