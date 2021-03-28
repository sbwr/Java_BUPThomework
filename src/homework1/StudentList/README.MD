定义一个StudentList类用来存储Student对象
属性有
1）Student[] list; //list存储学生对象
2）int total; //学生总人数
方法有：
1）StudentList(int length) //length是数组长度
2）boolean add(Student stu) //增加stu到数组中，成功，返回true，否则false
3）boolean remove(int no) //删除第no个数组元素，删除成功，返回true，否则false
4）boolean remove(String number) //删除学号为number的学生，删除成功，返回true，否则false
5）boolean isEmpty() //判断数组是否为空，若是，返回true，否则false
6）Student getItem(int no) //返回第no个学生
7）Student getItem(String number) //返回学号为number的学生，若该生不存在，返回null。
8) int getTotal() 返回学生总人数

编写StudentList类，并且编写一个StudentListTest类，对StudentList类进行测试。
StudentListTest类运行效果：
菜单如下，请输入 1~8代表您要执行的操作：
1.增加1个学生 2.根据学号删除学生 3.根据位置删除学生 4.判断是否为空 5.根据位置返回学生 6.根据学号返回学生 7.输出全部学生信息 8.退出程序

输入样例，每行表示一个操作，第一个元素为操作代码，之后的元素为操作需要用到的数据。具体参看样例。

添加操作，你需要输出当前所有学生信息，格式如下：
1 Students at the moment as described below:
Number:2011211301
Name:LiHang
Math:88
English:79
Science:90
Ave:85.67

查询操作，若有该学生，则输出其信息：
Student Info:
Number:2011211311
Name:WangZhe
Math:80
English:79
Science:93
Ave:84.00
否则，输出：
No such student

删除操作，若有学生，输出：
Remove successfully
1 Students at the moment as described below:
Number:2011211301
Name:LiHang
Math:88
English:79
Science:90
Ave:85.67
若不存在该学生，输出：
No such student
