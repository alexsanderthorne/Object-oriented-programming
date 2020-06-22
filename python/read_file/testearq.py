filename = "read_file/testearq2.txt"

with open(filename) as f:
    content = f.readlines()

for line in content:
    print(line)

