package com.deicos.magnolia.data;

/**
 * backoffice-magnolia
 * com.deicos.magnolia.data.company
 * Created by Alberto Soto Fernandez in 22/05/2017.
 * Description:
 */
public class Employee {
    String name;
    Double salary;
    String group;
    WorkerCategory level;

    public String getName() {
        return name;
    }

    public WorkerCategory getLevel() {
        return level;
    }

    public void setLevel(WorkerCategory level) {
        this.level = level;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
}
