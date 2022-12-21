import numpy as np

key = np.random.randint(1,26)

def encrypt(s):
    a=""
    for c in s:
        if c!=' ':
            a+=chr((ord(c)-97+key) % 26 + 97)
        else: a+=' '
    return a

def decrypt(ct):
    p=""
    for c in ct:
        if c!=' ':
            p+=chr((ord(c)-97-key) % 26 + 97)
        else: p+=' '
    return p


# for attack
def attack(ct,pt):
    for i in range(1,26):
        p=""
        for c in ct:
            if c!=' ':
                p+=chr((ord(c)-97-i) % 26 + 97)
            else: p+=' '
        if p==pt:
            print(f'The detected key is: {i} and plaintext is: {p}')
            break


pt = input('Enter plain text:')
ct = encrypt(pt)
print('Cipher Text: '+ct)
p = decrypt(ct)
print('Plain Text after decryption: '+p)
attack(ct,pt)