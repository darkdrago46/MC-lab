import numpy as np
import math

msg = input("Enter Message : ")
n = len(msg)
key = input(f"Enter key of size 3*3 : " )
 
def encrypt(msg , key ):
   keyA = np.array( [ ord(x) % 65 for x in key ] )
   keyA = np.reshape( keyA , (3,3) )
   print(keyA)
   msgA = [ ord(x) % 65 for x in msg ] 
   i=n
   while(i<(math.ceil(n/3)*3)):
    msgA.append(23)
    i+=1
   msgA = np.array(msgA)
   msgA = np.reshape(msgA, (math.ceil(n/3),3) )
   print(msgA)
 
   encryptedMsgA = np.dot( msgA,keyA ) %26
   print(encryptedMsgA)
   encryptedMsg = ""
   for i in encryptedMsgA:
        for j in range(3):
            encryptedMsg += chr( i[j] + 65 )
   return encryptedMsg
 

def egcd(a,b):
    t1,t2 = 0,1
    while(b != 0):
        q, r = a // b , a % b
        t = t1 - q*t2
        a,b , t1,t2 = b,r , t2,t
    return a , t1

def modinv(a, m):
   gcd, x = egcd(m, a)
   if gcd != 1:
       return None
   else:
       return x % m
       
 
def decrypt( msg , key ):
   keyA = np.array( [ ord(x) % 65 for x in key ] )
   keyA = np.reshape( keyA , (3,3) )
  
   msgA = np.array( [ ord(x) % 65 for x in msg ] )
   msgA = np.reshape(msgA, (math.ceil(n/3),3) )
 
   detInv = modinv( np.linalg.det(keyA) , 26 )
   keyInvA = np.linalg.inv(keyA) * np.linalg.det(keyA)
  
   keyInvA = np.round( ((keyInvA % 26 )* detInv)%26 )
   decA = np.dot(msgA,keyInvA ) % 26
   decA=(np.rint(decA)).astype(int)
   print(decA)
   dec = ""
   for i in decA:
        for j in range(3):
            if(i[j]!=23):
                dec += chr( i[j] + 65 )
 
   return dec
 
eMsg = encrypt(msg, key)
print( eMsg )
 
dMsg = decrypt(eMsg, key)
print(dMsg)