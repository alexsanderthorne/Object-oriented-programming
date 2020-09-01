from Carro import Carro

class Main(Carro):

    op = 0
    check = True
    c1 = Carro()

    while(check):

        print("1.Andar")
        print("2.Reabastecer")
        print("3.Verificar a quantidade de combustível")
        print("4.Encerrar a viagem")

        op = int(input("Digite a opção desejada : "))

    if op == 1:

        km = int(input("Digite a quilometragem : "))

        c1.carro.setEficiencia(20)
        c1.setCombustivel(100)
        c1.andar()
        print("viagem...")

    elif op == 2:

        valor = int(input("Digite a qtd em litros : "))
        Carro.Reabastecer(valor)

    elif op == 0:
        print("logout ...")
        check = False
