
import math

import numpy as np


def encrypt(pt,key,lenk):
    val = math.ceil(len(pt)/lenk)
    mat = [["_" for _ in range(len(key))]for _ in range(val)]
    k =0
    n = len(pt)
    for i in range(val):
        for j in range(lenk):
            if k==n:
                break
            else:
                mat[i][j]=pt[k]
            k+=1

    print(mat)
    mat = np.array(mat)
    index = [key.find(i) for i in sorted(key)]
    ct=""
    for i in index:
        ct+="".join(mat[::,i])
    return ct


def decrypt(ct,key,lenk):
    val = math.ceil(len(ct)/lenk)
    mat = [["_" for _ in range(len(key))]for _ in range(val)]
    index = 0
    indices = [key.find(i) for i in sorted(key)]
    n = len(ct)
    i = 0   
    while index<n:
        col_ele = ct[index : index+val]
        col = indices[i]
        for row in range(val):
            mat[row][col] = col_ele[row]
        i+=1
        index+=val
    pt=""
    for i in range(val):
        for j in range(len(key)):
            if(mat[i][j]!="_"):
                pt+=mat[i][j]
    return pt

ct = encrypt("astha","HACK",4)
print(ct)
print(decrypt(ct,"HACK",4))    
