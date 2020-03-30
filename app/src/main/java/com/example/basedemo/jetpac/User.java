package com.example.basedemo.jetpac;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.basedemo.BR;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

/**
 * Parcelable
 * 永久性保存对象
 * 通过序列化对象在网络中传递对象
 */

public class User extends BaseObservable implements Parcelable
{
    private String name;
    private int age;
    /**
     * 可观察的数据对象
     */
    public final ObservableField<String> nameOb = new ObservableField<>();
    public final ObservableInt ageOb = new ObservableInt();

    @Bindable
    public String getName()
    {
        notifyPropertyChanged(BR.name);
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

    public static Creator<User> getCREATOR()
    {
        return CREATOR;
    }

    /**
     * 描述
     * 返回的是内容的描述信息
     * 只针对一些特殊的需要描述信息的对象,需要返回1,其他情况返回0就可以
     *
     * @return
     */
    @Override
    public int describeContents()
    {
        return 0;
    }

    /**
     * 序列化
     *
     * @param dest
     * @param flags
     */
    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(this.name);
        dest.writeInt(this.age);
    }

    public User()
    {

    }

    public User(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    protected User(Parcel in)
    {
        this.name = in.readString();
        this.age = in.readInt();
    }

    //负责反序列化
    public static final Creator<User> CREATOR = new Creator<User>()
    {//从序列化对象中，获取原始的对象
        @Override
        public User createFromParcel(Parcel source)
        {
            return new User(source);
        }

        //创建指定长度的原始对象数组
        @Override
        public User[] newArray(int size)
        {
            return new User[size];
        }
    };
}
