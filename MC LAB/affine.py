def encrypt(s,a,b):
    y=""
    for c in s:
        if(c!=' '):
            y+= chr((a * (ord(c)-97) + b) % 26 + 97)
        else: y+=' '
    return y


def decrypt(s,a,b):
    y=""
    for i in range(26):
        flag= (a*i)%26
        if flag==1:
            x=i  #x=a-1
    for c in s:
        if(c!=' '):
            y+= chr((((ord(c)-97-b) * x)) % 26 + 97)
        else: y+=' '
    return y

def modinv(val):
    for i in range(26):
        if (val*i)%26==1:
            return i
    return -1

def attack(ct,pt):
    for b in range(1,26):
        for a in range(1,26):
            p=""
            if modinv(a)!=-1:
                ainv = modinv(a)
                for c in ct:
                    p+=chr(((ord(c)-97-b)*ainv)%26 +97)
                if p==pt:
                    print(a,b)


pt = input('\nEnter plain text:')
ct = encrypt(pt,3,6)
print('Cipher Text: '+ct)
p = decrypt(ct,3,6)
print('Plain Text after decryption: '+p)
attack(ct,pt)