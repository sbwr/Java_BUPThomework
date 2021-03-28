作业一：学生类
Main.java可直接通过oj，祝你好运
定义一个学生类（Student），
属性有
非静态属性String studentNumber
非静态属性String studentName
非静态属性int markForMaths
非静态属性int markForEnglish
非静态属性int markForScience
方法有：
构造方法Student(String number, String name)
构造方法Student()
String getNumber()
String getName()
void enterMarks(int markForMaths, int markForEnglish, int markForScience)
int getMathsMark()
int getEnglishMark()
int getScienceMark()
double calculateAverage()
String toString() 返回学生信息，包括学号、姓名、数学成绩、英语成绩、科学成绩、平均成绩。

注意：为了保证calculateAverage返回double类型，需要把三个分数的和除以3.0，而不是3.
另外，分数的初始值是什么？如果每个分数初始值为0，会造成混淆，分数为0表示还没有输入分数，还是分数确实为0？有更好的初始值吗？

编写Student类，并且编写一个StudentTest类，对Student类进行测试。每一个测试用例包含 number, name, maths, english, science 5种数据，用StudentTest类读取数据，并用数据构造Student类，最终打印学生信息。
StudentTest类运行效果如下：
2011211301 WangXiao 88 79 90
Student Info:
Number:2011211301
Name:WangXiao
Math:88
English:79
Science:90
Ave:85.67
