
print("\n\t\tBrute force attack on ceaser cipher\n")
message = input("Enter the encrypted message :")
print("")
for i in range(1,26):
    translated = ''
    for j in range(len(message)):
        extract = ord(message[j])-97
        decrypt_value = ((extract-i) % 26)+97
        translated += chr(decrypt_value)
    print('Hacking key #%s: %s' % (i, translated))