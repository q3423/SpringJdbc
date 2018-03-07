package com.lm.domain;

/**
 * @Title: Student
 * @Author:LiMan
 * @Date:2018/3/5 9:49
 * @Description:
 */

public class Student {
    private Long studentId;
    private String studentName;
    private Integer studentAge;
    private String gender;

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(Integer studentAge) {
        this.studentAge = studentAge;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentAge=" + studentAge +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Student() {
        super();
    }

    public Student(String studentName, Integer studentAge, String gender) {
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.gender = gender;
    }

    public Student(Long studentId, String studentName, Integer studentAge, String gender) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.gender = gender;
    }
}
