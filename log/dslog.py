import random
import time
iplist=[26,23,47,56,108,10,33,48,66,77,101,45,61,52,88,89,108,191,65,177,98,21,34,61,19,11,112,114]

url = "http://mystore.jsp/?productid={query}"
x=[1,2,3,4]

def use_id():
    return random.randint(1,20)
def get_ip():
    return '.'.join(str(x) for x in random.sample(iplist,4))

def urllist():
    if random.uniform(0,1)>0.7:
        return ""

    query_str=random.sample(x,1)
    return url.format(query=query_str[0])

def get_time():
    return time.strftime('%Y%m%d%H%M%S',time.localtime())

#  action: 1 收藏，2 加购物车，3 购买  area_id代表不同区域
def action():
    return random.randint(1,4)

def area_id():
    return random.randint(1,21)

def get_log(count):
    while count>0:
        log='{},{},{},{},{},{}\n'.format(use_id(),get_ip(),urllist(),get_time(),action(),area_id())
        # with open('/usr/local/src/tmp/1.log','a+')as file:
        with open('data/1.log','a+')as file:
            file.write(log)
        # print(log)
        # time.sleep(1)
        count=count-1
if __name__ == '__main__':
    get_log(1000)
