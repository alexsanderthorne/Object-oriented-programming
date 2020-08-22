from time import sleep

idade = 0
sexo = ""
check = True
continua = ""
countAge = 0
countMen = 0
countWomen = 0


def cadastrarPessoa(check, countAge, countMen, countWomen):

    while(check):

        continua = input("Quer continuar? Digite y para sim e n para não. : ")

        if continua == "y":

            idade = int(input("Digite a idade : "))
            sexo = input("Digite o sexo : ")
            print("...")
            sleep(3)
            print("...")
            print("Pessoa cadastrada com sucesso!")
            print("Idade ", idade, "sexo", sexo)

            if idade >= 18:
                countAge += 1

            if sexo == "h":
                countMen += 1

            if idade <= 20 and sexo == "m":
                countWomen += 1

        elif continua == "n":

            check = False

        else:

            print("Opção inválida!")

    return "Pessoas maiores de 18 : ", countAge, " Homens cadastrados : ", countMen, " mulheres abaixo de 20 anos de idade : ", countWomen


print(cadastrarPessoa(check, countAge, countMen, countWomen))
