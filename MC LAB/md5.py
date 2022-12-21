import hashlib

string = input('Enter string: ')
str = string.encode()
res = hashlib.md5(str)
res2 = hashlib.sha256(str)
print(res.hexdigest())
print(res2.hexdigest())