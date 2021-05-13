/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ni.edu.ni.prueba.pojo;

import java.util.Date;

/**
 *
 * @author Sistemas-02
 */
public class Empleado {
    /*
        contener id, nombre, apellidos, fecha contratacion, salaario x hora
    */
    private int ID;
    private String name;
    private String lastName;
    private int Date;
    private int Hours;
    private float SalaryperHour;
    
    private float SalaryBrute;
    private float inss;
    private float IR;
    private float Salary;
    private Date dateyear;
    
    public Empleado(int ID, String name, String lastName, int Date, float SalaryperHour, int Hours) {
        this.ID = ID;
        this.name = name;
        this.lastName = lastName;
        this.Date = Date;
        this.Hours = Hours;
        this.SalaryperHour = SalaryperHour;
    }
    
    public Empleado() {}

    public int getHours() {
        return Hours;
    }

    public void setHours(int Hours) {
        this.Hours = Hours;
    }

    public float getIR() {
        return IR;
    }

    public void setIR(float IR) {
        this.IR = IR;
    }
    
    
    
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int Date) {
        this.Date = Date;
    }

    public float getSalaryperHour() {
        return SalaryperHour;
    }

    public void setSalaryperHour(float SalaryperHour) {
        this.SalaryperHour = SalaryperHour;
    }
    
    public float calcSalaryB()
    {
        return  (SalaryperHour * Hours );
    }
    
    public float CalcINSS()
    {
        return  calcSalaryB() * 0.07f;
    }
    
    public float SalaryAnual()
    {
        return (calcSalaryB() - CalcINSS()) * 12;
    }
    
    public float CalcIR(float Exceso, float percent, float base)
    {
        setIR((((SalaryAnual() - Exceso) * percent) + base) / 12);
        return (((SalaryAnual() - Exceso) * percent) + base) / 12;
    }
    
    public float SalarioNeto()
    {
        return (calcSalaryB() - CalcINSS() - 10 /*CalcIR()*/);    
    }
    
    public int calcAntiquity()
    {
        return (2021 - Date); //dateyear.getYear();
    }
    
    public float options()
    {
        float a = 0.0f;
        if (SalaryAnual() < 200000 && SalaryAnual() > 100000.01)
            a = CalcIR(0, 0.15f, 100000);
        
        if (SalaryAnual() < 350000 && SalaryAnual() > 200000.01)
            a = CalcIR(15000, 0.20f, 200000);
        
        if (SalaryAnual() < 500000 && SalaryAnual() > 350000.01)
            a = CalcIR(45000, 0.25f, 350000);
        
        if (SalaryAnual() > 500000.01)
            a = CalcIR(82500, 0.30f, 500000);
        return a;
    }
    
    public Object[] asArray()
    {
        Object[] obj = new Object[6];
        obj[0] = name;
        obj[1] =  calcSalaryB();
        obj[2] = CalcINSS();
        obj[3] = options();
        obj[4] = calcAntiquity();
        obj[5] = SalarioNeto();
        return obj;
    }
    
}
