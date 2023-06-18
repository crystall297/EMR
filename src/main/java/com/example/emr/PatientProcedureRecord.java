package com.example.emr;

public class PatientProcedureRecord implements Comparable<PatientProcedureRecord>{
    private String P_ic;
    private String procedure_code;
    private String procedure_date;
    private String procedure_description;
    private String procedure_price;

    //for the displaying proc table
    private String code;
    private String date;
    private String description;
    private String price;
    public static String filename = "patientProcedure.csv";
    public static String filename_fixedP = "fixedProcedures.csv";
    //PatientProcHandler pph = new PatientProcHandler;

public PatientProcedureRecord() {}
    //to pass into patient proc into the patientProc file
    public PatientProcedureRecord(String ic, String code, String date, String description, String price) {
        this.P_ic = ic;
        this.procedure_code = code;
        this.procedure_date = date;
        this.procedure_description = description;
        this.procedure_price = price;
    }

    //pass into the table in proc, to display specific data.
    public PatientProcedureRecord(String code, String date, String description, String price) {
        this.code = code;
        this.date = date;
        this.description = description;
        this.price = price;
    }

    public String getP_ic () {
        return P_ic;
    }

    public String getProcedure_code () {
        return procedure_code;
    }

    public void setProcedure_code (String code){
        this.procedure_code = code;
    }

    public String getProcedure_date () {
        return procedure_date;
    }

    public void setProcedure_date (String date){
        this.procedure_date = date;
    }

    public String getProcedure_description () {
        return procedure_description;
    }

    public void setProcedure_description (String description){
        this.procedure_description = description;
    }

    public String getProcedure_price () {
        return procedure_price;
    }

    public void setProcedure_price (String price){
        this.procedure_price = price;
    }

    public String getCode() {
        return code;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }
    @Override
    public int compareTo (PatientProcedureRecord o){
        if (getProcedure_date() == null || o.getProcedure_date() == null) {
            return 0;
        }
        return getProcedure_date().compareTo(o.procedure_date);
    }

    //might use the below if increment of proc_code needed, else standardize all code under 1 diagnosis code
    /*public int compare(PatientRecord a , PatientRecord b ){
        return a.p_Name.compareTo(b.p_Name);
    }
    }*/

}
