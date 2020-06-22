class Carro(object):

    __eficiencia = 0
    __combustivel = 0


def __init__(self, eficiencia, combustivel):
    self.__eficiencia = eficiencia
    self.__combustivel = combustivel


def setEficiencia(self, efitiente):
    self.__eficiencia = efitiente


def setCombustivel(self, gasosa):
    self.__combustivel = gasosa

def andar(self, km):

    if km > self.__combustivel * self.__eficiencia:
        print("Combustível insuficiente")

    return self.combustivel - km


def reabastecer(self, valor):

    return self.__combustivel + valor


def verificar_qtd_combustivel(self):

    return self.__combustivel
