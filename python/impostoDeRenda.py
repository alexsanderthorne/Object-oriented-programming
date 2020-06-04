check = True
while check:

    print("*** *** ***")
    print("1.Cadastrar funcionário(nome e salário)\n2.Calcular imposto (procurar funcionário pelo nome)\n0.Sair")
    print("*** *** ***")

    op = 0
    op = int(input("Digite a opção desejada : "))

    if op == 1:

        nome = input("Digite o nome do Funcionario : ")
        salario = float(input("Digite o valor do salario : "))
        print("Funcionário cadastrado com sucesso!")

    elif op == 2:

        #nome = input("Digite o nome do Funcionario : ")
        print(nome)
        nomeFunc = input("Digite o nome do abençoado : ")
        print(nomeFunc)
        if nome == nomeFunc:

            def calcularImposto():
                if salario <= 2000:
                    return "no more trouble"
                elif salario > 2000 and salario <= 3500:
                    return salario * 0.15
                elif salario > 3500 and salario <= 5000:
                    return salario * 0.22
                else:
                    return salario * 0.30

            print(calcularImposto())
        else:
            print("Funcionário não encontrado.")

    elif op == 0:
        print("Logout ... ...")
        check = False
    else:
        print("Opção invalida")
