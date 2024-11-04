dict={'天气':'多云','风向':'东南风','风力':'3级','最高温度':25,'最低温度':13}
print(dict)
dict['空气质量api']=50
dict['湿度']=78
print(dict)
dict['天气']='多云转阴天'
dict['风向']='西北风'
dict['风力']='5级'
print(dict)
del dict['湿度']
print(dict)
