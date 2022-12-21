import numpy as np
import math

def encrypt(pt,key,lnk):
    val = math.ceil(len(pt)/lnk)
    mat = [["_" for _ in range(lnk)] for _ in range(val)]
    k=0
    n=len(pt)
    for i in range(val):
        for j in range(lnk):
            if k==n:
                break
            else: mat[i][j]=pt[k]
            k+=1
    
    mat = np.array(mat)
    index = [key.find(i) for i in sorted(key)]
    ct=""
    for i in index:
        ct+="".join(mat[::,i])
    return ct

def decrypt(ct,key,lnk):
    val = math.ceil(len(ct)/lnk)
    mat = [["_" for _ in range(lnk)] for _ in range(val)]
    indices = [key.find(i) for i in sorted(key)]
    i=0
    index =0
    n= len(ct)
    while index<n:
        col_ele = ct[index : index+val]
        col = indices[i]
        for row in range(val):
            mat[row][col]=col_ele[row]
        i+=1
        index+=val
    pt=""
    for i in range(val):
        for j in range(lnk):
            if mat[i][j]!="_":
                pt+=mat[i][j]
    return pt
    
enc = encrypt("astha","HACK",4)
dec = decrypt(enc,"HACK",4)
print(enc,dec)
