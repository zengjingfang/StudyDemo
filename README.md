# StudyDemo
学习使用，只有敲过了，才会明白

## Fragment学习
- Fragment静态添加

    
		<LinearLayout
	    xmlns:android="http://schemas.android.com/apk/res/android"
	    xmlns:tools="http://schemas.android.com/tools"
	    android:layout_width="match_parent"
	    android:layout_height="match_parent"
	    android:orientation="horizontal">
	
	    <fragment
	        android:id="@+id/main_left_fragment"
	        android:name="com.zjf.studydemo.fragment.LeftFragment"
	        android:layout_width="0dp"
	        android:layout_height="match_parent"
	        android:layout_weight="2"
	        tools:layout="@layout/left_fragment">
	    </fragment>
	
	
	    <fragment
	        android:id="@+id/main_right_fragment"
	        android:name="com.zjf.studydemo.fragment.RightFragment"
	        android:layout_width="0dp"
	        android:layout_height="match_parent"
	        android:layout_weight="5"
	        tools:layout="@layout/right_fragment"/>

	

- Fragment动态添加

      			Fragment anotherRightFragment = new AnotherRightFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                /*开启一个事务*/
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                /*向容器内添加碎片*/
                fragmentTransaction.add(R.id.main_right_Fragment_layout, anotherRightFragment, "anotherRight");
                /*添加一个反回栈*/
                fragmentTransaction.addToBackStack(null);
                /*提交事务*/
                fragmentTransaction.commit();



- Fragment实践项目news