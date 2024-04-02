package org.example.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Person {
    @SerializedName("id")
    private long personId;
    private String firstName;
    private String lastName;
    private int age;
    private static long id = 0L;
    private static final List<Person> persons = new ArrayList<>();

    public Person() {
    }


    public Person(String firstName, String lastName, int age) {
        this.personId = ++id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;

        persons.add(this);
    }

    /**
     * Generates String of current instance using library apache-commons-lang3
     *
     * @return String representation of current instance
     * @see Person#toString()
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.NO_CLASS_NAME_STYLE)
                .append(personId)
                .append(firstName)
                .append(lastName)
                .append(age)
                .toString();
    }

    /**
     * Compares another object to the current one using library apache-commons-lang3
     *
     * @param object - another object to compare
     * @return true/false
     * @see Person#equals(Object)
     */
    @Override
    public boolean equals(Object object) {
        return EqualsBuilder.reflectionEquals(this, object);
    }

    /**
     * Computes hash-code of current instance using library apache-commons-lang3
     *
     * @return int value of hash code
     * @see Person#hashCode()
     */
    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    /**
     * Converts a list of Person instances into GSON string format
     *
     * @param persons - list of Person instances
     * @return GSON formatted string
     * @see Person#personsToJSON(List)
     */
    public static String personsToJSON(List<Person> persons) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        return gson.toJson(persons);
    }

    /**
     * Converts a list of Person instances into GSON string format
     *
     * @param gsonString - GSON-formatted string of persons
     * @return list of Person instances
     * @see Person#personsFromJSON(String)
     */
    public static List<Person> personsFromJSON(String gsonString) {
        Type listOfPersonObject = new TypeToken<ArrayList<Person>>() {
        }.getType();
        return new Gson().fromJson(gsonString, listOfPersonObject);
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getPersonId() {
        return personId;
    }

    public static List<Person> getPersons() {
        return persons;
    }


}
