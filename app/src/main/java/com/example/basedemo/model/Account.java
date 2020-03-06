package com.example.basedemo.model;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.PropertyResourceBundle;

import androidx.room.Entity;

@Entity
public class Account implements Parcelable
{
    public static Account getInstance()
    {
        return new Account();
    }

    private String name;
    private int age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.name);
        dest.writeInt(this.age);
    }

    public Account()
    {
    }

    protected Account(Parcel in)
    {
        this.name = in.readString();
        this.age = in.readInt();
    }

    public static final Parcelable.Creator<Account> CREATOR = new Parcelable.Creator<Account>()
    {
        @Override
        public Account createFromParcel(Parcel source)
        {
            return new Account(source);
        }

        @Override
        public Account[] newArray(int size)
        {
            return new Account[size];
        }
    };
}
