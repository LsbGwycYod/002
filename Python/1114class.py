class Student:
    num=0
    sum_s=0
    max_s=0
    def __init__(self,name,score):
        self.name=name
        self.score=score
        Student.num=Student.num+1
        Student.sum_s=Student.sum_s + self.score
        Student.max_s=Student.max_s if Student.max_s>self.score else self.score

    @classmethod
    def average(cls):
        return Student.sum_s/Student.num
    @classmethod
    def max_score(cls):
        return Student.max_s
stu1=Student("zhangsan",98)
stu2=Student("lisi",96)
stu3=Student("wangwu",90)
print('%.2f'%Student.average())
print(Student.max_score())
