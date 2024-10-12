list=[int(input('请输入第%d个数：'%i))for i in range(1,11)]
s=sum(list)
print('10个数的和：%d'%(s))
ma=max(list);mi=min(list)
print('最大值：%d，最小值：%d'%(ma,mi))
s=s-ma-mi
print('其余8个数的平均值：%.2f'%(s/8))
