def bmi(h,w):
    bmiNum=w/(h*h)
    bmiStr="BMI"
    advice="健康建议："
    match bmiNum:
        case <18.5:
            bmiStr=bmiStr+"小于18.5（偏瘦）："
            advice=advice+"增加体重，通过健康饮食和适当的运动来增加肌肉质量。"
        case <25:
            bmiStr=bmiStr+"18.5到24.9（正常范围）："
            advice=advice+"保持健康的生活方式，包括均衡饮食和适度的运动，以维持体重在正常范围内。"
        case <30:
            bmiStr=bmiStr+"25.0到29.9（超重）："
            advice=advice+"控制饮食，适度增加体育锻炼，以减轻体重并改善健康。"
        case _: 
            bmiStr=bmiStr+"30.0及以上（肥胖）："
            advice=advice+"采取积极的减重措施，包括合理饮食、增加运动、寻求专业医疗建议，以降低肥胖对健康的风险。"
    print(bmiStr)
    print(advice)

h=float(input("请输入身高（米）："))
w=float(input("请输入体重（公斤）："))
bmi(h,w)
