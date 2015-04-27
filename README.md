#Hierarchy Viewer

Hierarchy Viewer is a library which allows to display views tree of your application in the simple way on your **Gooogle Chrome** browser.
##How to use?


###Download

Via gradle. In main build.gradle :

```gradle
allprojects {
    repositories {
        ...
        maven {
            url "https://oss.sonatype.org/content/repositories/snapshots"
        }
    }
}
```

Add library:

```gradle
compile 'com.polidea:hierarchyviewer:1.0.0-SNAPSHOT'
```
or Maven. Add plugin repository:

```xml
<pluginRepository>
    <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
    <snapshots>
        <enabled>true</enabled>
    </snapshots>
</pluginRepository>
```

Add library:

```xml
<dependency>
  <groupId>com.polidea</groupId>
  <artifactId>hierarchyviewer</artifactId>
  <version>1.0.0-SNAPSHOT</version>
</dependency>
```

**It is a stable version of library**

###In code

If you want to just display your views tree - without your custom values or your custom views - you have to call the  `` start(Context)`` static method from ``HierarchyViewer class``, in the ``onCreate()`` method in your application object as is shown in the code below:
```java
public class YourApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HierarchyViewer.start(this);
    }
}
```
If you create your custom view and you want to display some custom values for your view you have to implement your own model for this view which extends from model correspondent for view.

For example:

 You created you own ``MyTextView`` which contains members ``superHint`` as is shown in the code below:

```java
public class MyTextView extends TextView {
    private String supperHint;
    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        supperHint = "Default super hint";
    }
    
    public void setSupperHint(String supperHint){
        this.supperHint = supperHint;
    }
    public String getSupperHint() {
        return supperHint;
    }
}
```
If you want to display ``superHint`` value you have to create ``ViewModelInfor`` which extends ``TextViewModelInfo`` *(if you extended view which is not supported by* **Hierarchy View Library** *you can extends* ``ViewModelInfo``*)*  as is shown in the code below:
 ```java
public class MyTextViewModelInfo extends TextViewModelInfo {
    @SerializedName("my_custom_item_value")
    String myCustomItem;
    
    @Override
    public void setDataFromView(View view, ConvertersContainer convertersContainer) {
        super.setDataFromView(view, convertersContainer);
        myCustomItem = ((MyTextView) view).getSupperHint();
    }
}
```
Now you have to add your view model info for confing which is passed as param for **Hierarchy Viewer Library** as is shown in the code below:

```java
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Config config = new Config.Builder()
            .add(MyTextView.class, new MyTextViewModelInfo())
            .build();
        HierarchyViewer.start(this, config);
    }
}
```

Your value will be displayed in properties table as **MY_CUSTOM_ITEM_VALUE**.

###Using
When you run your applicaiton you will see notification which will inform you about server ip address. **Imporatnt! Your computer has to be in the same network as your device**.

![notification](https://github.com/Polidea/android-hierarchy-viewer/blob/master/doc/screenshot/notification.png)


When you will open link in your browser you wil see infromation about your views tree.**Imporatnt! This works only on Google Chrome**.

![web](https://github.com/Polidea/android-hierarchy-viewer/blob/master/doc/screenshot/web_screen_shot.png)

##Main Contributors

**Polidea developers**
* Paweł Janeczek
* Piotr Dubiel
* Konrad Krakowiak

##Polidea

[Visit our side](https://www.polidea.com)

##Used libraries

* **[Polymer]** https://www.polymer-project.org
* **[dagger 2]** https://github.com/google/dagger
* **[Gson]** https://github.com/google/gson
* **[nanohttpd]** https://github.com/NanoHttpd/nanohttpd
* **[android support library v4 v7]** 
* **[javax annotation]**

##License

[LICENSE](https://github.com/Polidea/android-hierarchy-viewer/blob/master/LICENSE)



